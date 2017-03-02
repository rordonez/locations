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
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
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
    public void getPostcodeShouldCallAThirdPartyApiToSearchByPostcode() throws Exception {
        String aPostcode = "SOME";
        given(postcodeApi.getAddressListBy(aPostcode))
                .willReturn(new ArrayList<>());

        ResultActions response = this.mvc.perform(get("/postcodes/{postcode}", aPostcode)
                .accept(MediaType.APPLICATION_JSON_UTF8));

        response.andExpect(status().isOk());
        Mockito.verify(postcodeApi).getAddressListBy(aPostcode);
    }

    @Test
    public void getPostcodeShouldReturnAListOfAddressWithStreetAndName() throws Exception {
        List<Address> addressList = mockListOfAddresses();
        String aPostcode = "SOME";
        given(postcodeApi.getAddressListBy(aPostcode))
                .willReturn(addressList);

        ResultActions response = this.mvc.perform(get("/postcodes/{postcode}", aPostcode)
                .accept(MediaType.APPLICATION_JSON_UTF8));

        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.addressList", hasSize(addressList.size())))
                .andExpect(jsonPath("$.addressList[*].street", hasSize(greaterThan(0))))
                .andExpect(jsonPath("$.addressList[*].buildingName", hasSize(greaterThan(0))));
    }

    private List<Address> mockListOfAddresses() {
        return Arrays.asList(new Address("Street 1", "Building name 1"), new Address("Street 2"), new Address("Street 3", "Building name 3"));
    }
}
