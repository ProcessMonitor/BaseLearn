package SpringSourceTestPkg;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

public class MainAppTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(ConfigurationDemo.class);
//        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
//        Stream.of(beanDefinitionNames).forEach(System.out::println);
        UserService userServiceBean = ctx.getBean(UserService.class);
        UserService userServiceBean1 = ctx.getBean(UserService.class);
        userServiceBean.test();
        userServiceBean1.test();
    }
}
