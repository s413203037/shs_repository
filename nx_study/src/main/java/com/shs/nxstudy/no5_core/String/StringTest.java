package com.shs.nxstudy.no5_core.String;

public class StringTest {
    public static void main(String[] args) {
        String a1 = "aaa";
        System.out.println("改变前a1的hashcode >>>" + a1.hashCode());
        a1 += "bbb";
        System.out.println("改变后a1的hashcode >>>" + a1.hashCode());
        //这个在jvm过程是，
        //1、先创建一个a1的String对象，常量池新增一个“aaa”的值，并将这个常量池里的“aaa”引用指向a1,
        //2、常量池新增一个“bbb”的值,
        //3、然后new 一个StringBuilder对象，这个对象最后进行拼接成“aaabbb”，最后将“aaabbb”对象引用指向a1,

        //备注：所写的代码，例如类名：StringTest，变量名a1,类型：java.lang.String,等等都会在编译时
        //存放在常量池中的UTF-8
    }
}
