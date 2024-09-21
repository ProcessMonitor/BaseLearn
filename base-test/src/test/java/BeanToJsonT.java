import dto.MockDemoDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

public class BeanToJsonT {
    @Test
    void BeanPropertiesTest(){
        MockDemoDto source = null;
        MockDemoDto target = null;
        BeanUtils.copyProperties(source , target);
    }
}
