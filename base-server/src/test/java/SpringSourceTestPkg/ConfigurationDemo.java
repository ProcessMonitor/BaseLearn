package SpringSourceTestPkg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class ConfigurationDemo {

    @Bean
    public Date getNowDate(){
        return new Date();
    }
}