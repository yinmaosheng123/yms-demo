package com.example.ymsdemo.okhttp3client;


import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CommunityTest {
    String url = "http://221.122.92.15:7531";
    public String newLogin(){
        String postUrl = "/IntelligentCommunity-v1/api/user/newLogin.json";
        String re = "";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("mobile","18765906923")
                .build();
        Request request = new Request.Builder()
                .url(url+postUrl)
                .post(requestBody)
                .build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            re = response.body().string();
            System.out.println(re);
        } catch (IOException e){
            e.printStackTrace();
        }
        return re;
    }


}
