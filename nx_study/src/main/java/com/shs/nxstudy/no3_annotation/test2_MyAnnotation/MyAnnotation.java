package com.shs.nxstudy.no3_annotation.test2_MyAnnotation;

import java.lang.annotation.*;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/5/27 16:03<br/>
 *
 * @author Blue_sky<br />
 * @since JDK 1.8
 */
@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "这是shs的注解";
}
