package com.example.test.domain.model;

import com.example.test.domain.model.CardInfoItemModel;

public class CountryInfoItemModel implements CardInfoItemModel {

    private String header;
    private String headerCoordinate;
    private String countryName;
    private String coordinate;

    public CountryInfoItemModel(String header, String headerCoordinate, String countryName, String coordinate) {
        this.header = header;
        this.headerCoordinate = headerCoordinate;
        this.countryName = countryName;
        this.coordinate = coordinate;
    }

    @Override
    public String header() {
        return null;
    }

    public String getHeader() {
        return header;
    }

    public String getHeaderCoordinate() {
        return headerCoordinate;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCoordinate() {
        return coordinate;
    }

    @Override
    public String toString() {
        return "CountryInfoItemModel{" +
                "countryInfo='" + header + '\'' +
                ", country='" + headerCoordinate + '\'' +
                ", latitude='" + countryName + '\'' +
                ", longitude='" + coordinate + '\'' +
                '}';
    }
}
