package com.example.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by wangdong on 2018/5/26.
 */
//创建表格，用来存储省的数据信息
public class Province extends DataSupport {
    private int id;     //省的id
    private String provinceName;   //省的名字
    private int provinceCode;    //省的代号

    public int getId() {
        return id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
}
