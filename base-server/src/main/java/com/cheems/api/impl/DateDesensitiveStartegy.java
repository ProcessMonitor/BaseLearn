package com.cheems.api.impl;

import com.cheems.api.DesensitiveStrategy;
import com.cheems.entity.enums.DesensitiveType;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDesensitiveStartegy implements DesensitiveStrategy<Date> {
    @Override
    public boolean isSupport(DesensitiveType target) {
        return false;
    }

    @Override
    public Date desensitize(Date targetDate) {
        // 对日期进行脱敏处理，例如只显示年份
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String yearOnly = sdf.format(targetDate);

        // 可以选择返回 Date 类型或转换为 String 显示部分信息
        // 为了简单，返回当前年的第一天
        try {
            return sdf.parse(yearOnly);
        } catch (Exception e) {
            return null;  // 处理异常情况
        }
    }
}
