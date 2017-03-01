package com.example.locations.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by rafa on 01/03/2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PostcodesController.class)
public class PostcodesControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getPostcodeEndpointShouldExist() throws Exception {
        String aPostcode = "SOME";

        ResultActions response = this.mvc.perform(get("/postcodes/{postcode}", aPostcode));

        response.andExpect(status().isOk());
    }
}
