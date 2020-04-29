package com.example.ymsdemo.test.runtest;

import java.util.concurrent.CompletableFuture;

public class AskThread implements Runnable{
    CompletableFuture<Integer> re = null;

    public AskThread(CompletableFuture<Integer> re){
        this.re = re;
    }

    @Override
    public void run(){
        int myRe = 0;
        try {
            myRe = re.get() * re.get();
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(myRe);
    }

    public static void main(String[] args) {
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        new Thread(new AskThread(future)).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        future.complete(30);
    }




}
