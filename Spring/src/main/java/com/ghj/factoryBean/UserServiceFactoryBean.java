package com.ghj.factoryBean;

import com.ghj.Service.Impl.UserServiceImpl;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

public class UserServiceFactoryBean implements FactoryBean {
    public void query(){
        System.out.println("========");
    }
    public String msg;
    public void setMsg(String msg){
        this.msg =msg;
    }
    @Override
    public Object getObject() throws Exception {
        return new UserServiceImpl(msg);
    }

    @Override
    public Class<?> getObjectType() {
        return UserServiceImpl.class;
    }
}
