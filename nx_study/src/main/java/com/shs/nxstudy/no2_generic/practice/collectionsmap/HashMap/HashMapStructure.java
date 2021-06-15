package com.shs.nxstudy.no2_generic.practice.collectionsmap.HashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapStructure {

    public static void main(String[] args) {
        Map<HashKey,String> map = new HashMap<>();
        //第一阶段
        for (int i = 0; i < 6; i++) {
            map.put(new HashKey(String.valueOf(i)), "A");
        }
        System.out.println("第一阶段完成");
//        12==16*0.75;
//        TREEIFY_THRESHOLD=DEFAULT_INITIAL_CAPACITY*DEFAULT_LOAD_FACTOR;
        //如果下次大于map size > 12 则发生rehash

        //第二阶段
        for (int i = 0; i < 12; i++) {    //16*2=32  32*0.75=24    32*2=64  36/0.75=48
            map.put(new HashKey(String.valueOf(i)), "A");
        }
        System.out.println("第二阶段完成");
//        CAPACITY等于64 未触发树形化条件
//        48==64*0.75;     (size=30) 36/0.75=48
//        THRESHOLD=MIN_TREEIFY_CAPACITY*DEFAULT_LOAD_FACTOR;

        //第三阶段
        for (int i = 0; i < 50; i++) {  //64*0.75=48     64*2=128空间
            map.put(new HashKey(String.valueOf(i)), "A");
        }
        System.out.println("第三阶段完成");
//      size > THRESHOLD  开始扩容
//      128=96/0.75
//      MIN_TREEIFY_CAPACITY=TREEIFY_THRESHOLD/DEFAULT_LOAD_FACTOR

//        开始变成树结构
//      1号桶的bin的数量超过 TREEIFY_THRESHOLD(8) && 128>  threshold = tableSizeFor(initialCapacity)

        //第四阶段
        map.put(new HashKey("X"), "B");
        map.put(new HashKey("Y"), "B");
        map.put(new HashKey("Z"), "B");
        System.out.println(map);
        System.out.println("第四阶段完成");
    }
}