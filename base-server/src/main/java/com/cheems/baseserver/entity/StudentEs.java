package com.cheems.baseserver.entity;

import lombok.Data;
import org.dromara.easyes.annotation.IndexName;

@Data
@IndexName
public class StudentEs {
    /**
     * es id
     */
    private String id;
    /**
     * es stu name
     */
    private String name;
    /**
     * es stu sex
     */
    private String sex;
}
