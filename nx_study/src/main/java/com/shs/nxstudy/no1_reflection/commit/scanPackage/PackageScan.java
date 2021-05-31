package com.shs.nxstudy.no1_reflection.commit.scanPackage;

import java.io.File;
import java.net.URL;
import java.util.Enumeration;

/**
 * @Author 沈会山
 * @Description //扫描包并操作包下的类
 * @Date 22:26 2020/7/27
 * @Param
 * @return
 **/
public class PackageScan {
    public ClassLoader classLoader = PackageScan.class.getClassLoader();
    //扫描指定包
    public void scanPackage(String packageName) throws Exception {
        //包路径
        String packagePath = "";
        if(packageName.contains(".")){
            packagePath = packageName.replace(".","/");
        }
        //通过类加载获取包的路径Enumeration<URL>集合
        Enumeration<URL> resource = classLoader.getResources(packagePath);
        //循环遍历包路径
        while (resource.hasMoreElements()){//包名是否存在
            //获取包的绝对路径
            URL url = resource.nextElement();
            File file = new File(url.toURI());
            //如果文件是目录
            if(file.isDirectory()){
                dealFiles(packageName,file);
            }else{
                //如果该文件不是目录。
                String name = file.getName();
                //该文件是class类型
                if(name.contains(".class")) {
                    //处理它
                    deaJavaFile(file, packageName);
                } else {
                    continue;
                }
            }
        }
    }

    //处理包的文件
    private void dealFiles(String packageName, File file) throws Exception {
        //安全期间判断下文件是否存在，存在的话进行操作
        if(file.exists()) {
            //file一定是目录型文件所以得到该目录下所有文件遍历它们
            File[] files = file.listFiles();
            for(File childfile : files) {
                //如果子文件是目录，则递归处理，调用本方法递归。
                if(childfile.isDirectory()) {
                    //注意递归时候包名字要加上".文件名"后为新的包名
                    //因为后面反射时需要类名，也就是com.mec.***
                    dealFiles(packageName + "." + childfile.getName(), childfile);
                } else {
                    //如果该文件不是目录。
                    String name = childfile.getName();
                    //该文件是class类型
                    if(name.contains(".class")) {
                        //处理它
                        deaJavaFile(childfile, packageName);
                    } else {
                        continue;
                    }
                }
            }
        } else {
            return;
        }
    }

    /**
     * @Author 沈会山
     * @Description //处理java文件
     * @Date 22:34 2020/7/27
     * @Param [file, packageName/上级目录路径]
     * @return void
     **/
    public void deaJavaFile(File file,String packageName) throws Exception {
        //获取文件类型最后.的索引
        int lastPoint = file.getName().lastIndexOf(".class");
        //获取获取类名
        String javaPath = file.getName().substring(0, lastPoint);
        //class.forName()前者除了将类的.class文件加载到jvm中之外，还会对类进行解释，执行类中的static块。
        //注意这里的静态块指的是在类初始化时的一些数据。但是classloader却没有


        Class<?> clazz = Class.forName(packageName+"."+javaPath);
        AnnotationTest.scanTestAnnotation(clazz);
    }
}
