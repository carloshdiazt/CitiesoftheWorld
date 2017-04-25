package com.example.diazt.citiesoftheworld.models;

public class Legend {

    private IndicatorsPlaces[] places;
    private String query;

    public Legend() {
    }

    public IndicatorsPlaces[] getPlaces() {
        return this.places;
    }

    public void setPlaces(IndicatorsPlaces[] places) {
        this.places = places;
    }


    public String getQuery() {
        return this.query;
    }

    public void setQuery(String query) {
        this.query = query;
    }


}
