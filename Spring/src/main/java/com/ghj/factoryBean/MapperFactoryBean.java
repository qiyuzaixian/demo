package com.ghj.factoryBean;

import com.ghj.dao.UserDao;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MapperFactoryBean implements FactoryBean, InvocationHandler {

    Class cls;
    public MapperFactoryBean(Class cls){
        this.cls = cls;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(this,args);
    }

    @Override
    public Object getObject() throws Exception {
        Class[] classes = new Class[]{cls};
        Object proxy =Proxy.newProxyInstance(this.getClass().getClassLoader(),classes,this);
        return proxy;
    }

    @Override
    public Class<?> getObjectType() {
        return cls;
    }
}
