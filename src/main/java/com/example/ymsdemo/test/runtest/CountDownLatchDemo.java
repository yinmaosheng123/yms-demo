package com.example.ymsdemo.test.runtest;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException{
        System.out.println("主线程开始～～～");
        Thread thread = new Thread(new Worker());
        thread.start();
        System.out.println("主线程等待～～～");
        System.out.println(latch.toString());
        latch.await();
        System.out.println(latch.toString());
        System.out.println("主线程继续`~~~~");

    }

    public static class Worker implements Runnable{
        @Override
        public void run() {
            System.out.println("子线程任务正在执行");
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){

            }finally {
                latch.countDown();
            }
        }
    }


}
