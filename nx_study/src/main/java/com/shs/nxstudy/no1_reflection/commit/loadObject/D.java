package com.shs.nxstudy.no1_reflection.commit.loadObject;

/**
 * @Author 沈会山
 * @Description //TODO
 * @Date 0:59 2020/7/18
 * @Param
 * @return
 **/
public class D {

    private A a;

    private B b;

    public D() {
        System.out.println("D without parameters Constructor invoke! -- 调用D类");
    }

    public D(A a, B b) {
        System.out.println("D constructor with parameters invoke! -- D类构造器注入bean");
        this.a = a;
        this.b = b;
    }
}
