package com.cheems.controller;

import com.cheems.vo.UserDataVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class UserController {

    @PostMapping(value = "/deSensitiveData")
    public String deSensitiveData(UserDataVo userDataVo){

        System.out.println(userDataVo);

        return "userDataVo";
    }

}
