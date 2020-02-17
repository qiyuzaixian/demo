package test;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {
    @Pointcut("execution(* com.service.*(..))")
    public void pointCut(){

    }
    @Before("pointCut()")
    public void advise(){
        System.out.println("before");
    }
}
