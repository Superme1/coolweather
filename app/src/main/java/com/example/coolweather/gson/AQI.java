package com.example.coolweather.gson;

/**
 * Created by wangdong on 2018/5/28.
 */
//************??????????//////为什么有的加@@@，有的没加
public class AQI {
    public AQICity city;
    public class AQICity{
        public String aqi;
        public String pm25;
    }
}
