package com.example.diazt.citiesoftheworld.network;

import com.example.diazt.citiesoftheworld.models.Legend;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by diazt on 20-04-2017.
 */

public interface Country {

    @GET("geocode")
    Call<Legend> get(@QueryMap Map<String, String> queryMap);


}
