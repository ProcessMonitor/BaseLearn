package com.cheems.baseserver.config;

import com.cheems.baseserver.entity.User;
import com.cheems.baseserver.service.UserService;
import org.springframework.context.annotation.Bean;

import java.util.Date;

public class AppConfig {
    public static final String APP_NAME = "baseserver";

    //加载UserService
    @Bean
    public UserService getUserService(){
        return new UserService();
    }
    // 加载User
    @Bean
    public User getUser(){
        return new User();
    }

    @Bean
    public Date getNowDate(){
        return new Date();
    }
}
