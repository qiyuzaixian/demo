package Concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo001 {
    static class Producer implements Runnable{
        private volatile boolean flag = true;
        private AtomicInteger count = new AtomicInteger();
        private BlockingQueue queue;
        public Producer(BlockingQueue queue){
            this.queue =queue;
        }
        public void stopThread(){
            this.flag = false;
        }
        @Override
        public void run() {

            try{
                while(flag){
                    System.out.println("正在生产数据");
                    String data ="data" + count.incrementAndGet();
                    System.out.println("数据："+data+"放入队列");
                    if(!queue.offer(data,2,TimeUnit.SECONDS)){
                        System.out.println("放入数据失败"+data);
                    }
                    Thread.sleep(100);
                }
            }catch (Exception e){
                Thread.currentThread().interrupt();
            }finally {
                System.out.println("退出生产者线程!");
            }

        }
    }
    static class Consume implements Runnable{
        private volatile boolean flag = true;
        private BlockingQueue queue;
        public Consume(BlockingQueue queue){
            this.queue =queue;
        }
        public void stopThread(){
            this.flag = false;
        }
        @Override
        public void run() {
            try{
                while(flag){
                    System.out.println("正从队列获取数据...");
                    String data = (String) queue.poll(2, TimeUnit.SECONDS);
                    if(data!= null){
                        System.out.println("拿到数据：" + data);
                        Thread.sleep(1000);
                    }else{
                        flag = false;
                    }
                }
            }catch (Exception e){

            }finally {

            }
        }
    }
    public static void main(String args[]) throws InterruptedException {
        BlockingQueue queue = new LinkedBlockingQueue(10) ;
        Producer p1 = new Producer(queue);
        Consume consume = new Consume(queue);
        new Thread(p1).start();
        new Thread(consume).start();
        Thread.sleep(10000);
        p1.stopThread();

    }
}
