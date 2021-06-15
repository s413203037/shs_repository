package com.shs.nxstudy.no2_generic.practice.collectionsmap;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 并发下数组容量检测存在问题
 * 并发下没有触发动态扩容，所以存在问题
 * @Author 向寒 奈学教育
 * @Date 2020/7/8 19:47
 **/
public class ArrayListTest2 {
    private static List<Integer> list = new ArrayList<Integer>();

//    private static ExecutorService executorService = Executors.newFixedThreadPool(10000);

    private static class IncreaseTask extends Thread{
        @Override
        public void run() {
            System.out.println("ThreadId:" + Thread.currentThread().getId() + " start!");
            for(int i =0; i < 1000000; i++){
                list.add(i);
            }
            System.out.println("ThreadId:" + Thread.currentThread().getId() + " finished!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new IncreaseTask().start();
//        并发下数组容量检测存在问题，如果顺序执行则没有问题
//        Thread.sleep(200);
        new IncreaseTask().start();
    }
}


