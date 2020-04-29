package com.example.ymsdemo.service.Impl;

import com.example.ymsdemo.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Yves Yin
 * @version 1.0.0
 * @date 20-4-29 下午5:07
 * @desc
 */
@Service
public class AsyncServiceImpl implements AsyncService {

    private static final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);

    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync() {
        logger.info("start executeAsync");
        try {
            Thread.sleep(10000);
        } catch (Exception e){
            e.printStackTrace();
        }
        logger.info("end ExecuteAsync");

    }
}
