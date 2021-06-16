package com.shs.nxstudy.no8_design.methodFactory;

/**
 * Author:shenhuishan
 * ClassName: ADCar <br/>
 * Description: <br/>
 * date: 2021/6/16 16:48<br/>
 *
 * @author Blue_sky<br />
 */
public class ADCar implements ICarProduct{
    @Override
    public void carDesc() {
        System.out.println("获得一辆奥迪A4");
    }
}