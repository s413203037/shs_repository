package com.shs.nxstudy.no8_design.methodFactory;

/**
 * Author:shenhuishan
 * ClassName: CarTest <br/>
 * Description: <br/>
 * date: 2021/6/16 16:54<br/>
 *
 * @author Blue_sky<br />
 */
public class CarTest {
    public static void main(String[] args) {
        ICarFactory iCarFactory = new CarFactory();
        ICarProduct iCarProduct;
        iCarProduct = iCarFactory.getCar("A4");
        iCarProduct.carDesc();
        iCarProduct = iCarFactory.getCar("BM");
        iCarProduct.carDesc();
        iCarProduct = iCarFactory.getCar("aa");
        iCarProduct.carDesc();
    }
}