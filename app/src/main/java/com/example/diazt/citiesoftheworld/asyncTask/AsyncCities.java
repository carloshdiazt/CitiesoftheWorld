package com.example.diazt.citiesoftheworld.asyncTask;

import android.os.AsyncTask;

import com.example.diazt.citiesoftheworld.models.IndicatorsPlaces;
import com.example.diazt.citiesoftheworld.models.Legend;
import com.example.diazt.citiesoftheworld.network.Country;
import com.example.diazt.citiesoftheworld.network.Interceptors;

import java.io.IOException;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by diazt on 20-04-2017.
 */

public abstract class AsyncCities extends AsyncTask<Map<String, String>, Integer, IndicatorsPlaces> {

    @Override
    protected IndicatorsPlaces doInBackground(Map<String, String>... params) {
        Country request = new Interceptors().get();

        Map<String, String> queryMap = params[0];
        queryMap.put("languageCode", "es");


        int code = 666;
        Call<Legend> call = request.get(queryMap);
        try {
            Response<Legend> response = call.execute();
            code = response.code();
            if (200 == code && response.isSuccessful()) {
                Legend legend = response.body();
                if (legend.getPlaces() != null && legend.getPlaces().length > 0) {

                    //Log.d("LEGEND", String.valueOf(indicatorsPlaces.length));

                    return legend.getPlaces()[0];
                } else {
                    return null;
                }
            } else {
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
            code = 888;
            return null;
        }
    }


}
