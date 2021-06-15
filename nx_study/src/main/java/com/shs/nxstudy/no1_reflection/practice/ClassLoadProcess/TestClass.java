package com.shs.nxstudy.no1_reflection.practice.ClassLoadProcess;

public class TestClass {
    public static void main(String[] args) throws Exception{
        //类的装载过程（加载、连接、初始化）
        //class字节码--》加载--》连接（验证、准备、解析）--》初始化--》class对象
        Class sonClass = Son.class;
        //Son类中的b变量是类变量所以直接可以用Son.b
        int b = Son.b;
        Son sonObj = (Son)sonClass.newInstance();
        //Son类中的c变量是成员变量（实例化变量）所以要用Son的实例化对象调用c变量
        int c = sonObj.c;

        System.out.println(b);
        System.out.println("我是C"+c);

    }
}
