package com.cheems.utils;

import com.cheems.api.DesensitiveStrategy;
import com.cheems.api.impl.BankCardDesensitiveStartegy;
import com.cheems.api.impl.IdCardDesensitiveStrategy;
import com.cheems.api.impl.NameDesensitiveStrategy;
import com.cheems.entity.enums.DesensitiveType;

import java.util.HashMap;
import java.util.Map;

public class DesensitiveStrategyFactory {

    private static final Map<DesensitiveType, DesensitiveStrategy> strategyMap = new HashMap<>();

    static {
        strategyMap.put(DesensitiveType.NAME, new NameDesensitiveStrategy());
        strategyMap.put(DesensitiveType.ID_CARD, new IdCardDesensitiveStrategy());
        strategyMap.put(DesensitiveType.BANK_CARD, new BankCardDesensitiveStartegy());
    }

    public static DesensitiveStrategy getStrategy(DesensitiveType type) {
        return strategyMap.get(type);
    }
}
