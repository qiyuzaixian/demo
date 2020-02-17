package com;

import java.util.concurrent.CountDownLatch;

public class Latch {
    public static void main(String args[]){
        CountDownLatch count = new CountDownLatch(5);
        for(int i =0;i<5;i++){
            MyThread thread = new MyThread(count);
            thread.start();
        }
        try {
            count.await();
            System.out.println("44444444444444");
        }catch (Exception e){

        }
    }

}
