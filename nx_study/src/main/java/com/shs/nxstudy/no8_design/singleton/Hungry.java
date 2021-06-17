package com.shs.nxstudy.no8_design.singleton;

/**
 * Author:shenhuishan
 * ClassName: hungry <br/>
 * Description: <br/>
 * date: 2021/6/17 11:05<br/>
 * 饿汉式模式
 * @author Blue_sky<br />
 */
public class Hungry {
  /* 普通实现方式
    public static Hungry hungry = new Hungry();

    private Hungry(){

    }

    public static Hungry getInstance(){
        return hungry;
    }
*/
  // 内部类实现方式
    public static class HungryHoler{
        // 静态初始化器，由JVM来保证线程安全
//      当getInstance方法第一次被调用的时候,它第一次读取SingletonHolder.instance，
//      导致SingletonHolder类得到初始化；而这个类在装载并被初始化的时候，会初始化它的静态域，
//      从而创建Singleton的实例，由于是静态的域，因此只会在虚拟机装载类的时候初始化一次，
//      并由虚拟机来保证它的线程安全性。（静态内部类也是线程安全的一种实现方式，在类装载的时候，
//                                      就会初始化静态域，也就会创建对象实例，而且只会初始化一次）

        private static Hungry hungry = new Hungry();
  }

  private Hungry(){

  }

  public static Hungry getInstance(){
        return HungryHoler.hungry;

  }
    public void printStr(){
        System.out.println("这是饿汉式方法");
    }
}