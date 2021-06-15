package com.shs.nxstudy.no1_reflection.practice.ClassLoader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassLoaderTest {
    public void ClassLoading(String path,int key) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ClassLoaderDIY cldiy = new ClassLoaderDIY();
        //自定义ClassLoader加载字节码
        Class<?> classLoaderTxtC = cldiy.findClass(path);
        Class[] typeList = new Class[1];
        typeList[0] = int.class;
        Object [] valueList = new Object[1];
        valueList[0] = key;
        //构造器参数是类型
        Constructor<?> declaredConstructor = classLoaderTxtC.getDeclaredConstructor(typeList);
        //实例化类，有参或无参构造器
        //实例化时入参是值
        declaredConstructor.newInstance(valueList);
        classLoaderTxtC.newInstance();
    }

    public static void main(String[] args) {
        ClassLoaderTest clt = new ClassLoaderTest();
        try {
            clt.ClassLoading("D:\\ClassLoaderTxt.class",2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
