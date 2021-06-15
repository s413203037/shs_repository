package com.shs.nxstudy.no1_reflection.commit.achieve;


import com.shs.nxstudy.no1_reflection.commit.loadObject.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author 沈会山
 * @Description //手写模拟IOC在框架运行时创建对象
 * @Date 22:01 2020/7/22
 * @Param
 * @return
 **/
public class BootStrap {

    //IOC是一种设计思想，将创建对象的工作交给框架(第三方)处理，开发者只关注业务即可
    //DI当对象创建好后，设置对象之间的依赖关系
    public static void main(String[] args) throws Exception{
        //原装IOC容易创建对象
//        ApplicationContext context = new ClassPathXmlApplicationContext("reflex/spring-di.xml");
        //IOC 测试
      //手写IOC容器实现类装载过程
        List<BeanConfig> beanList = createXmlBean();
        //IOC创建对象到容器中
        iocContainerLoad(beanList);
        A a = IocContainer.getBean("a", A.class);
        B b = IocContainer.getBean("b", B.class);
        C c = IocContainer.getBean("c", C.class);

        //DI 测试
        D d = IocContainer.getBean("d", D.class);
        E e = IocContainer.getBean("e", E.class);
        //DI设置依赖关系
        diLoad(beanList);
    }

    public static void iocContainerLoad(List<BeanConfig> beanList) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if(null != beanList){
            for (BeanConfig beanConfig : beanList) {
                //遍历要创建的Bean对象
                //Bean的id属性
                String beanId = beanConfig.getId();
                //Bean的class路径
                String beanClassPath = beanConfig.getClazz();
                if(null != beanClassPath){
                    //如果class属性存在，则反射获取该Bean的class对象
                    Class beanClazz = Class.forName(beanClassPath);
                    if(null != beanClazz){
                        //获取执行方法名
                        String beanMethod = beanConfig.getFactoryMethod();
                        if(null == beanMethod){
                            //不需要执行工厂方法，直接创建对象实例
                            IocContainer.putBean(beanId,beanClazz.newInstance());
                        }else{
                            //执行工厂方法
                            Method beanMethodObj = beanClazz.getDeclaredMethod(beanMethod);
                            if(null != beanMethodObj){
                                //通过静态方法调用创建对象
                                IocContainer.putBean(beanId,beanMethodObj.invoke(null));
                            }else{
                                System.out.println("获取方法对象失败");
                            }
                        }
                    }
                }else{
                    //是否调用工厂实例
                    String factoryBean = beanConfig.getFactoryBean();
                    if(null != factoryBean){
                        //通过调用实例对象执行方法
                        Object bean = IocContainer.getBean(factoryBean);
                        String factoryMethod = beanConfig.getFactoryMethod();
                        //获取实例Bean中的方法对象
                        Method declaredMethod = bean.getClass().getDeclaredMethod(factoryMethod);
                        //调用对象并创建BeanC
                        IocContainer.putBean(beanId,declaredMethod.invoke(bean));
                    }
                }
            }
        }else{
            System.out.println("NO Bean Loading");
        }
    }
    /**
     * @Author 沈会山
     * @Description //模拟DI注入
     * @Date 22:58 2020/7/22
     * @Param []
     * @return void
     **/
    public static void diLoad(List<BeanConfig> beanList) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //默认注入对象已创建完成，装载到容器中，现在只是设置依赖关系
        for (BeanConfig beanConfig : beanList) {
            //要给泛型，不然遍历不知道类型
            HashMap<String,List<String>> diHashMap = beanConfig.getDiHashMap();
            //获取被注入的对象
            Object beanObj = IocContainer.getBean(beanConfig.getId());
            if(null != beanObj){
                //若依赖对象存在则设置依赖关系
                if(null != diHashMap && diHashMap.size() > 0){
                    //遍历参数
                    for(String key:diHashMap.keySet()){
                        //获取要注入的对象集合
                        List<String> objList = diHashMap.get(key);
                        if(null != objList && objList.size() > 0){
                            //创建入参对象类型Class集合
                            Class [] objTypeList = new Class[objList.size()];
                            //创建入参对象实例集合
                            Object [] objValueList = new Object[objList.size()];
                            for (int i = 0;i < objList.size();i++) {
                                objTypeList[i] = IocContainer.getBean(objList.get(i)).getClass();
                                objValueList[i] = IocContainer.getBean(objList.get(i));
                            }
                            //有参构造器注入
                            if("constructor-arg".equals(key)){
                                Constructor declaredConstructor = beanObj.getClass().getDeclaredConstructor(objTypeList);
                                declaredConstructor.newInstance(objValueList);
                            }else{//Setter方式注入
                                for (int i = 0;i < objList.size();i++) {
                                    Method declaredMethod = beanObj.getClass().getDeclaredMethod("set" + objList.get(i).toUpperCase(), objTypeList[i]);
                                    declaredMethod.invoke(beanObj,objValueList[i]);
                                }
                            }
                        }
                    }

                }else{
                    System.out.println(beanConfig.getId() + " 类无需依赖");
                }
            }else{
                System.out.println("对象不存在");
            }



        }

    }
    //获取要创建的对象集合
    public static List<BeanConfig> createXmlBean(){
        List<BeanConfig> beanList = new ArrayList<>();
        //空参构造创建
        BeanConfig withoutBean = new BeanConfig();
        withoutBean.setId("a");
        withoutBean.setClazz("com.nx_shs.homework.no1_reflection.commit.loadObject.A");
        beanList.add(withoutBean);
        //静态工厂创建
        BeanConfig staticBean = new BeanConfig();
        staticBean.setId("b");
        staticBean.setClazz("com.nx_shs.homework.no1_reflection.commit.loadObject.A");
        staticBean.setFactoryMethod("createBObj");
        beanList.add(staticBean);
        //实例工厂创建
        BeanConfig newInstanceBean = new BeanConfig();
        newInstanceBean.setId("c");
        newInstanceBean.setFactoryBean("a");
        newInstanceBean.setFactoryMethod("createCObj");
        beanList.add(newInstanceBean);

        //DI有参构造函数Bean
        BeanConfig paramConstructorBean = new BeanConfig();
        paramConstructorBean.setId("d");
        paramConstructorBean.setClazz("com.nx_shs.homework.no1_reflection.commit.loadObject.D");
        HashMap<String,List<String>> paramList = new HashMap<>();
        List<String> pList = new ArrayList<>();
        pList.add("a");
        pList.add("b");
        paramList.put("constructor-arg",pList);
        paramConstructorBean.setDiHashMap(paramList);
        beanList.add(paramConstructorBean);
        //DI setter方法
        BeanConfig setterBean = new BeanConfig();
        setterBean.setId("e");
        setterBean.setClazz("com.nx_shs.homework.no1_reflection.commit.loadObject.E");
        HashMap<String,List<String>> paramListSet = new HashMap<>();
        List<String> pListSet = new ArrayList<>();
        pListSet.add("a");
        pListSet.add("b");
        paramListSet.put("property",pList);
        setterBean.setDiHashMap(paramListSet);
        beanList.add(setterBean);
        return beanList;
    }
}
