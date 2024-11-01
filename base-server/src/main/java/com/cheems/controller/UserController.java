package com.cheems.controller;

import com.cheems.log.SyncLog;
import com.cheems.utils.DeSensitiveUtil;
import com.cheems.vo.UserDataVo;
import com.swak.frame.dto.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class UserController {
    @SyncLog(taskName = "测试脱敏数据log")
    @PostMapping(value = "/deSensitiveData")
    public Response<UserDataVo> deSensitiveData(@RequestBody UserDataVo userDataVo) {
        System.out.println(userDataVo);
        UserDataVo dataVo = userDataVo;
        try {
            dataVo = DeSensitiveUtil.desensitize(userDataVo);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        System.out.println(dataVo);
        return Response.success(dataVo);
    }
    @GetMapping(value = "/hello")
    public String sayHello(UserDataVo userDataVo) {

        System.out.println("hello");

        return "hello";
    }

}
