package com.example.ymsdemo.feignclient;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import sun.awt.SunHints;

import java.util.HashMap;
import java.util.Map;

public interface RemoteService {

    @Headers("Content-Type: application/x-www-form-urlencoded;charset=UTF-8")
    @RequestLine("POST /IntelligentCommunity-v1/api/user/newLogin.json")
    HashMap getMessageWindow(@QueryMap Map<String,?> map);



}
