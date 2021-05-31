package com.shs.nxstudy.no2_generic.commit.homework1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author 沈会山
 * @Description //课后作业一，利用泛型调用实现，无界、上界、下界应用
 * @Date 17:12 2020/7/12
 * @Param
 * @return
 **/
public class Test  {
    //无界通配符
    public void who_noScope(Collection<?> person){
        int count = 0;
        for (Object o : person) {
            count++;
        }
        System.out.println("无界通配符，插入了‘"+count+"’个家庭成员");
    }
    //上界通配符
    public void who_upScope(Collection<? extends Father> person){
        int count = 0;
        for (Object o : person) {
            count++;
        }
        System.out.println("上界通配符，插入了‘"+count+"’个家庭成员");
    }

    // 下界通配符
    public void who_downScope(Collection<? super Son> person){
        int count = 0;
        for (Object o : person) {
            count++;
        }
        System.out.println("下界通配符，插入了‘"+count+"’个家庭成员");
    }
    @org.junit.Test
    public void testCount(){
        //-------以上下界容器作为参数--------//
        //不符合
        List<Person> pList = new ArrayList<>();
        Person p = new Person("NO.1");
        Father f = new Father("NO.2","程序员");
        Son s = new Son("NO.3","学生","LOL");
        pList.add(p);
        pList.add(f);
        pList.add(s);
        List<Father> fList = new ArrayList<>();
        fList.add(f);
        fList.add(s);
        List<Son> sList = new ArrayList<>();
        sList.add(s);
        Test t = new Test();
        //无界可插入任意对象，例如pList、fList、sList
        t.who_noScope(pList);
        //上界以Father类为上边界，Person类不可插入，例如fList、sList，其他任意类的泛型集合都不可插入
        t.who_upScope(fList);
        t.who_upScope(sList);
        //下界以Son类为下边界，Son类以上的父类可插入，例如pList、fList、sList，其他任意类的泛型集合都不可插入
        t.who_downScope(fList);
        t.who_downScope(sList);


        //-------以上下界容器作为容器，进行读写--------//
        //<? super T>：通配符？的类型在T和Object之间。
        // <? super T>可以作为消费者也可以作为生产者的的原因就在这里，编译器
        //很清楚放入的类型下界是T，上界是Object
        List<? super Father> fList1 = new ArrayList<>();
        fList1.add(f);
//        fList1.add(p);//不可add
        fList1.get(0);//也可以读取

        // <? extends T>：通配符？的类型在Null和T之间。
        // <? extends T>只能作为消费者，而不能放入类型的原因就在这里，编译器
        //不能确定放入的是什么类型，Null可以转化为任意类型；
        // 换一种说法，编译器不知道类型的上界，只清楚类型的下界。
        List<? extends Father> upFList = new ArrayList<>();
        upFList.add(null);
//        upFList.add(f);//除null都不可add
        upFList.get(0);

    }

    //强转可以操作
    public <T extends Father> void f (T[] a){
        for (int i = 0; i < a.length; i++) {
            Son s = (Son) a[i];
            Person p = (Person) a[i];
        }
    }
}


