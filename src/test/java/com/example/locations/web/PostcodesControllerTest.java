package com.example.locations.web;

import com.example.locations.web.api.PostcodeApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by rafa on 01/03/2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PostcodesController.class)
public class PostcodesControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PostcodeApi postcodeApi;

    @Test
    public void getPostcodeEndpointShouldExist() throws Exception {
        String aPostcode = "SOME";

        ResultActions response = this.mvc.perform(get("/postcodes/{postcode}", aPostcode));

        response.andExpect(status().isOk());
    }

    @Test
    public void getPostcodeShouldReturnContentInJsonFormat() throws Exception {
        String aPostcode = "SOME";

        ResultActions response = this.mvc.perform(get("/postcodes/{postcode}", aPostcode)
            .accept(MediaType.APPLICATION_JSON_UTF8));

        response.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void getPostcodeShouldReturnAListOfAddresses() throws Exception {
        String aPostcode = "SOME";

        ResultActions response = this.mvc.perform(get("/postcodes/{postcode}", aPostcode)
                .accept(MediaType.APPLICATION_JSON_UTF8));

        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.addressList").exists());
    }

    @Test
    public void getPostcodeShouldCallAThirdPartyApiToSearchByPostcode() throws Exception {
        String aPostcode = "SOME";
        given(postcodeApi.getAddressListBy(aPostcode))
                .willReturn(new ArrayList<>());

        ResultActions response = this.mvc.perform(get("/postcodes/{postcode}", aPostcode)
                .accept(MediaType.APPLICATION_JSON_UTF8));

        response.andExpect(status().isOk());
        Mockito.verify(postcodeApi).getAddressListBy(aPostcode);
    }
}
