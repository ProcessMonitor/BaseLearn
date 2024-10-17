package com.cheems.vo;

import com.cheems.config.annotation.Desensitize;
import com.cheems.entity.enums.DesensitiveType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDataVo {

    @Desensitize(type = DesensitiveType.NAME)
    String name;

    @Desensitize(type = DesensitiveType.ADDRESS)
    String address;

    @Desensitize(type = DesensitiveType.PHONE)
    String phone;

    @Desensitize(type = DesensitiveType.EMAIL)
    String email;

    @Desensitize(type = DesensitiveType.ID_CARD)
    String idCard;

    @Desensitize(type = DesensitiveType.BANK_CARD)
    String bankCard;


}
