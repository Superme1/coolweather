package com.example.coolweather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by wangdong on 2018/5/26.
 */

//*********用于和服务器进行连接的工具
public class HttpUtil {
    public static void sendOKHttpRequest(String address,okhttp3.Callback callback){
        //固定步骤
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
