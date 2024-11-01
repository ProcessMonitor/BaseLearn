package com.cheems.controller;

import com.cheems.log.SyncLog;
import com.cheems.vo.UserDataVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class UserController {
    @SyncLog(taskName = "测试脱敏数据log")
    @PostMapping(value = "/deSensitiveData")
    public String deSensitiveData(UserDataVo userDataVo){

        System.out.println(userDataVo);


        return "userDataVo";
    }
    @GetMapping(value = "/hello")
    public String sayHello(UserDataVo userDataVo){

        System.out.println("hello");

        return "hello";
    }

}
