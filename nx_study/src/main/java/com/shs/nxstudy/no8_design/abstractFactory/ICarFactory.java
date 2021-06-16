package com.shs.nxstudy.no8_design.abstractFactory;

/**
 * Author:shenhuishan
 * ClassName: ICarFactory <br/>
 * Description: <br/>
 * date: 2021/6/16 16:20<br/>
 * 汽车制造工厂接口
 * @author Blue_sky<br />
 */
public interface ICarFactory {
    public ADProduce createCarAD();
    public BMProduce createCarBM();
}