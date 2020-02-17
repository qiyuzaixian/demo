import com.ghj.Service.Impl.UserServiceImpl;
import com.ghj.Service.UserService;
import com.ghj.common.BeanProcessor;
import com.ghj.config.AppConfig;
import com.ghj.dao.UserDao;
import com.ghj.factoryBean.UserServiceFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;


public class UserApplicationContext {
    public static void main(String args[]){
       /* AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.addBeanFactoryPostProcessor(new BeanProcessor());
        context.register(AppConfig.class);
        context.refresh();

        *//*UserServiceImpl userService= (UserServiceImpl) context.getBean("userServiceFactoryBean");
        userService.query();

        UserServiceFactoryBean bean= (UserServiceFactoryBean) context.getBean("&userServiceFactoryBean");
        bean.query();*//*
        *//*UserService userService =  context.getBean(UserService.class);
        userService.query();*//*

        UserDao userDao = (UserDao) context.getBean(UserDao.class);
        System.out.println(userDao);*/
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        UserService userService=  context.getBean(UserService.class);
        userService.query();

        CountDownLatch count = new CountDownLatch(5);
        count.countDown();

    }
}
