package com.cheems.baseserver.mapper;

import com.cheems.baseserver.entity.Student;

import java.util.List;

public interface StudentMapper {

    /**
     * 查询所有学生列表
     *
     * @return 学生列表
     */
    List<Student> selectStudentList();
}
