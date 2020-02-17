package thread;

public class ThreadDemo03 {
    public static void main(String args[]){

        ThreadTrain train= new ThreadTrain();
        Thread t1 =new Thread(train,"窗口1");
        Thread t2 =new Thread(train,"窗口2");
        t1.start();
        t2.start();

    }
}
class ThreadTrain implements Runnable{
    private Object mutex = new Object();
    private String name;
    private static volatile int count=100;
    public void  run(){
         while(count>0){
            sale();
             try {
                 Thread.sleep(100);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
    }
    private void sale(){
        synchronized (mutex){
            if(count>0){
                System.out.println(Thread.currentThread().getName()+"售出第"+(100-count+1)+"张票");
                count--;
            }

        }
    }
}
