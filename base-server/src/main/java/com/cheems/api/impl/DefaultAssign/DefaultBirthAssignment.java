package com.cheems.api.impl.DefaultAssign;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public enum DefaultBirthAssignment {

    /**
     * 默认时间
     */
    DEFAULT_BIRTH_DATE(Date.from(LocalDateTime.of(1990, 1, 1, 0, 0, 0)
            .atZone(ZoneId.systemDefault()).toInstant()));

    private final Date date;


    DefaultBirthAssignment(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public static DefaultBirthAssignment getDefaultBirthAssignment(String value) {
        return DefaultBirthAssignment.valueOf(value);
    }

    // 获得默认时间（String类型）
    public static String getDefaultBirthAssignmentString() {
        return String.valueOf(DEFAULT_BIRTH_DATE.getDate());
    }

    // 获得默认时间（Date类型）
    public static Date getDefaultBirthAssignmentDate() {
        return DEFAULT_BIRTH_DATE.getDate();
    }
}
