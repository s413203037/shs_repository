package com.shs.nxstudy.no4_lambda.use;



import java.util.Arrays;
import java.util.List;
import com.shs.nxstudy.no4_lambda.vo.Dish;
import static com.shs.nxstudy.no4_lambda.vo.Dish.menu;
import static java.util.stream.Collectors.toList;

/**
 * @Description map将stream按一个函数作为参数，映射成一个新的流，而不是修改之前的流
 *              flatMap：使用flatMap方法的效果是，各个数组并不是分别映射成一个流，而是映射成流的内容。
 * @Author 向寒 奈学教育
 * @Date 2020/7/14 17:26
 **/
public class Mapping {

    public static void main(String...args){

        // map
        List<String> dishNames = menu.stream()
                                     .map(Dish::getName)
//                                     .map(dish -> dish.getName())
                                     .collect(toList());
        System.out.println(dishNames);

        // map
        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                                         .map(String::length)
                                         .collect(toList());
        System.out.println(wordLengths);

        // flatMap
        words.stream()
             //切割成单个词
                 .flatMap((String line) -> Arrays.stream(line.split("")))
                 .distinct()//去重
                 .forEach(System.out::println);

        // flatMap
        List<Integer> numbers1 = Arrays.asList(1,2,3,4,5);
        List<Integer> numbers2 = Arrays.asList(6,7,8);
        List<int[]> pairs =
                        numbers1.stream()
                                //两个list中纵向两两组合成为一个二维数组
                                .flatMap((Integer i) -> numbers2.stream().map((Integer j) -> new int[]{i, j})
                                 )
                                //过滤二维数组 两列之和为3的倍数
                                .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
                                .collect(toList());
        pairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
    }
}
