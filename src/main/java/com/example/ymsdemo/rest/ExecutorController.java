package com.example.ymsdemo.rest;

import com.example.ymsdemo.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yves Yin
 * @version 1.0.0
 * @date 20-4-29 下午5:11
 * @desc
 */
@RestController
public class ExecutorController {
    private static final Logger logger = LoggerFactory.getLogger(ExecutorController.class);

    @Autowired
    private AsyncService service;

    @RequestMapping("/executor")
    public String submit(){
        logger.info("start submit");
        service.executeAsync();
        logger.info("end submit");
        return "success";

    }

}
