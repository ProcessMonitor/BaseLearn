package com.cheems.api.impl;

import com.cheems.api.DesensitiveStrategy;
import com.cheems.entity.enums.DesensitiveType;

public class BankCardDesensitiveStartegy implements DesensitiveStrategy {
    @Override
    public boolean isSupport(DesensitiveType target) {
        return target.equals(DesensitiveType.BANK_CARD);
    }

    @Override
    public String desensitize(String bankCard) {
        if (bankCard == null || bankCard.length() < 4) {
            return bankCard;
        }
        return "**** **** **** " + bankCard.substring(bankCard.length() - 4);
    }
}
