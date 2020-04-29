package com.example.ymsdemo.feignclient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CommunityHandle {

    private static final Log logger = LogFactory.getLog(CommunityHandle.class);
    @Resource
    private FeignClient feignClient;

    public HashMap getMessageInfo(){
        String mobile = "18765906923";
        Map<String,String> map = new HashMap<>();
        map.put("mobile","18765906923");
        HashMap ret = getService().getMessageWindow(map);
        System.out.println(ret.toString());
        return ret;

    }




    private RemoteService getService(){
        RemoteService remoteService = null;
        try {
            remoteService = feignClient.getProxyService(RemoteService.class,"community-client","");
        } catch (IOException e){
            e.printStackTrace();
        }


        return remoteService;
    }

}
