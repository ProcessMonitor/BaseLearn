package com.cheems.baseserver.utils;

import com.cheems.baseserver.api.DesensitizeStrategy;
import com.cheems.baseserver.api.impl.BankCardDesensitizeStrategy;
import com.cheems.baseserver.api.impl.DefaultDesensitizeStrategy;
import com.cheems.baseserver.api.impl.IdCardDesensitizeStrategy;
import com.cheems.baseserver.api.impl.NameDesensitizeStrategy;
import com.cheems.baseserver.entity.enums.DesensitiveType;

import java.util.HashMap;
import java.util.Map;

public class DesensitizeStrategyFactory {

    private static final Map<DesensitiveType, DesensitizeStrategy> strategyMap = new HashMap<>();

    static {
        strategyMap.put(DesensitiveType.NAME, new NameDesensitizeStrategy());
        strategyMap.put(DesensitiveType.ID_CARD, new IdCardDesensitizeStrategy());
        strategyMap.put(DesensitiveType.BANK_CARD, new BankCardDesensitizeStrategy());
        strategyMap.put(DesensitiveType.DEFAULT, new DefaultDesensitizeStrategy());
    }

    public static DesensitizeStrategy getStrategy(DesensitiveType type) {
        return strategyMap.get(type);
    }
}
