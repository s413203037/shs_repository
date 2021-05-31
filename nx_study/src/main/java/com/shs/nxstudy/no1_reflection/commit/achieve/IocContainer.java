package com.shs.nxstudy.no1_reflection.commit.achieve;

import java.util.HashMap;

public class IocContainer {

    private static HashMap IocContainer = new HashMap();

    public static void putBean(String id,Object object){
        IocContainer.put(id,object);
    }

    public static Object getBean(String id){
        return IocContainer.get(id);
    }

    public static <T> T getBean(String id,Class<T> clazz){
        return (T)IocContainer.get(id);
    }
}
