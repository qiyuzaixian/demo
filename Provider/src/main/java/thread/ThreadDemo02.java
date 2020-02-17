package thread;
// 守护线程
public class ThreadDemo02 {
    static class ThreadDemo04 implements  Runnable{
        @Override
        public void run() {
            for(int i=0;i<30;i++){
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                }
                System.out.println("我是子线程");
            }
        }
    }
    public static void main(String args[]){
        ThreadDemo04 thread = new ThreadDemo04();
        Thread t1= new Thread(thread);
        t1.setDaemon(true);
        t1.start();
        for(int i =0;i<30;i++){
            System.out.println(i);
        }
    }
}
