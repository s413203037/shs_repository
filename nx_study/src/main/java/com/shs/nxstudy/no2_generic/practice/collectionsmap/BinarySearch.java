package com.shs.nxstudy.no2_generic.practice.collectionsmap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description 集合二分法演示
 * 由于折半查找使得查找的元素个数都减半，因此含有n个元素的数组，能折半的次数是lg(n),
 * 折半后，要对一半元素进行遍历，复杂度是O(n),所以上面算法的时间复杂度是O(n * lg(n))
 * @Author 向寒 奈学教育
 * @Date 2020/7/8 14:18
 **/
public class BinarySearch
{

    /**
     * 集合原生二分法测试
     */
    @Test
    public void indexedBinarySearch(){
        int size=1000;
        int findKey=900;
        List<Integer> list =new ArrayList();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        int index= Collections.binarySearch(list, 900);
        System.out.println(findKey==list.get(index));
    }

    /**
     * 手写二分法测试
     */
    @Test
    public void findIndexTest(){
        int size=1000;
        List<Integer> list =new ArrayList();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        //特例 如果直接查找中位数 一次查找即可
//        int index= findIndex(list, 499);
//        int index= findIndex(list, 199);
//        int index= findIndex(list, 999);
        int index= findIndex(list, 699);
    }

//    public static void main(String[] args) {
//        Integer size=Integer.MAX_VALUE/2;
//        Integer[] array =new Integer[size];
//        for (int i = 0; i < size; i++) {
//            array[i]=i;
//        }
//        int index= findIndex(array, (Integer.MAX_VALUE/2)-100);
//    }
//
//    private static Integer findIndex(Integer[] array, Integer key) {
//        int low = 0;
//        int high = array.length;
//        while (low <= high) {
//            int mid = (low + high)/2;
//            Integer midVal = array[mid];
//            int cmp = midVal.compareTo(key);
//            if (cmp < 0) {
//                low = mid + 1;
//            } else if (cmp > 0) {
//                high = mid - 1;
//            } else {
//                return mid;
//            }
//        }
//        return -(low + 1);
//    }

    private static Integer findIndex(List<Integer> list, Integer key) {
        //最低位
        int low = 0;
        //最高位
        int high = list.size()-1;

        System.out.println("起点下标为："+low+"，终点下标为："+high);
        //查找次数
        int count=0;

        //循环二段查找
        while (low <= high) {
            System.out.println("第"+(++count)+"次查找===================");
//            >>> 无符号位移，不管正负数，运算时，高位补0
//            正数时，和>>一样。
//            负数时
//            -4>>>1，之前省略了高位，这里补齐应该是：1111 （中间24个1） 1100
//            1111 ... 1100 补码
//            0111 ... 1110 运算后结果
//            计算机会认为这个数是个正数，结果为2147483646，即Integer.MAX_VALUE-1。

//            int mid = (low + high) >>> 1;
            //获取中间位
            int mid = (low + high)/2;
            Integer midVal = list.get(mid);
            System.out.println("中间位："+midVal);
            //对比查找的值 中间位是否大于Key
            int cmp = midVal.compareTo(key);

            if (cmp < 0) {
                //整体一分为二，在左侧数据里去查找key
                System.out.println("中间位小于key：key="+key+"，中间位="+midVal);
                System.out.println("下次匹配，从中间位开始向终点开始匹配");
                low = mid + 1;
                System.out.println("下次的起点下标是 mid + 1："+low);
            } else if (cmp > 0) {
                System.out.println("中间位大于key：key="+key+"，中间位="+midVal);
                high = mid - 1;
                System.out.println("下次的终点下标是 mid - 1："+high);
            } else {
                //等于中间位，直接返回下标
                System.out.println("等于中间位下标是："+mid);
                System.out.println("found and over!");
                return mid;
            }
        }
        //匹配不到 -1
        System.out.println("查无次数，over！");
        return -(low + 1);
    }
}