package com.shs.nxstudy.no5_core.String;

public class ChangeString {

    public static void main(String[] args) {
        String aa = "aaa";
        String bb = "aaa";
        changeString(aa);
        System.out.println(aa == bb);// true,两个变量值相同，对于String类 == 号比的是值，（其他比的内存地址）
        System.out.println(aa.equals("bbb"));//false
    }

    public static void changeString(String str){
        str = "bbb";//此处是形参，不能改变入参的值，作用域不一样
    }
}
