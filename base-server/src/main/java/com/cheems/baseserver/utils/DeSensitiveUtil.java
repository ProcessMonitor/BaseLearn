package com.cheems.baseserver.utils;

import com.cheems.baseserver.api.DesensitizeStrategy;
import com.cheems.baseserver.config.annotation.Desensitize;
import com.cheems.baseserver.entity.enums.DesensitiveType;

import java.lang.reflect.Field;

public class DeSensitiveUtil {
    /**
     * 将 obj 进行脱敏处理
     * @param obj
     * @return
     * @param <T>
     * @throws IllegalAccessException
     */
    public static <T> T desensitize(T obj) throws IllegalAccessException {
        // 获取对象的类
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            // 检查是否有 @Desensitive 注解
            if (field.isAnnotationPresent(Desensitize.class)) {
                // 获取注解
                Desensitize annotation = field.getAnnotation(Desensitize.class);
                // 获取注解中的类型
                DesensitiveType type = annotation.type();

                // 获取脱敏策略
                DesensitizeStrategy<?> strategy = DesensitizeStrategyFactory.getStrategy(type);

                field.setAccessible(true);  // 确保可以访问私有字段
                Object value = field.get(obj);  // 获取字段的值

                // 不符合脱敏策略的字段不脱敏 否则会 NullPointerException
                if (value != null && strategy != null) {
                    Object desensitizedValue = applyDesensitization(strategy, value);
                    field.set(obj, desensitizedValue);  // 设置脱敏后的值
                }
            }
        }
        return obj;
    }

    // 泛型方法应用脱敏策略
    private static <T> T applyDesensitization(DesensitizeStrategy<T> strategy, Object value) {
        return strategy.desensitize((T) value);
    }

}
