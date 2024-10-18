//package com.cheems.baseapi.feign.config;
//
//import com.cheems.baseapi.feign.ApplyClient;
//import com.cheems.baseapi.feign.ResultClient;
//import feign.Contract;
//import feign.Feign;
//import feign.Request;
//import feign.codec.Decoder;
//import feign.codec.Encoder;
//import jakarta.annotation.Nonnull;
//import jakarta.annotation.Resource;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.BeanFactoryAware;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.support.DefaultListableBeanFactory;
//import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
//import org.springframework.cloud.openfeign.FeignClientsConfiguration;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.EnvironmentAware;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.core.env.EnumerablePropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.core.env.MutablePropertySources;
//import org.springframework.web.context.support.StandardServletEnvironment;
//
//import java.util.concurrent.TimeUnit;
//
//
//
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//
//@Slf4j
//@Configuration
//@Import(FeignClientsConfiguration.class)
//public class FeignClientFactory implements EnvironmentAware, BeanFactoryAware, InitializingBean, ApplicationListener<EnvironmentChangeEvent> {
//
//    @Resource
//    private Contract contract;
//    @Resource
//    private Decoder decoder;
//    @Resource
//    private Encoder encoder;
//
//    private Environment environment;
//    private BeanFactory beanFactory;
//
//    public static final Map<String, Object> FEIGN_CLIENT_MAP = new HashMap<>();
//    private static final Map<String, String> REGION_2_HOST_MAP_CONFIG = new HashMap<>();
//
//    private static final String readTimeoutKey = "middlebase.feign.readTimeout";
//    private static final String connectTimeoutKey = "middlebase.feign.connectTimeout";
//
//    private static final List<Class<?>> FEIGN_CLIENT_CLASSES = List.of(ApplyClient.class, ResultClient.class);
//
//    @SuppressWarnings("unchecked")
//    public static <T> T getClient(String region, Class<T> clazz) {
//        Object client = FEIGN_CLIENT_MAP.get(getBeanName(region, clazz));
//        Objects.requireNonNull(client, String.format("没有地区【%s】的配置信息", region));
//        return (T) client;
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        Map<String, String> region2HostMapConfig = getRegion2HostMapConfig();
//
//        if (!region2HostMapConfig.isEmpty()) {
//            for (Map.Entry<String, String> entry : region2HostMapConfig.entrySet()) {
//                registerFeignClient(entry.getKey(), entry.getValue());
//            }
//        }
//    }
//
//    private Map<String, String> getRegion2HostMapConfig() {
//        String enableKey = "middlebase.region.enable";
//        Boolean enable = getProperty(enableKey, Boolean.class, false);
//
//        if (!enable) {
//            return Map.of();
//        }
//
//        try {
//            String regionMappingKeyPrefix = "middlebase.region.mapping.";
//
//            List<String> region2HostMappingKeys = new ArrayList<>();
//
//            MutablePropertySources propertySources = ((StandardServletEnvironment) environment).getPropertySources();
//            propertySources.forEach(p -> {
//                if (p instanceof EnumerablePropertySource) {
//                    String[] propertyNames = ((EnumerablePropertySource<?>) p).getPropertyNames();
//
//                    for (String propertyName : propertyNames) {
//                        if (propertyName.startsWith(regionMappingKeyPrefix)) {
//                            region2HostMappingKeys.add(propertyName);
//                        }
//                    }
//                }
//            });
//
//            Map<String, String> region2HostMap = new HashMap<>();
//            for (String region2HostKey : region2HostMappingKeys) {
//                String region = region2HostKey.replace(regionMappingKeyPrefix, "");
//                String host = getProperty(region2HostKey, String.class, "");
//                if (StringUtils.isBlank(host)) {
//                    throw new IllegalArgumentException("region2HostMapping配置错误，region：" + region + "，host：" + host);
//                }
//                region2HostMap.put(region, host);
//            }
//            return region2HostMap;
//        } catch (Exception e) {
//            log.error("获取region2HostMapping失败", e);
//            return Map.of();
//        }
//    }
//
//    private void registerFeignClient(String region, String host) {
//        Long connectTimeout = getProperty(connectTimeoutKey, Long.class, 1L);
//        Long readTimeout = getProperty(readTimeoutKey, Long.class, 30L);
//        log.info("Feign配置：Region：{}，Host：{}，connectTimeout：{}，readTimeout：{}", region, host, connectTimeout, readTimeout);
//        Request.Options options = new Request.Options(connectTimeout, TimeUnit.MINUTES, readTimeout, TimeUnit.MINUTES, true);
//
//        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) beanFactory;
//        FEIGN_CLIENT_CLASSES.forEach(clazz -> {
//            Object feignClient = Feign.builder().options(options).contract(contract)
//                    .encoder(encoder).decoder(decoder).target(clazz, host);
//            String beanName = getBeanName(region, clazz);
//            log.info("注册FeignClient到容器中，beanName：{}，FeignClient：{}", beanName, feignClient);
//
//            defaultListableBeanFactory.registerSingleton(beanName, feignClient);
//            FEIGN_CLIENT_MAP.put(beanName, feignClient);
//        });
//    }
//
//    public <T> T getProperty(String key, Class<T> clazz, T defaultValue) {
//        return environment.getProperty(key, clazz, defaultValue);
//    }
//
//    public static <T> String getBeanName(String region, Class<T> clazz) {
//        return region + clazz.getSimpleName();
//    }
//
//    @Override
//    public void setBeanFactory(@Nonnull BeanFactory beanFactory) throws BeansException {
//        this.beanFactory = beanFactory;
//    }
//
//    @Override
//    public void setEnvironment(@Nonnull Environment environment) {
//        this.environment = environment;
//    }
//
//    @Override
//    public void onApplicationEvent(@Nonnull EnvironmentChangeEvent event) {
//        log.info("============EnvironmentChangeEvent============");
//        try {
//            synchronized (REGION_2_HOST_MAP_CONFIG) {
//                Map<String, String> region2HostMapConfig = getRegion2HostMapConfig();
//                log.info("region2HostMapConfig：{}", region2HostMapConfig);
//
//                if (needReregister(region2HostMapConfig)) {
//                    // 先将旧的FeignClient从容器中destroy
//                    FEIGN_CLIENT_MAP
//                            .keySet()
//                            .forEach(beanName -> ((DefaultListableBeanFactory) beanFactory).destroySingleton(beanName));
//                    FEIGN_CLIENT_MAP.clear();
//
//                    for (Map.Entry<String, String> entry : region2HostMapConfig.entrySet()) {
//                        registerFeignClient(entry.getKey(), entry.getValue());
//                    }
//
//                    REGION_2_HOST_MAP_CONFIG.clear();
//                    REGION_2_HOST_MAP_CONFIG.putAll(region2HostMapConfig);
//                }
//            }
//        } catch (Exception e) {
//            log.error("重新注册FeignClient异常：", e);
//        }
//    }
//
//    public boolean needReregister(Map<String, String> region2HostMapConfig) {
//        if (region2HostMapConfig.size() != REGION_2_HOST_MAP_CONFIG.size()) {
//            return true;
//        }
//
//        for (Map.Entry<String, String> entry : REGION_2_HOST_MAP_CONFIG.entrySet()) {
//            String region = entry.getKey();
//            String host = entry.getValue();
//
//            if (!host.equalsIgnoreCase(region2HostMapConfig.get(region))) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//}
