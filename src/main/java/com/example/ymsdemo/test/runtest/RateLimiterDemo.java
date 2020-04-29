package com.example.ymsdemo.test.runtest;

import com.google.common.util.concurrent.RateLimiter;

/**
 * 令牌桶方法限流 RateLimter
 */
public class RateLimiterDemo {
    static Task task = new Task();
    static RateLimiter limiter = RateLimiter.create(2);
    public static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<50;i++){
            limiter.acquire();
            new Thread(task).start();
        }
    }

}
