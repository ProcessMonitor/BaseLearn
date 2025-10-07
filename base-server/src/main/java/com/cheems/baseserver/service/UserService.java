package com.cheems.baseserver.service;

import com.cheems.baseserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//@Component
public class UserService {

//    @Resource
    private User user;

    public void test()
    {
        System.out.println(user);
    }

}



