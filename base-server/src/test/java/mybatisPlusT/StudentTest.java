package mybatisPlusT;


import com.cheems.baseserver.BaseServerApplication;
import com.cheems.baseserver.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = BaseServerApplication.class)
@MapperScan("com.cheems.baseserver.mapper")
public class StudentTest {

    @Resource
    private StudentMapper studentMapper;


    @Test
    public void testSelectStudentList(){
        System.out.println(studentMapper.selectStudentList());
    }

}
