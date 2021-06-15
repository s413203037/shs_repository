package com.shs.nxstudy.no1_reflection.practice.reflectionTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;

public class TestClass {
    public static void main(String[] args) throws Exception{

        //获取类的Class字节码对象4中方法

        //class.forName()除了将类的.class文件加载到jvm中之外，还会对类进行解释，执行类中的static块。当然还可以指定是否执行静态块。
        //classLoader只干一件事情，就是将.class文件加载到jvm中，不会执行static中的内容,只有在newInstance才会去执行static块。
        //NO.1
        Class boyClass = Boy.class;
        //NO.2
        Class<?> boyClassLoader = TestClass.class.getClassLoader().loadClass("com.nx_shs.homework.no1_reflection.practice.reflectionTest.Boy");
        //NO.3
        Class<?> boyForname = Class.forName("com.nx_shs.homework.no1_reflection.practice.reflectionTest.Boy");
        //NO.4
        Boy boy = new Boy();
        Class boyGetclass = boy.getClass();

        //对于clazz的操作
//        classOperate(boyClassLoader);
        //对于clazz属性操作
//        fieldOperate(boy);
        //对于clazz属性操作
//        methodOperate(boy);
        //对于class构造器操作
        constructorOperate(boy);

    }

    /**
     * @Author 沈会山
     * @Description //对于Class的一些操作
     * @Date 21:49 2020/7/20
     * @Param []
     * @return void
     **/
    public static void classOperate(Class clazz) throws Exception{
        //获取类的修饰符，特征符
        //1代表public、2代表private、4代表protected、8代表static、1g代表final、.....
        int modifiers = clazz.getModifiers();
        System.out.println("这个类的修饰符常数对应值："+modifiers);
        //获取类所属的包对象
        Package aPackage = clazz.getPackage();
        System.out.println("这个类的包名是："+aPackage.getName());
        System.out.println("这个类的包对象注释是："+aPackage.getAnnotations());
        //类名
        String clazzName = clazz.getName();//相对路径
        String simpleName = clazz.getSimpleName();//类名
        System.out.println("This Class fullClassName is " + clazzName);
        System.out.println("This Class simpleClassname is " + simpleName);
        //获取类加载器
        //Bootstrap启动类加载器底层是C语言开发，在java环境中获取不到，所以显示为null
        ClassLoader classLoader1 = Collections.class.getClassLoader();
        //业务类开发类加载器属于APPClassLoader（系统加载器）
        ClassLoader classLoader = clazz.getClassLoader();
        System.out.println("This Class classLoader is " + classLoader);
        //获取当前类实现的接口列表
        Class[] interfaces = clazz.getInterfaces();//存放的是接口项目路径
        for (int i = 0; i < interfaces.length; i++) {
            System.out.println("This Class interfaces is " + interfaces[i]);
        }
        //父类对象
        Class superclass = clazz.getSuperclass();//父类项目路径
        System.out.println("This Class superclass is " + superclass);
    }

    /**
     * @Author 沈会山
     * @Description //操作类属性
     * @Date 22:22 2020/7/20
     * @Param [clazz]
     * @return void
     **/
    public static void fieldOperate(Boy boy) throws NoSuchFieldException, IllegalAccessException {
        Class clazz = boy.getClass();
        //获取所有公有的属性，包含继承
        Field[] fields = clazz.getFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println("Boy Class Public Field is " + fields[i]);
        }
        //获取指定名字的属性对象
        //getField只能获取所有公有的属性，包含继承
        Field boyName = clazz.getField("name");
//        Field boyAge = clazz.getField("age");//age属性是私有的，不能获取
        Field boyDiscription = clazz.getField("description");


        boyName.set(boy,"小明");
        boyDiscription.set(boy,"上学的小学生");

        System.out.println("Boy name field 设置 ："+boy.name);
        System.out.println("Boy discription field 设置 ："+Boy.description);

