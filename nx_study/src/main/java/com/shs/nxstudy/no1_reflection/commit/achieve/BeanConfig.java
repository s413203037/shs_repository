package com.shs.nxstudy.no1_reflection.commit.achieve;


import java.util.HashMap;
import java.util.List;

/**
 * @Author 沈会山
 * @Description //模拟xml配置属性
 * @Date 22:02 2020/7/22
 * @Param
 * @return
 **/
public class BeanConfig {
    private String id;
    private String clazz;
    private String factoryMethod;
    private String factoryBean;

    private HashMap diHashMap = new HashMap<String, List<String>>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getFactoryMethod() {
        return factoryMethod;
    }

    public void setFactoryMethod(String factoryMethod) {
        this.factoryMethod = factoryMethod;
    }

    public String getFactoryBean() {
        return factoryBean;
    }

    public void setFactoryBean(String factoryBean) {
        this.factoryBean = factoryBean;
    }

    public HashMap getDiHashMap() {
        return diHashMap;
    }

    public void setDiHashMap(HashMap diHashMap) {
        this.diHashMap = diHashMap;
    }
}
