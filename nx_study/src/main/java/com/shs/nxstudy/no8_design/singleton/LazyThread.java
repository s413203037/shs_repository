package com.shs.nxstudy.no8_design.singleton;



/**
 * Author:shenhuishan
 * ClassName: LazyThread <br/>
 * Description: <br/>
 * date: 2021/6/17 9:55<br/>
 * 线程安全的懒汉式
 * @author Blue_sky<br />
 */
public class LazyThread {
    public volatile static LazyThread lazyThread = null;

    private LazyThread(){

    }

    public static LazyThread getInstance(){
        if(lazyThread == null){
            synchronized (LazyThread.class){
                if(lazyThread == null){
                    lazyThread = new LazyThread();
                }
            }
        }
        return lazyThread;
    }
    public void printStr(){
        System.out.println("这是线程安全的懒汉式的方法");
    }
}