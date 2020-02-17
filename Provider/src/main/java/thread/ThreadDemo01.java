package thread;
// join方法
public class ThreadDemo01 {
    static class  JoinThread implements Runnable{

        @Override
        public void run() {
            for(int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getId()+"--"+i);
            }
        }
    }
    public static void main(String args[]){
        JoinThread j1 = new JoinThread();
        JoinThread j2 = new JoinThread();

        Thread t1= new Thread(j1);
        Thread t2 = new Thread(j2);
        t1.start();
        t2.start();
        try{
            t1.join();   // join控制线程的执行顺序，先执行t1，t2线程在执行主线程。
            t2.join();
        }catch (Exception e){}
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getId()+"--"+i);
        }
    }
}
