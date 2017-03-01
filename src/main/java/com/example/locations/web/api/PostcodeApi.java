package com.example.locations.web.api;

import com.example.locations.web.Address;

import java.util.List;

/**
 * Created by rafa on 01/03/2017.
 */
public interface PostcodeApi {
    List<Address> getAddressListBy(String postcode);
}
