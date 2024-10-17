package com.cheems.config.annotation;

import com.cheems.entity.enums.DesensitiveType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)  // 作用于字段
@Retention(RetentionPolicy.RUNTIME)  // 在运行时有效
public @interface Desensitize {
    DesensitiveType type() default DesensitiveType.DEFAULT;  // 指定脱敏类型
}
