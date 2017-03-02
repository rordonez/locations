package com.example.locations.web.api.ideal.postcodes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private final List<Postcode> postcodeList;

    public Result() {
        this.postcodeList = new ArrayList<>();
    }

    @JsonCreator
    public Result(@JsonProperty("postcodeList") List<Postcode> postcodeList) {
        this.postcodeList = postcodeList;
    }

    public List<Postcode> getPostcodeList() {
        return postcodeList;
    }
}
