package com.cheems.baseserver.log;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Axin {

    /**
     * 所属模块
     * @return
     */
    String module() default "log module";


    /**
     * 动作描述
     * @return
     */
    String description() default "无动作";
}
