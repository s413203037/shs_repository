package com.shs.nxstudy.no3_annotation.test1_Import;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * ClassName: DogTest <br/>
 * Description: <br/>
 * date: 2021/5/27 11:18<br/>
 *
 * @author Blue_sky<br />
 */
@SpringBootApplication
@Import({Dog.class,DogConfiguration.class})
public class DogTest {
//    private AnnotationConfigApplicationContext applicationContext;
//
//   // @Test
//    public void test(){
//        applicationContext = new AnnotationConfigApplicationContext(DogConfiguration.class);
//        Dog bean = applicationContext.getBean(Dog.class);
//        bean.run();
//        applicationContext.close();
//    }

    public static void main(String[] args) {
        SpringApplication.run(DogTest.class,args);
    }
}