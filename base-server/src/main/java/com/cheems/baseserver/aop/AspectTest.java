package com.cheems.baseserver.aop;

import com.cheems.baseserver.log.Axin;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

@Aspect
@Component
public class AspectTest {

    /**
     * 这里定义了一个总的匹配规则，以后拦截的时候直接拦截log()方法即可，无须去重复写execution表达式
     */
    @Pointcut("@annotation(com.cheems.baseserver.log.Axin)")
    public void log() {
    }

    @Before("log() && @annotation(axin)")
    public void doBefore(JoinPoint joinPoint, Axin axin) {
        System.out.println("******拦截前的逻辑******");
        System.out.println("目标方法名为:" + joinPoint.getSignature().getName());
        System.out.println("目标方法所属类的简单类名:" + joinPoint.getSignature().getDeclaringType().getSimpleName());
        System.out.println("目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("目标方法声明类型:" + Modifier.toString(joinPoint.getSignature().getModifiers()));
        //获取传入目标方法的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println("第" + (i + 1) + "个参数为:" + args[i]);
        }
        System.out.println("被代理的对象:" + joinPoint.getTarget());
        System.out.println("代理对象自己:" + joinPoint.getThis());

        System.out.println("拦截的注解的参数：");
        System.out.println(axin.module());
        System.out.println(axin.description());
    }

    @Around("log() && @annotation(axin)")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint, Axin axin) throws Throwable {
        System.out.println("环绕通知：");
        System.out.println(axin.module());
        System.out.println(axin.description());
        Object result = null;
        result = proceedingJoinPoint.proceed();
        return result;
    }

    @After("log()")
    public void doAfter() {
        System.out.println("******拦截后的逻辑******");
    }

}
