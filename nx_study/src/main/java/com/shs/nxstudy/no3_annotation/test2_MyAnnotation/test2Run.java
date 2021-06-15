package com.shs.nxstudy.no3_annotation.test2_MyAnnotation;

import org.springframework.web.bind.annotation.RequestMapping;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ClassName: test2Run <br/>
 * Description: <br/>
 * date: 2021/5/27 16:10<br/>
 *
 * @author Blue_sky<br />
 */
public class test2Run {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<MyAnnotationTest> myAnnotationTestClass = MyAnnotationTest.class;
        Annotation[] annotations = myAnnotationTestClass.getAnnotations();

        for (Annotation annotation : annotations) {
            System.out.println(annotation.getClass().getName());
            String name = annotation.annotationType().getName();//注解名称是项目包路径
            if(name.contains("MyAnnotation")){
                MyAnnotation annotation1 = myAnnotationTestClass.getAnnotation(MyAnnotation.class);
                System.out.println("MyAnnotation注解值："+annotation1.value());
            }else if(name.contains("RequestMapping")){
                RequestMapping annotation1 = myAnnotationTestClass.getAnnotation(RequestMapping.class);
                System.out.println("RequestMapping注解值："+annotation1.value());
            }
            System.out.println("注解名称"+name);

        }
        Method[] methods = myAnnotationTestClass.getMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent(MyAnnotation.class)){
                MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
                System.out.println("注解值："+annotation.value());
                method.invoke(myAnnotationTestClass.newInstance(),new Class[]{});
            }
        }


    }
}