package com.shs.nxstudy.no1_reflection.practice.ClassLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Author 沈会山
 * @Description //自定义类加载器
 * @Date 11:27 2020/7/19
 * @Param
 * @return
 **/
public class ClassLoaderDIY extends ClassLoader {
    public Class<?> findClass(String pathName) throws ClassNotFoundException {
        Class<?> classLoaderTxt = null;
        try {
            System.out.println("DIY-ClassLoader开始加载...");
            byte[] loadByte = Files.readAllBytes(Paths.get(pathName));
            classLoaderTxt = defineClass("ClassLoaderTxt", loadByte, 0, loadByte.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(classLoaderTxt == null){
            throw new ClassNotFoundException(pathName);
        }else{
            return classLoaderTxt;
        }
    }
}
