package com.shs.nxstudy.no3_annotation.test2_MyAnnotation;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: MyAnnotationTest <br/>
 * Description: <br/>
 * date: 2021/5/27 16:08<br/>
 *
 * @author Blue_sky<br />
 */
@MyAnnotation("注解在类上")
@RequestMapping("/aaaa")
public class MyAnnotationTest {
    @MyAnnotation("for Method")
    public void testMethod(){
        System.out.println("注解方法体");
    }
}