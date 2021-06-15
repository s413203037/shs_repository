package com.shs.nxstudy.no1_reflection.commit.scanPackage;

import com.shs.nxstudy.no1_reflection.practice.test.Test;

import java.lang.reflect.Method;

public class AnnotationTest {

    public static void scanTestAnnotation(Class<?> clazz){
        Method[] declaredMethods = clazz.getDeclaredMethods();
        int hasTestAnnCount = 0;//有注解方法的个数
        int hasExeCount = 0;//异常个数
        if(null != declaredMethods && declaredMethods.length > 0){
            for (int i = 0; i < declaredMethods.length; i++) {
                //                Annotation annotation = declaredMethods[i].getAnnotation(Test.class);
                //                System.out.println(annotation.toString());
                boolean annotationPresent = declaredMethods[i].isAnnotationPresent(Test.class);
                if(annotationPresent){
                    try {
                        declaredMethods[i].invoke(null);
                    } catch (Throwable ex) {
                        System.out.printf("Test %s faild:%s %n",declaredMethods[i],ex.getCause());
                        hasExeCount++;
                    }
                    hasTestAnnCount++;
                }
            }
        }
        System.out.println("有" + hasTestAnnCount + "个测试类注解存在");
        System.out.println("有" + hasExeCount + "个异常");
    }
}
