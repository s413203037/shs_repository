package com.shs.nxstudy.no4_lambda.use;


import com.shs.nxstudy.no4_lambda.vo.Dish;
import static com.shs.nxstudy.no4_lambda.vo.Dish.menu;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @Description stream 过滤
 * @Author 向寒 奈学教育
 * @Date 2020/7/14 17:26
 **/
public class Filtering {

    public static void main(String...args){

        //过滤出素菜
        List<Dish> vegetarianMenu =
            menu.stream()
                //filter参数为谓词  也就是boolean类型
                .filter(Dish::isVegetarian)   //method reference
                .collect(toList());
        vegetarianMenu.forEach(System.out::println);

        // 过滤指定的元素 去重
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
               .filter(i -> i % 2 == 0)
               .distinct()//去重
               .forEach(System.out::println);

        //limit 截断流
        List<Dish> dishesLimit3 =
            menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(toList());

        dishesLimit3.forEach(System.out::println);

        //skip：跳过n个元素
        List<Dish> dishesSkip2 =
            menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());

        dishesSkip2.forEach(System.out::println);
    }
}
