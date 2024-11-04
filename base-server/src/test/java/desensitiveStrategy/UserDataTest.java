package desensitiveStrategy;

import com.cheems.baseserver.utils.DeSensitiveUtil;
import com.cheems.baseserver.vo.UserDataVo;

public class UserDataTest {

    @org.junit.jupiter.api.Test
    void userDataDeSensitiveTest() throws IllegalAccessException {
        UserDataVo user =    UserDataVo.builder().name("John Doe").bankCard("123456789012345678").idCard("123456789012345678").build();

        System.out.println("Before desensitization: " + user);

        // 进行脱敏处理
        UserDataVo desensitizedUser = DeSensitiveUtil.desensitize(user);

        System.out.println("After desensitization: " + desensitizedUser);
    }
}


