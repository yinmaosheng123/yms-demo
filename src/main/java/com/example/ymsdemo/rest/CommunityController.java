package com.example.ymsdemo.rest;

import com.example.ymsdemo.feignclient.CommunityHandle;
import com.example.ymsdemo.okhttp3client.CommunityTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/community/")
public class CommunityController {
    @Resource
    private CommunityHandle communityHandle;

    @Resource
    private CommunityTest communityTest;


    @RequestMapping(value = "/getMessageInfo", method = RequestMethod.POST)
    @ResponseBody
    public Map getMessageInfo(){
        return communityHandle.getMessageInfo();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String newLogin(){
        return communityTest.newLogin();
    }

}
