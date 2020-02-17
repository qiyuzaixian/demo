package com.ghj.Service.Impl;

import com.ghj.Service.UserService;
import com.ghj.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    public UserServiceImpl(String msg){
        System.out.println(msg);
    }
    public UserServiceImpl(){
    }
    @Override
    @Transactional
    public void query() {
        System.out.println(userDao.query().toString());
        System.out.println("XXXX");
    }

    @Autowired
    private UserDao userDao;


}
