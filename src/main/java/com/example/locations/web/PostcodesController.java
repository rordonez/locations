package com.example.locations.web;

import com.example.locations.web.api.PostcodeApi;
import com.example.locations.web.api.ideal.postcodes.IdealPostcodesApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rafa on 01/03/2017.
 */
@RestController
@RequestMapping(value = "/postcodes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PostcodesController {
    private static final Logger log = LoggerFactory.getLogger(PostcodesController.class);

    private PostcodeApi postcodeApi;

    public PostcodesController(PostcodeApi postcodeApi) {
        this.postcodeApi = postcodeApi;
    }

    @GetMapping(value = "/{postcode}")
    public ResponseEntity<PostcodeResponse> getPostcodeBy(@PathVariable String postcode) {
        log.info("Requesting controller method /postcodes/{postcode with postcode: {}", postcode);

        return new ResponseEntity<>(new PostcodeResponse(postcodeApi.getAddressListBy(postcode)), HttpStatus.OK);
    }
}
