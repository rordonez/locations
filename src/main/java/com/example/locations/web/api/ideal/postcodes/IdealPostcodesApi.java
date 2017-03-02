package com.example.locations.web.api.ideal.postcodes;

import com.example.locations.web.Address;
import com.example.locations.web.api.PostcodeApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
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
                .map(postcodeToAddress)
                .collect(Collectors.toList());
    }

    public URI createURIForPostcodesUsing(String postcode) {
        return  fromUriString(url)
                .path("/postcodes/{postcode}")
                .queryParam(API_KEY_QUERY_PARAM, apiKey)
                .buildAndExpand(postcode)
                .toUri();
    }

    private Function<Postcode, Address> postcodeToAddress =
            postcode -> new Address(
                    extractStreetAddressFrom(postcode),
                    postcode.getBuildingName()
            );

    private String extractStreetAddressFrom(Postcode postcode) {
        return Stream.of(postcode.getLine1(), postcode.getLine2(), postcode.getLine3())
                .filter(isEmpty.negate())
                .collect(joining(", "));

    }

    Predicate<String> isEmpty = StringUtils::isEmpty;
}
