package com.shs.nxstudy.no8_design.simpleFactory;

/**
 * Author:shenhuishan
 * ClassName: CarFactory <br/>
 * Description: 4s店,简单工厂案例<br/>
 * date: 2021/6/16 9:39<br/>
 *
 * @author Blue_sky<br />
 */
public class CarFactory {

    public static Car getCar(int money){
        switch (money){
            case 10:
                return new ADCar();
            case 20:
                return new BCCar();
            case 30:
                return new BMCar();
            default:
                return null;
        }
    }


}