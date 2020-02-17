package com;

import java.util.concurrent.CountDownLatch;

public class MyThread extends Thread{
    CountDownLatch latch;
    public  MyThread(CountDownLatch latch){
        this.latch = latch;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("XXXXXXXXXXXXX");
        }catch (Exception e){
        }finally {
            latch.countDown();
        }
    }
}
