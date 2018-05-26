package com.example.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by wangdong on 2018/5/26.
 */
//用来创建市的表格
public class City extends DataSupport {
    private int id;       //市的id
    private String cityName;   //市的名字
    private int cityCode;    //市的代号
    private int provinceId;   //市所属省的id

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getProvinceId() {
        return provinceId;
    }
}
