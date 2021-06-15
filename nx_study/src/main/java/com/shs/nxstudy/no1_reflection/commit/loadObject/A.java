package com.shs.nxstudy.no1_reflection.commit.loadObject;



/**
 * @Author 沈会山
 * @Description //TODO
 * @Date 0:59 2020/7/18
 * @Param
 * @return
 **/
public class A {

    public A() {
        System.out.println("A whitout parameters Constructor invoke!--A类无参构造器执行");
    }

    public static B createBObj() { //factory-method
        System.out.println("A static function createBObj() invoke! -- A类的静态方法createBObj");
        return new B();
    }
    public C createCObj() { //instance-method
        System.out.println("a's createCObj() invoke! -- A类的静态方法createCObj");
        return new C();
    }

}
