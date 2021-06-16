package com.shs.nxstudy.no8_design.simpleFactory;

/**
 * Author:shenhuishan
 * ClassName: CarTest <br/>
 * Description: <br/>
 * date: 2021/6/16 17:13<br/>
 *
 * @author Blue_sky<br />
 */
public class CarTest {
    public static void main(String[] args) {
        Car car = CarFactory.getCar(20);
        car.CarTemplate();
        Car car1 = CarFactory.getCar(10);
        car1.CarTemplate();

    }
}