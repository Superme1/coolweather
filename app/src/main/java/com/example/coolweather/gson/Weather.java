package com.example.coolweather.gson;

import android.support.v4.app.NotificationCompat;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by wangdong on 2018/5/28.
 */

//总的实体类，用来引用其他几个分实体类
public class Weather {
    public String status;
    public Basic basic;
    public AQI aqi;
    public Now now;
    public Suggestion suggestion;

    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;
}
