package com.example.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 大叔! on 2017/9/25.
 */
public class Now {
    @SerializedName("tmp")
    public  String temperature;
    @SerializedName("cond")
    public  More more;
    public class More{
        @SerializedName("txt")
        public String  info;

    }
}
