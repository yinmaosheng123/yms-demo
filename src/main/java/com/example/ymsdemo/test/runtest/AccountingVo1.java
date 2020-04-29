package com.example.ymsdemo.test.runtest;

/**
 * 关键字synchronized   实现加锁
 */
public class AccountingVo1 implements Runnable {
    static AccountingVo1 instance = new AccountingVo1();
    static volatile int i = 0;
    public synchronized void increase(){
        i++;
    }

    @Override
    public void run(){
        for(int j=0;j<1000000;j++){
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }



}
