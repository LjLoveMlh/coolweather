package com.example.coolweather.util;

import android.text.TextUtils;

import com.example.coolweather.db.City;
import com.example.coolweather.db.County;
import com.example.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 大叔! on 2017/9/23.
 */
public class Utility {
    /**
     *解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)) {
            try {
            JSONArray allProvinces=new JSONArray(response);
            for(int i=0;i<allProvinces.length();i++){
                JSONObject provinceObiect=allProvinces.getJSONObject(i);
                Province province=new Province();
                    province.setProvinceName(provinceObiect.getString("name"));
                province.setProvinceCode(provinceObiect.getInt("id"));
                province.save();
            }
            return  true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    /**
     *解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(String response,int provinceId){
        if(!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCities=new JSONArray(response);
                for(int i=0;i<allCities.length();i++){
                    JSONObject cityObiect=allCities.getJSONObject(i);
                    City city=new City();
                    city.setCiytName(cityObiect.getString("name"));
                    city.setCityCode(cityObiect.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return  true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     *解析和处理服务器返回县级数据
     */
    public static boolean handleCountyResponse(String response,int cityId){
        if(!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCounties=new JSONArray(response);
                for(int i=0;i<allCounties.length();i++){
                    JSONObject countyObiect=allCounties.getJSONObject(i);
                    County county=new County();
                    county.setCountyName(countyObiect.getString("name"));
                    county.setWeatherId(countyObiect.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return  true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
