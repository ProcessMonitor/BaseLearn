package com.cheems.baseserver.api.impl;

import com.cheems.baseserver.entity.enums.DesensitiveType;
import com.cheems.baseserver.api.DesensitizeStrategy;

public class IdCardDesensitizeStrategy implements DesensitizeStrategy<String> {

    @Override
    public boolean isSupport(DesensitiveType target) {
        return target.equals(DesensitiveType.ID_CARD);
    }

    @Override
    public String desensitize(String idCard) {
        if (idCard == null || idCard.length() < 10) {
            return idCard;
        }
        return idCard.substring(0, 6) + "****" + idCard.substring(idCard.length() - 4);
    }
}
