package com.shs.nxstudy.no2_generic.commit.homework1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Family<T extends Person> {
    //<T extends Father> 这里的T与入参相匹配有限制，上界检查，控制的入参的T
    public <T extends Father> List<T>  addFamily(T[] person){
        if(person != null && person.length != 0){
            List<T> list = new ArrayList<>();
            for (int i = 0; i < person.length; i++) {
                list.add(person[i]);
            }
            return list;
        }else{
            return null;
        }
    }
    @Test
    public void Test_shs(){
        //上界泛型对象,只能用于Person的子类
        Family<Father> family = new Family<Father>();
        Father f = new Father("F1","程序猿");
        Son s = new Son("S1","学生","小霸王");
        Person[] p= new Person[2];
        p[0] = f;
        p[1] = s;
        Father fArray[] = new Father[2];
        fArray[0] = f;
        fArray[1] = s;
        //addFamily 入参类型也有上界限制

        List<Father> people = family.addFamily(fArray);
        for (Person person : people) {
            System.out.println(person.getName());
        }
    }
}
