package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo04 {
    public static void main(String args[]){
        ThreadDemo05[] demos=new ThreadDemo05[10];
        for(int i=0;i<10;i++){
            demos[i] = new ThreadDemo05();
        }
        for (int i=0;i<10;i++){
            new Thread(demos[i]).start();
        }
    }
}
class ThreadDemo05 implements  Runnable{
    public static AtomicInteger count=new AtomicInteger(0);
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            count.incrementAndGet();
            System.out.println("count"+count);
        }
    }
}
