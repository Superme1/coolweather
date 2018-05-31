package com.example.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wangdong on 2018/5/28.
 */

public class Basic {
    @SerializedName("city")   //运用此注解让JSON字段和java字段之间建立映射关系
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;
    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
