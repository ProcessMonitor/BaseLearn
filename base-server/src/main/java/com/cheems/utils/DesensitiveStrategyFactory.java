package com.cheems.utils;

import com.cheems.api.DesensitizeStrategy;
import com.cheems.api.impl.BankCardDesensitizeStrategy;
import com.cheems.api.impl.IdCardDesensitizeStrategy;
import com.cheems.api.impl.NameDesensitizeStrategy;
import com.cheems.entity.enums.DesensitiveType;

import java.util.HashMap;
import java.util.Map;

public class DesensitiveStrategyFactory {

    private static final Map<DesensitiveType, DesensitizeStrategy> strategyMap = new HashMap<>();

    static {
        strategyMap.put(DesensitiveType.NAME, new NameDesensitizeStrategy());
        strategyMap.put(DesensitiveType.ID_CARD, new IdCardDesensitizeStrategy());
        strategyMap.put(DesensitiveType.BANK_CARD, new BankCardDesensitizeStrategy());
        strategyMap.put(DesensitiveType.DEFAULT, new NameDesensitizeStrategy());
    }

    public static DesensitizeStrategy getStrategy(DesensitiveType type) {
        return strategyMap.get(type);
    }
}
