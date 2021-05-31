package com.shs.nxstudy.no2_generic.homework2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @Author 沈会山
 * @Description //组合模拟HashSet,重写add方法
 * @Date 22:31 2020/8/4
 * @Param
 * @return
 **/
public class InstrumentedSet<T> {
    //FIXME: 作业2 用组合的方式来实现 total count

    //添加次数
    private int addCount = 0;
    private HashSet<T> hashSet = new HashSet<>();
    public void add(T t){
        hashSet.add(t);
        addCount++;
    }
    public void addAll(Collection<? extends T> list){
            for(T t:list){
                add(t);
            }
    }

    public static void main(String[] args) {
        InstrumentedSet<Integer> hashSetObj = new InstrumentedSet<>();
        List<Integer> addList = new ArrayList<>();
        addList.add(1);
        addList.add(2);
        addList.add(3);
        hashSetObj.addAll(addList);
        System.out.println("集合元素数量"+ hashSetObj.hashSet.size());
        System.out.println("集合添加次数"+ hashSetObj.addCount);
    }
//    InstrumentedSet(HashSet hashSet){
//
//    }


}
