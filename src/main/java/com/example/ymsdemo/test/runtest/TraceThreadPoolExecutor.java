package com.example.ymsdemo.test.runtest;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 保存并打印提交任务线程的堆栈信息
 */
public class TraceThreadPoolExecutor extends ThreadPoolExecutor {
    public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                                   TimeUnit unit, BlockingQueue<Runnable> workQueue){

        super(corePoolSize,maximumPoolSize,keepAliveTime,unit,workQueue);
    }

    @Override
    public void execute(Runnable task){
        super.execute(wrap(task, clientStack(), Thread.currentThread().getName()));
    }

    @Override
    public Future<?> submit(Runnable task){
        return super.submit(wrap(task,clientStack(),Thread.currentThread().getName()));
    }

    private Exception clientStack(){
        return new Exception("client stack trace");
    }

    private Runnable wrap(final Runnable task, final Exception clientStack,String clientThreadName){
        return new Runnable() {
            @Override
            public void run() {
                try {
                    task.run();
                } catch (Exception e){
                    clientStack.printStackTrace();
                    throw e;
                }
            }
        };
    }

}
