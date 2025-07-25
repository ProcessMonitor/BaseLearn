package com.cheems.baseserver;

import org.dromara.easyes.starter.register.EsMapperScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EsMapperScan("com.cheems.baseserver.mapper.es.**")
@MapperScan("com.cheems.baseserver.mapper.**")
public class BaseServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseServerApplication.class, args);
    }
}