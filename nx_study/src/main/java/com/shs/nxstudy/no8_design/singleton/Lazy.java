package com.shs.nxstudy.no8_design.singleton;

/**
 * Author:shenhuishan
 * ClassName: lazy <br/>
 * Description: <br/>
 * date: 2021/6/17 9:34<br/>
 *  懒汉式
 * @author Blue_sky<br />
 */
public class Lazy {
    public static Lazy lazySingleton = null;

    // 无参构造私有化，外部不能new实例化
    private Lazy(){

    }
    // 简易懒汉式创建，会有线程不安全情况
    public static Lazy getObject(){
        if(lazySingleton == null){//在A线程创建的时候，还未创建完成，B线程同时在在创建，则会冲突
            System.out.println("创建懒汉对象");
            lazySingleton = new Lazy();
        }
        return lazySingleton;
    }

    public void printStr(){
        System.out.println("这是懒汉式的方法");
    }
}
