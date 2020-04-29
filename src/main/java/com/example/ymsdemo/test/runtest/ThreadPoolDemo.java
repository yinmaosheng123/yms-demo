package com.example.ymsdemo.test.runtest;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池创建   以newFixedThreadPool为例
 */
public class ThreadPoolDemo {
    public static class MyTask implements Runnable{
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thread ID:"
            + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }


    public static void main(String[] args) {
        MyTask task = new MyTask();
        ExecutorService ex = Executors.newCachedThreadPool();

        for(int i = 0;i<10;i++){
            ex.submit(task);
        }
    }

}
