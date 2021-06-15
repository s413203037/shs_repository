package com.shs.nxstudy.no1_reflection.commit.loadObject;

/**
 * @Author 沈会山
 * @Description //TODO
 * @Date 0:59 2020/7/18
 * @Param
 * @return
 **/
public class E {

    private A a;
    private B b;

    public E(){
        System.out.println("E类被创建");
    }
    public void setA(A a) {
        System.out.println("E setA() invoke!");
        this.a = a;
    }

    public void setB(B b) {
        System.out.println("E setB() invoke!");
        this.b = b;
    }

}
