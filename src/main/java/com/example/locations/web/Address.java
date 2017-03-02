package com.example.locations.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by rafa on 01/03/2017.
 */
public class Address {
    private final String street;
    private final String buildingName;

    @JsonCreator
    public Address(@JsonProperty("street") String street, @JsonProperty("buildingName") String buildingName) {
        this.street = street;
        this.buildingName = buildingName;
    }

    @JsonCreator
    public Address(@JsonProperty("street") String street) {
        this.street = street;
        this.buildingName = null;
    }

    public String getStreet() {
        return street;
    }

    public String getBuildingName() {
        return buildingName;
    }
}
