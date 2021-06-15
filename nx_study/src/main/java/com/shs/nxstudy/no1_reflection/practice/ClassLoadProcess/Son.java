package com.shs.nxstudy.no1_reflection.practice.ClassLoadProcess;

public class Son extends Father {
    private String game;
    public int c = 1;
    public static int b = 3;
    public Son(){
        super();
    }
    public Son(String work,String game) {
        super(work);
        this.game = game;
    }

    static {
        a=2;
        System.out.println(b);
        System.out.println("Son Class Static Loading");
    }

    static{
        b = 4;
        System.out.println(a);
    }
}
