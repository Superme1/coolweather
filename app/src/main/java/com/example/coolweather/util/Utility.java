package com.example.coolweather.util;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.example.coolweather.db.City;
import com.example.coolweather.db.County;
import com.example.coolweather.db.Province;
import com.example.coolweather.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wangdong on 2018/5/26.
 */
    //**************服务器返回的省市县的数据以及天气数据都是json类型的，此工具类用于解析和处理这些数据
public class Utility {

    //***********解析和处理服务器返回的省级数据****************
    public static boolean handleProvinceResponse(String response){
        if (!TextUtils.isEmpty(response)){
            try {
                //JSON类型的数据是一个数组,可以循环输出
                JSONArray allProvince = new JSONArray(response);
                for (int i = 0;i < allProvince.length();i++){
                    JSONObject provinceObject = allProvince.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();         //此方法用于将数据存储到数据库当中
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
    //**************解析和处理服务器返回的市级数据
    public static boolean handleCityResponse(String response,int provinceId){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allCities = new JSONArray(response);
                for (int i = 0;i < allCities.length();i++){
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
    //******************解析和处理县级数据
    public static boolean handleCountyResponse(String response,int cityId){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allCounties = new JSONArray(response);
                for (int i = 0; i < allCounties.length(); i++) {
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
    //*******************将返回的JSON天气数据解析成Weather实体类
    public static Weather handleWeatherResponse(String response){
        try {
            //通过JSONObject和JSONArray将天气数据中的主体内容解析出来
//            Log.d("aaa","eeeeeeee");
            JSONObject jsonObject = new JSONObject(response);
//            Log.d("aaa","dddddd");
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            //由于我们之前已经按照上面的数据格式定义过相应的GSON实体类，因此只需要通过
            //调用fromJson（）方法就能直接将JSON数据转换成Weather对象了
            return new Gson().fromJson(weatherContent,Weather.class);
        }catch (Exception e){
            e.printStackTrace();
        }
//        Log.d("aaa","aaaaaaaaaaaaa");
        return null;
    }

}
