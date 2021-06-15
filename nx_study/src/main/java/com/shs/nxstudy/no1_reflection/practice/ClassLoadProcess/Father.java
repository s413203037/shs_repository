package com.shs.nxstudy.no1_reflection.practice.ClassLoadProcess;

public class Father {
    private String work;

    public static int a = 1;
    public Father(){

    }
    public Father(String work){
        this.work = work;
    }
    static {
        System.out.println(a);
        System.out.println("Father Class Static Loading");
    }
}
