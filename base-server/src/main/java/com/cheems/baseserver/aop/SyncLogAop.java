package com.cheems.baseserver.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class SyncLogAop {

//    @Pointcut(value = "execution(* com.cheems.controller..*.*(..))")
    @Pointcut(value = "@annotation(com.cheems.baseserver.log.SyncLog)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("进入切面 ====== ");
        Object proceed = joinPoint.proceed((joinPoint.getArgs()));
        log.info("退出切面 ====== ");
        return proceed;
    }
}
