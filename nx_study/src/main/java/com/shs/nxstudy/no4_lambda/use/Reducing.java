package com.shs.nxstudy.no4_lambda.use;


import com.shs.nxstudy.no4_lambda.vo.Dish;
import static com.shs.nxstudy.no4_lambda.vo.Dish.menu;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


/**
 * @Description reduce方法将流归约成一个值。用函数式编程语言的术语来说，这称为折叠（fold）
 * @Author 向寒 奈学教育
 * @Date 2020/7/14 17:26
 **/
public class Reducing {

    public static void main(String...args){

        List<Integer> numbers = Arrays.asList(3,4,5,1,2);
        //语法 reduce(起点, 算法规则);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        int sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum2);

        int max = numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
        System.out.println(max);

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        min.ifPresent(System.out::println);

        int calories = menu.stream()
                           .map(Dish::getCalories)
                           .reduce(0, Integer::sum);
        System.out.println("Number of calories:" + calories);
    }
}
