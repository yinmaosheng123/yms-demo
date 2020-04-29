package com.example.ymsdemo.test.runtest;

import java.util.concurrent.*;

/**
 * Future 模式
 * 核心思想：异步调用
 * 当我们调用一个函数方法时，如果这个函数执行的很慢，那么我们就需要进行等待。
 * 但有时候我们可能并不急着要结果。因此，我们可以让被调用者立即返回，
 * 让他在后台慢慢处理这个请求。
 * 例子中是使用sdk中的future
 */
public class FutureMain {
    public static void main(String[] args) throws InterruptedException , ExecutionException {
        //构造FutureTask
        FutureTask<String> future = new FutureTask<>(new RealData("a"));
        ExecutorService executor = Executors.newFixedThreadPool(1);
        //执行FutureTask ,相当于上例中的client.request("a")发送请求
        //在这里开启线程进行RealData的call()方法执行
        executor.submit(future);
        System.out.println("请求完毕");

        try{
            //这里依然可以做
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        //相当于5.5.2节中的data.getResult() 方法，取得call()方法的返回值
        //如果此时call()方法没有执行完成，则依然会等待
        System.out.println("数据 = " + future.get());
        executor.shutdown();
    }

}
