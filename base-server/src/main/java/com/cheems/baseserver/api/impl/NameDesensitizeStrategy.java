package com.cheems.baseserver.api.impl;

import com.cheems.baseserver.api.DesensitizeStrategy;
import com.cheems.baseserver.entity.enums.DesensitiveType;

public class NameDesensitizeStrategy implements DesensitizeStrategy<String> {
    @Override
    public boolean isSupport(DesensitiveType target) {
        return target.equals(DesensitiveType.NAME);
    }

    @Override
    public String desensitize(String name) {
        if (name == null || name.length() < 2) {
            return name;
        }
        return name.charAt(0) + "*".repeat(name.length() - 1);
    }
}
