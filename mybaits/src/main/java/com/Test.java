package com;

import com.ghj.User;
import com.ghj.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Test {
    public static void main(String args[]){
        User user= new User();

        try {
            Method method = user.getClass().getMethod("test",String.class,String.class);
            Parameter[] parameters = method.getParameters();
            System.out.println(parameters[0].getName());
        }catch (Exception e){

        }
    }
}
