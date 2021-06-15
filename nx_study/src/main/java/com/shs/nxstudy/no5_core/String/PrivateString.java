package com.shs.nxstudy.no5_core.String;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @Author 沈会山
 * @Description //通过反射获取私有元素并更改数组值
 * @Date 21:15 2021/6/2 02
 * @Param
 * @return
 **/
public class PrivateString {
    private final String [] arr = new String[]{"1","2"};

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        int[] ar = {1,2};
        String [] ab = new String[]{"1","2"};
        Class<PrivateString> privateStringClass = PrivateString.class;
//        Class<?> ps = Class.forName("com.shs.nxstudy.no5_core.String.PrivateString");
//        Field arr = ps.getField("arr");
        //获取所有属性，包含私有
        Field arr1 = privateStringClass.getDeclaredField("arr");
        PrivateString privateString = privateStringClass.newInstance();
        arr1.setAccessible(true);
        System.out.println("变量的数据类型" + arr1.getType().getSimpleName());
        privateString.arr[0] = "3";
        System.out.println("改变后的数组值" + privateString.arr[0]);
//        String[]a = (String[]) arr1.get(privateStringClass);
//        System.out.println(a[0]);
        Class<?> componentType = privateString.arr.getClass().getComponentType();
        // 修改数组值
        Array.set(privateString.arr,1,"4");
          Arrays.asList(ab).forEach(System.out::println);
        System.out.println(Array.get(privateString.arr, 1));
//        System.out.println(componentType.getName());
    }
}
