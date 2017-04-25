package com.example.diazt.citiesoftheworld.main;

/**
 * Created by diazt on 20-04-2017.
 */

public class CityValidation {

    private CityCallback callback;

    public CityValidation(CityCallback callback) {
        this.callback = callback;
    }

    public void validation(String name){
        if(name.trim().length() > 0){

            callback.created(name);
        }else{
            callback.noName();

        }
    }
}
