package com.ghj.service.Impl;

import com.ghj.service.UserService;

public class UserServiceProxyImpl implements UserService {

    private UserService target;
    public UserServiceProxyImpl(UserService target){
        this.target = target;
    }

    @Override
    public void query() {
        System.out.println("proxy  -----");
        target.query();
    }
}
