package com.example.locations.web.api.ideal.postcodes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private final List<Postcode> result;

    public Result() {
        this.result = new ArrayList<>();
    }

    @JsonCreator
    public Result(@JsonProperty("result") List<Postcode> result) {
        this.result = result;
    }

    public List<Postcode> getResult() {
        return result;
    }
}
