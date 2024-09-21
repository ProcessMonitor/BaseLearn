package com.cheems.vo;

import com.cheems.config.Desensitive;
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

    @Desensitive(type = DesensitiveType.NAME)
    String name;

    @Desensitive(type = DesensitiveType.ADDRESS)
    String address;

    @Desensitive(type = DesensitiveType.PHONE)
    String phone;

    @Desensitive(type = DesensitiveType.EMAIL)
    String email;

    @Desensitive(type = DesensitiveType.ID_CARD)
    String idCard;

    @Desensitive(type = DesensitiveType.BANK_CARD)
    String bankCard;


}
