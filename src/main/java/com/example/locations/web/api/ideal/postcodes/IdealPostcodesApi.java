package com.example.locations.web.api.ideal.postcodes;

import com.example.locations.web.Address;
import com.example.locations.web.api.PostcodeApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

@Service
public class IdealPostcodesApi implements PostcodeApi {

    private static final String API_KEY_QUERY_PARAM = "api_key";

    private RestTemplate client;

    @Value("${ideal.postcode.api.url}")
    private String url;

    @Value("${ideal.postcode.api.key}")
    private String apiKey;

    public IdealPostcodesApi(RestTemplate client) {
        this.client = client;
    }

    @Override
    public List<Address> getAddressListBy(String postcode) {
        client.getForEntity(createURIForPostcodesUsing(postcode), Result.class);
        return null;
    }

    public URI createURIForPostcodesUsing(String postcode) {
        return  fromUriString(url)
                .path("/postcodes/{postcode}")
                .queryParam(API_KEY_QUERY_PARAM, apiKey)
                .buildAndExpand(postcode)
                .toUri();
    }

}
