package com.example.locations.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rafa on 01/03/2017.
 */
@RestController
@RequestMapping("/postcodes")
public class PostcodesController {

    @GetMapping("/{postcode}")
    public ResponseEntity<Void> getPostcodeBy(@PathVariable String postcode) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
