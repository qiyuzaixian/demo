package com.ghj.demo;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
        String[] str = new String[]{"18163658394",
                "18694309780",
                "13222155556",
                "15209141128",
                "15150954649",
                "13333693335",
                "13937912326",
                "15887955477",
                "13529730909",
                "13730315993",
                "18082159996",
                "18977106395",
                "15845633598",
                "15872031362",
                "15252346365",
                "18043417771",
                "18003708373",
                "15854992613",
                "18756461105",
                "18650136835",
                "13225327290",
                "18805693313",
                "13944071611",
                "13783970956",
                "15381815817",
                "13664323285",
                "18866600803",
                "18329793480",
                "15099609590",
                "13893092893",
                "13519533590",
                "17793225699",
                "13735353049",
                "13348595998",
                "15953769288",
                "15375643001",
                "15295316406",
                "15114743123",
                "18697718200",
                "15526444333",
                "15762603822",
                "18987526865",
                "18729444009",
                "18643211833",
                "13321438336",
                "17746452650",
                "15072346824",
                "13571138759",
                "18336802827",
                "18393078698",
                "13204563030",
                "13581552670",
                "15004546728",
                "13333636693",
                "18438181777"
        };
        List<User> users = new ArrayList<>();
        for(int i=0;i<str.length;i++){
            User user = new User();
            user.setPhone(str[i]);
            user.setPwd("12345");
            users.add(user);
        }
        System.out.println(JSON.toJSONString(users));
    }

    public static class User{
        String phone;
        String pwd;
        public void setPhone(String phone){
            this.phone = phone;
        }
        public String getPhone(){
            return this.phone;
        }
        public void setPwd(String pwd){
            this.pwd =pwd;
        }
        public String getPwd(){
            return this.pwd;
        }
    }

}

