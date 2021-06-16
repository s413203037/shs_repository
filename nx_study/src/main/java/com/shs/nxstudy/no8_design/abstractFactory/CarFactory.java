package com.shs.nxstudy.no8_design.abstractFactory;

/**
 * Author:shenhuishan
 * ClassName: CarFactory <br/>
 * Description: <br/>
 * date: 2021/6/16 16:23<br/>
 * 汽车产品实例
 * @author Blue_sky<br />
 */
public class CarFactory implements ICarFactory {
    @Override
    public ADProduce createCarAD() {
        return new ADA4Car();
    }

    @Override
    public BMProduce createCarBM() {
        return new BM525Car();
    }
}