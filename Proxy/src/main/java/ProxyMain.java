import com.ghj.service.UserService;
import com.ghj.service.Impl.UserServiceImpl;
import com.ghj.utils.ProxyUtils;

import java.lang.reflect.InvocationHandler;

public class ProxyMain {
    public static void main(String args[]){
        UserService userService = new UserServiceImpl();
        UserService proxy =(UserService)ProxyUtils.newInstance(userService);
        proxy.query();
    }
}
