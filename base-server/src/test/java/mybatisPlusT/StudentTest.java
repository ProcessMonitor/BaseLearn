package mybatisPlusT;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.cheems.baseserver.BaseServerApplication;
import com.cheems.baseserver.entity.Student;
import com.cheems.baseserver.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = BaseServerApplication.class)
@MapperScan("com.cheems.baseserver.mapper")
public class StudentTest {

    @Resource
    private StudentMapper studentMapper;


    @Test
    public void testSelectStudentList() {
        System.out.println(studentMapper.selectStudentList());
    }

    @Test
    public void testInsertStudentList() {
        //
        List<Student> students = new ArrayList<>();
        students.add(new Student("S" + IdWorker.getId(), "张三", "23", "90", "1", new Date()));
        students.add(new Student("S" + IdWorker.getId(), "李四", "24", "90", "1", new Date()));


        studentMapper.insertStudentList(students);

//        studentMapper.delete(QueryWrapper )

    }

}
