package com.shs.nxstudy.no4_lambda.use;


import com.shs.nxstudy.no4_lambda.vo.Dish;
import static com.shs.nxstudy.no4_lambda.vo.Dish.menu;
import java.util.Optional;


/**
 * @Description stream查找元素
 * @Author 向寒 奈学教育
 * @Date 2020/7/14 17:26
 **/
public class Finding {

    public static void main(String...args){
        if(isVegetarianFriendlyMenu()){
            System.out.println("Vegetarian friendly");
        }

        System.out.println(isHealthyMenu());
        System.out.println(isHealthyMenu2());
        
        Optional<Dish> dish = findVegetarianDish();
        dish.ifPresent(d -> System.out.println(d.getName()));
    }

    //相当于||
    private static boolean isVegetarianFriendlyMenu(){
        return menu.stream().anyMatch(Dish::isVegetarian);
    }

    //相当于 &&
    private static boolean isHealthyMenu(){
        return menu.stream().allMatch(d -> d.getCalories() < 1000);
    }

    //相当于 !=
    private static boolean isHealthyMenu2(){
        return menu.stream().noneMatch(d -> d.getCalories() >= 1000);
    }

    //匹配任何一个 适用于并发流执行
    private static Optional<Dish> findVegetarianDish(){
        return menu.stream().filter(Dish::isVegetarian).findAny();
    }
    
}
