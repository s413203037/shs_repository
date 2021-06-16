package com.shs.nxstudy.no8_design.methodFactory;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/6/16 16:40<br/>
 *  汽车工厂接口
 * @author Blue_sky<br />
 * @since JDK 1.8
 */
public interface ICarFactory {
    public ICarProduct getCar(String carName);
}
