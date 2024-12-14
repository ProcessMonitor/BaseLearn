package com.cheems.baseserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cheems.baseserver.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 查询所有学生列表
     *
     * @return 学生列表
     */
    List<Student> selectStudentList();


    /**
     * 插入list 注解为辅助
     */
    @Insert(
            "<script>" +
                    "insert into tb_student(id, stu_name, stu_age ) values " +
                    "<foreach collection='list' item='student' separator=','>" +
                    " (#{student.id}, #{student.stuName}, #{student.stuAge})" +
                    "</foreach>" +
                    "</script>"
    )
    void insertStudentList(@Param("list") List<Student> students);
}
