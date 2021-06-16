package com.shs.nxstudy.no8_design.abstractFactory;

/**
 * Author:shenhuishan
 * ClassName: BM525Car <br/>
 * Description: <br/>
 * date: 2021/6/16 16:19<br/>
 *
 * @author Blue_sky<br />
 */
public class BM525Car implements BMProduce {
    @Override
    public void show() {
        System.out.println("这是宝马525系列汽车");
    }
}