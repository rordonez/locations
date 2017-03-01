package com.example.locations.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by rafa on 01/03/2017.
 */
public class PostcodeResponse {
    private final List<Address> addressList;

    @JsonCreator
    public PostcodeResponse(@JsonProperty("addressList") List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Address> getAddressList() {
        return addressList;
    }
}