        //getDeclaredFields类中属性获取及操作 (本类中定义,不管什么修饰都能获取)
        Field[] declaredFields = clazz.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            System.out.println("Boy Class All Field is " + declaredFields[i]);
        }

        Field boyAge = clazz.getDeclaredField("age");
        //修饰符代表的数值2、private
        int modifiers = boyAge.getModifiers();
        //私有属性不能直接操作，需要强制访问（强吻）
        boyAge.setAccessible(true);
        boyAge.set(boy,10);
        System.out.println("Boy age field 设置 ："+ boyAge.get(boy));
        System.out.println("Boy age modifier value is ："+modifiers);
    }

    /**
     * @Author 沈会山
     * @Description //对于class的方法操作
     * @Date 21:29 2020/7/21
     * @Param [boy]
     * @return void
     **/
    public static void methodOperate(Boy boy) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //获取对象的类字节码对象
        Class clazz = boy.getClass();

        //获取公有方法
        Method[] methods = clazz.getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println("Boy Class Method is " + methods[i]);
        }
        Class[] typeList = new Class[2];
        typeList[0] = String.class;
        typeList[1] = int.class;
        //获取指定方法
        //获取方法是，传参传的是类型，多个参数用Class[]数组存放
        Method think = clazz.getMethod("think",typeList);

        Method boySpeak = clazz.getMethod("speak",typeList);
        //获取修饰符值
        int think_modifiers = think.getModifiers();
        System.out.println("Boy Class think Modifier is" + think_modifiers);

        //方法的参数列表
        Class[] parameterTypes = think.getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            System.out.println("think 方法的参数是：" + parameterTypes[i]);
        }
        //方法调用
        //方法调用，传参是值，多个参数用Object[]数组存放
        Object [] valueList = new Object[2];
        valueList[0] = "小空";
        valueList[1] = 8;
        think.invoke(boy,valueList);
        //静态方法调用
        boySpeak.invoke(null,valueList);

        //获取所有方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        System.out.println("Boy 中定义了 " + declaredMethods.length + "个方法");

        //以私有方法为例
        Method changeAge = clazz.getDeclaredMethod("changeAge", int.class);
        int changeAge_modifiers = changeAge.getModifiers();
        System.out.println("Boy 中的changeAge方法的修饰符值是 " + changeAge_modifiers);
        //强吻私有方法
        changeAge.setAccessible(true);
        //获取返回值
        int invoke = (int)changeAge.invoke(boy, 10);
        Class<?> returnType = changeAge.getReturnType();
        System.out.println("Boy 中的changeAge方法的返回类型是 " + returnType);
        System.out.println("Boy 中的changeAge方法的返回值是 " + invoke);

    }

    /**
     * @Author 沈会山
     * @Description //构造方法操作
     * @Date 23:08 2020/7/21
     * @Param [boy]
     * @return void
     **/
    public static void constructorOperate(Boy boy) throws Exception{

        //获取对象的类字节码对象
        Class clazz = boy.getClass();

        //获取公有构造函数
        Constructor[] boyConstructors = clazz.getConstructors();
        System.out.println("Boy Class中定义了 " + boyConstructors.length + "个公有构造函数");
        //获取类中定义的所有的构造方法(包含公有,私有)
        Constructor[] boyDeclaredConstructors = clazz.getDeclaredConstructors();
        System.out.println("Boy Class中定义了 " + boyDeclaredConstructors.length + "个构造函数");

        //获取无参构造
        Constructor declaredConstructor_Without = clazz.getDeclaredConstructor();

        //获取构造函数修饰符的值
        int modifiers = declaredConstructor_Without.getModifiers();
        System.out.println("Boy 的 constructorWithOutParam 修饰符:"+modifiers);

        //获取有参构造函数
        Constructor declaredConstructor_String = clazz.getDeclaredConstructor(String.class);
        //获取参数列表类型
        Class[] parameterTypes = declaredConstructor_String.getParameterTypes();
        System.out.println("Boy 有参构造函数参数类型 " + parameterTypes[0]);

        //获取异常列表类型
        Class[] exceptionTypes = declaredConstructor_String.getExceptionTypes();
        for (int i = 0; i < exceptionTypes.length; i++) {
            System.out.println("异常列表 ：" + exceptionTypes[i]);
        }

        //调用构造函数,生成Boy实例对象，可调用实力方法或属性
        Boy boy_String = (Boy)declaredConstructor_String.newInstance("三毛");
        System.out.println("Boy Class 的 name属性值是" + boy_String.name);
        boy_String.think("二毛",10);

        //调用私有构造函数示例
        Constructor declaredConstructor_int = clazz.getDeclaredConstructor(int.class);
        //获取构造函数修饰符值
        int modifiers1 = declaredConstructor_int.getModifiers();
        System.out.println("私有构造函数的修饰符值 ：" + modifiers1);

        //强吻进行调用及其他操作
        declaredConstructor_int.setAccessible(true);

        boy_String = (Boy)declaredConstructor_int.newInstance(10);

        System.out.println("Boy Class 的 age属性值是" + boy_String.getAge());
    }

}
