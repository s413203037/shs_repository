package com.shs.nxstudy.no4_lambda.test1_base;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class lambda1 {
//    public List<String> getWordsFromXml(){
//        String contents = null;
//
//        try {
//            contents = new String(Files.readAllBytes(Paths.get("E:\\Nx_document\\workspace\\homework\\shenhuishan\\src\\main\\resources\\reflex\\spring-di.xml")));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        System.out.println(contents);
//
//        List<String> words = List.of(contents.split("\\PL+"));// JDK1.9特性
//        System.out.println(words);
//
//        return  words;
//    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i < 100; i++) {
            list.add(random.nextInt(i));
        }

        // 作业之一 lambda expression usage

        // 计算list中大于100的数，并存入一个新的集合

        long start = System.currentTimeMillis();
        List<Integer> res = new ArrayList<>();
        for (Integer integer : list) {
            if(integer>80){
                res.add(integer);
            }
        }
        long end = System.currentTimeMillis() - start;
        System.out.println(res.size());
        System.out.println("time cost0: " + end);


        long start1 = System.currentTimeMillis();
        List<Integer> collect = res.stream().filter(num -> num > 100).collect(Collectors.toList());

        long end1 = System.currentTimeMillis() - start1;

        System.out.println(res.size());
        System.out.println("time cost1: " + end1);

        long count = res.stream().filter(num -> num > 80).count();//.forEach(System.out::println);
        System.out.println(count);
//        System.out::println;
//        FileStreamTest fileStreamTest = new FileStreamTest();
//
//        int count = 0;
//        List<String> words = fileStreamTest.getWordsFromXml();
//
//        long start = System.currentTimeMillis();


//        for(String w : words){
//            if(w.length() > 12 )
//                count++;
//        }

//        HashSet<String> res = new HashSet<>(words);
//        System.out.println(res);
//        System.out.println(res.size());


//        long end = System.currentTimeMillis() - start;
//        System.out.println("time cost0: " + end);
//
//
//
//        System.out.println("================分割线=====================");
//
//        long start1 = System.currentTimeMillis();
//
//        long c1 = words.stream().filter(w -> w.length() > 12).distinct().count();
//        System.out.println(c1);
//
//        long end1 = System.currentTimeMillis() - start1;
//        System.out.println("time cost1: " + end1);
    }
}
