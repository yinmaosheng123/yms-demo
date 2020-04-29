package com.example.ymsdemo.test.runtest;

/**
 * 守护线程（daemon）
 */
public class DeamonDemo {
    public static class DeamonT extends Thread{
        @Override
        public void run(){
            while (true){
                System.out.println("I am alive");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread t = new DeamonT();
        t.setDaemon(true);
        t.start();
        Thread.sleep(2000);
    }

}
