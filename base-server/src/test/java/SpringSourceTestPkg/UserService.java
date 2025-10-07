package SpringSourceTestPkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserService {

    @Autowired
    private User user;

    public void test()
    {
        System.out.println(a());
    }

    @Lookup("user")
    public User a()
    {
        return user;
    }

}
