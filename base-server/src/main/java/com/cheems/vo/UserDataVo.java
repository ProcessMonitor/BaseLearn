package com.cheems.vo;

import com.alibaba.fastjson.annotation.JSONField;
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

    @JSONField(name = "name")
    @Desensitize(type = DesensitiveType.NAME)
    String name;

    @JSONField(name = "address")
    String address;

    String phone;

    String email;

    String idCard;

    @JSONField(name = "bankCard")
    @Desensitize(type = DesensitiveType.BANK_CARD)
    String bankCard;


}
