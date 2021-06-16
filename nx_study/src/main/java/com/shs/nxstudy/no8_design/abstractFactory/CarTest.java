package com.shs.nxstudy.no8_design.abstractFactory;

/**
 * Author:shenhuishan
 * ClassName: CarTest <br/>
 * Description: <br/>
 * date: 2021/6/16 16:24<br/>
 *
 * @author Blue_sky<br />
 */
public class CarTest {
    public static void main(String[] args) {
        // 创建汽车工厂实例，生产不同汽车
        ICarFactory iCarFactory = new CarFactory();
        iCarFactory.createCarAD().show();
        iCarFactory.createCarBM().show();
    }
}