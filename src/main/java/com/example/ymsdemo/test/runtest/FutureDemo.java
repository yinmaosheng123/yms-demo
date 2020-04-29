package com.example.ymsdemo.test.runtest;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;


import java.util.concurrent.Executors;

/**
 * Guava对Future模式的支持
 * Guava增加了对Future模式完成时的回调接口，
 * 使得Future完成时可以自动通知应用程序进行后续处理
 *
 * 带有回调的异步处理线程
 */
public class FutureDemo {
    public static void main(String[] args) throws InterruptedException{
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        ListenableFuture<String> task = service.submit(new RealData("x"));
        task.addListener( ()->{
            System.out.println("异步处理成功！");
            try {
                System.out.println(task.get());
            } catch (Exception e){
                e.printStackTrace();
            }
                },MoreExecutors.directExecutor()

        );
        System.out.println("main task done");
        Thread.sleep(3000);
    }
}
