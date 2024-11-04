package com.cheems.baseserver.api.impl;

import com.cheems.baseserver.api.DesensitizeStrategy;
import com.cheems.baseserver.entity.enums.DesensitiveType;

public class BankCardDesensitizeStrategy implements DesensitizeStrategy<String> {
    @Override
    public boolean isSupport(DesensitiveType target) {
        return target.equals(DesensitiveType.BANK_CARD);
    }

    @Override
    public String desensitize(String bankCard) {

        // 判断是否为BandCard String 类型
        if (!(bankCard instanceof String)) {
            return bankCard;
        }

        if (bankCard == null || bankCard.length() < 4) {
            return bankCard;
        }
        return "**** **** **** " + bankCard.substring(bankCard.length() - 4);
    }
}
