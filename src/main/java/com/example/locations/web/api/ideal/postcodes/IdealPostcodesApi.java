package com.example.locations.web.api.ideal.postcodes;

import com.example.locations.web.Address;
import com.example.locations.web.api.PostcodeApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

@Service
public class IdealPostcodesApi implements PostcodeApi {

    private static final String API_KEY_QUERY_PARAM = "api_key";

    @Value("${ideal.postcodes.api.url}")
    private String url;

    @Value("${ideal.postcodes.api.key}")
    private String apiKey;

    private RestTemplate client;

    public IdealPostcodesApi(RestTemplate client) {
        this.client = client;
    }

    @Override
    public List<Address> getAddressListBy(String postcode) {
        ResponseEntity<Result> response = client.getForEntity(createURIForPostcodesUsing(postcode), Result.class);
        return response.getBody().getPostcodeList()
                .stream()
                .map(x -> new Address(""))
                .collect(Collectors.toList());
    }

    public URI createURIForPostcodesUsing(String postcode) {
        return  fromUriString(url)
                .path("/postcodes/{postcode}")
                .queryParam(API_KEY_QUERY_PARAM, apiKey)
                .buildAndExpand(postcode)
                .toUri();
    }

}
