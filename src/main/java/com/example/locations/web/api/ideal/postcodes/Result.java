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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result1 = (Result) o;

        return result != null ? result.equals(result1.result) : result1.result == null;
    }

    @Override
    public int hashCode() {
        return result != null ? result.hashCode() : 0;
    }
}
