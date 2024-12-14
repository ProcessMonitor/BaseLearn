import com.cheems.baseserver.BaseServerApplication;
import com.cheems.baseserver.chain.ApplyCommandChainFactory;
import com.cheems.baseserver.dto.ApplyDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@SpringBootTest(classes = BaseServerApplication.class)
@ComponentScan
@Configuration
public class ChainTest {

    @Resource
    private ApplyCommandChainFactory applyCommandChainFactory;

    @Test
    public void chainTest() {
        applyCommandChainFactory.execute(new ApplyDto());
    }
}
