package Demo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private static DemoApplication demo;
    @PostConstruct
    private void postConstruct(){
        demo =this;
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        SessionCallback callback = new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                redisOperations.multi();
                redisOperations.opsForValue().get("hello");
                Object val = redisOperations.exec();
                return val;
            }
        };
        Object val =demo.stringRedisTemplate.execute(callback);
        System.out.println(val);
    }

    private void init(){
        stringRedisTemplate.opsForValue().get("");

        BeanWrapper bw =PropertyAccessorFactory.forBeanPropertyAccess(this); // 操作一个javaBean属性

        BeanUtils.instantiateClass(this.getClass());    // 创建一个对象。
    }

}

