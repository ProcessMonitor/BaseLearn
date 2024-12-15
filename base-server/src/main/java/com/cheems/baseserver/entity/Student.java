package com.cheems.baseserver.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@TableName(value = "tb_student")
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @TableId
    private String id;

    private String stuName;

    private String stuAge;

    private String stuScore;


    @TableField(exist = false)
    private String banji;

    @TableField(exist = false)
    private Date createTime;

}
