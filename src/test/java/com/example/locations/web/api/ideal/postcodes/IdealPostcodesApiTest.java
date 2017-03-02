package com.example.locations.web.api.ideal.postcodes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IdealPostcodesApiTest {

    public static final String POSTCODE = "SOME";

    @MockBean
    private RestTemplate client;

    @Autowired
    private IdealPostcodesApi idealPostcodesApi;

    @Test
    public void getAddressListByPostcodeShouldCallPostcodesEndpoint() throws Exception {
        URI uri = idealPostcodesApi.createURIForPostcodesUsing(POSTCODE);
        given(client.getForEntity(uri, Result.class))
                .willReturn(new ResponseEntity<>(HttpStatus.OK));

        idealPostcodesApi.getAddressListBy(POSTCODE);

        Mockito.verify(client).getForEntity(uri, Result.class);
    }
}
