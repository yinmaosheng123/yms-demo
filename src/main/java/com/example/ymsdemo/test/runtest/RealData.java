package com.example.ymsdemo.test.runtest;


import java.util.concurrent.Callable;

public class RealData implements Callable<String> {
    private String para;
    public RealData(String para){
        this.para = para;
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<10;i++){
            sb.append(para);
            System.out.println(i);
            try{
                Thread.sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }


        return sb.toString();
    }
}
