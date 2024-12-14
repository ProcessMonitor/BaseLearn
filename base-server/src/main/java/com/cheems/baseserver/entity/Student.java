package com.cheems.baseserver.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "tb_student")
public class Student {

    @TableId
    private String id;

    private String stuName;

    private String stuAge;

    private String stuScore;

    private String banji;

    private Date createTime;

}
