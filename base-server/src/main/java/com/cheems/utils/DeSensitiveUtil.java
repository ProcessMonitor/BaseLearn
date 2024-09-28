package com.cheems.utils;

import com.cheems.api.DesensitiveStrategy;
import com.cheems.config.annotation.Desensitive;
import com.cheems.entity.enums.DesensitiveType;

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
        // 获取对象的所有字段
        Field[] fields = clazz.getDeclaredFields();
        // 遍历字段
        for (Field field : fields) {
            // 检查是否有 @Desensitive 注解
            if (field.isAnnotationPresent(Desensitive.class)) {
                // 获取注解
                Desensitive annotation = field.getAnnotation(Desensitive.class);
                // 获取注解中的类型
                DesensitiveType type = annotation.type();

                // 获取脱敏策略
                DesensitiveStrategy strategy = DesensitiveStrategyFactory.getStrategy(type);

                field.setAccessible(true);  // 确保可以访问私有字段
                Object value = field.get(obj);  // 获取字段的值

                if (value instanceof String) {
                    String desensitizedValue = strategy.desensitize((String) value);
                    field.set(obj, desensitizedValue);  // 设置脱敏后的值
                }
            }
        }
        return obj;
    }
}
