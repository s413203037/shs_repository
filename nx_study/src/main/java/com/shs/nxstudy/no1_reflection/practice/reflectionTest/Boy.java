/**
 * @Author 沈会山
 * @Description //Boy类
 * @Date 21:57 2020/7/20
 * @Param
 * @return
 **/
package com.shs.nxstudy.no1_reflection.practice.reflectionTest;

public class Boy extends Person implements Father{
    public String name;

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static String description;

    public static  void speak(String name,int age){
        System.out.println("静态的"+age+"岁的"+name+"在说话");
    }

    public Boy(){

    }
    public Boy(String name){
        this.name = name;
    }

    private Boy(int age){
        this.age = age;
    }
    public void think(String name,int age){
        System.out.println(age + "岁的" + name + "-Boy think!");
    }

    private int changeAge(int age){
        return age + 1;
    }
    @Override
    public void grow() {
        System.out.println("The boy grew up to be Father!");
    }
}
