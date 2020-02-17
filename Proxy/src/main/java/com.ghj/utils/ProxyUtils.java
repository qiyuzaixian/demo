package com.ghj.utils;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;

public class ProxyUtils {

    public static Object newInstance(Object target){
        String content ="package Impl;\n" +
                "\n" +
                "import com.ghj.service.UserService;\n" +
                "\n" +
                "public class $UserServiceProxyImpl implements UserService {\n" +
                "\n" +
                "    private UserService target;\n" +
                "    public $UserServiceProxyImpl(UserService target){\n" +
                "        this.target = target;\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void query() {\n" +
                "        System.out.println(\"proxy  -----\");\n" +
                "        target.query();\n" +
                "    }\n" +
                "}\n";
        File file = new File("E:\\app\\Impl\\$UserServiceProxyImpl.java");
        file.mkdir();
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.flush();
            writer.close();

            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

            // 动态编译
            StandardJavaFileManager fileManager = compiler.getStandardFileManager(null,null,null);
            Iterable units = fileManager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask t = compiler.getTask(null,fileManager,null,null,null,units);
            t.call();
            fileManager.close();


            // 类加载，反射创建对象
            URL[] urls =new URL[]{new URL("file:E:\\\\app\\\\")};
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            Class cls = urlClassLoader.loadClass("Impl.$UserServiceProxyImpl");

            Constructor constructor =cls.getConstructor(target.getClass().getInterfaces()[0]);
            Object proxy =constructor.newInstance(target);
            return proxy;
        }catch (Exception e){
        }
        return null;
    }
}
