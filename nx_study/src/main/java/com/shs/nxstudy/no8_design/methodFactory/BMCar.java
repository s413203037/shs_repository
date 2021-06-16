package com.shs.nxstudy.no8_design.methodFactory;

/**
 * Author:shenhuishan
 * ClassName: BMCar <br/>
 * Description: <br/>
 * date: 2021/6/16 16:49<br/>
 *
 * @author Blue_sky<br />
 */
public class BMCar implements ICarProduct {
    @Override
    public void carDesc() {
        System.out.println("获得一辆宝马汽车");
    }
}