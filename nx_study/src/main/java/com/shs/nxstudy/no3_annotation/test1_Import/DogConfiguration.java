package com.shs.nxstudy.no3_annotation.test1_Import;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: DogConfiguration <br/>
 * Description: <br/>
 * date: 2021/5/27 11:17<br/>
 *
 * @author Blue_sky<br />
 */
@Configuration
//@Import(Dog.class)
public class DogConfiguration {
    @Bean
    public Cat cat(){
        return new Cat();
    }
}