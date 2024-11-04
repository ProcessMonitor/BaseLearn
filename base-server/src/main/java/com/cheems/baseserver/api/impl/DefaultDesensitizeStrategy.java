package com.cheems.baseserver.api.impl;

import com.cheems.baseserver.api.DesensitizeStrategy;
import com.cheems.baseserver.entity.enums.DesensitiveType;

public class DefaultDesensitizeStrategy implements DesensitizeStrategy<String> {
    @Override
    public boolean isSupport(DesensitiveType target) {
        return target.equals(DesensitiveType.NAME);
    }

    @Override
    public String desensitize(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }
        // 默认脱敏策略 仅保留第一个字符
        return str.charAt(0) + "*".repeat(str.length() - 1);
    }
}
