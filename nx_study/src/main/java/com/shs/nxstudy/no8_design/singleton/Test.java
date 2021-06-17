package com.shs.nxstudy.no8_design.singleton;

/**
 * Author:shenhuishan
 * ClassName: Test <br/>
 * Description: <br/>
 * date: 2021/6/17 9:39<br/>
 *
 * @author Blue_sky<br />
 */
public class Test {
    public static void main(String[] args) {
        // 此处不能再实例对象
//        Lazy lazy = new Lazy();
        // 用静态方法直接获取镜像实例
        Lazy lazyObj = Lazy.getObject();
        lazyObj.printStr();
        Lazy.getObject().printStr();//这次直接使用创建过得对象，不会再重新创建

        LazyThread.getInstance().printStr();

        Hungry.getInstance().printStr();
    }
}