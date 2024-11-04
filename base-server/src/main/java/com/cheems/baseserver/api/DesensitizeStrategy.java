package com.cheems.baseserver.api;

import com.cheems.baseserver.entity.enums.DesensitiveType;

public interface DesensitizeStrategy<T> {
    // 判断是否为脱敏类型
    boolean isSupport(DesensitiveType target);

    // 脱敏
    T desensitize(T target);
}
