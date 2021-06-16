package com.shs.nxstudy.no8_design.methodFactory;

/**
 * Author:shenhuishan
 * ClassName: CarFactory <br/>
 * Description: <br/>
 * date: 2021/6/16 16:50<br/>
 *
 * @author Blue_sky<br />
 */
public class CarFactory implements ICarFactory {
    ICarProduct iCarProduct;
    @Override
    public ICarProduct getCar(String carName) {
//        if(carName.equals("A4")){
//            iCarProduct = new ADCar();
//        }else if(carName.equals("BM")){
//            iCarProduct =  new BMCar();
//        }else{
//            iCarProduct = new ADCar();
//
//        }
        switch (carName){
            case "A4":
                iCarProduct = new ADCar();
                break;
            case "BM":
                iCarProduct =  new BMCar();
                break;
            default:
                iCarProduct =  new ADCar();
        }
        return iCarProduct;
    }
}