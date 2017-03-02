package com.example.locations.web.api.ideal.postcodes;

import com.example.locations.web.Address;
import org.junit.Assert;
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
import java.util.Arrays;
import java.util.List;

import static com.example.locations.web.api.ideal.postcodes.Postcode.Builder.aPostcode;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.empty;
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
                .willReturn(new ResponseEntity<>(new Result(), HttpStatus.OK));

        idealPostcodesApi.getAddressListBy(POSTCODE);

        Mockito.verify(client).getForEntity(uri, Result.class);
    }

    @Test
    public void getAddressListByPostcodeShouldMapResultsIntoAListOfAddresses() throws Exception {
        URI uri = idealPostcodesApi.createURIForPostcodesUsing(POSTCODE);
        given(client.getForEntity(uri, Result.class))
                .willReturn(new ResponseEntity<>(new Result(mockListOfPostcodes()), HttpStatus.OK));

        List<Address> addressList = idealPostcodesApi.getAddressListBy(POSTCODE);

        Assert.assertThat(addressList, is(not(empty())));
        assertListOfAddresses(addressList);
    }

    private void assertListOfAddresses(List<Address> addressList) {
        Assert.assertThat(addressList.get(0).getStreet(), is("12, Lemon St, London, N1 ABC"));
        Assert.assertThat(addressList.get(0).getBuildingName(), is("Yellow Building"));
        Assert.assertThat(addressList.get(1).getStreet(), is("Flat 3, 123, Beatles St, London, N3 ZZZ"));
        Assert.assertThat(addressList.get(1).getBuildingName(), nullValue());
        Assert.assertThat(addressList.get(2).getStreet(), is("Flat 3, 32 Liverpool Rd, London, N1 ABC, Berna House"));
        Assert.assertThat(addressList.get(2).getBuildingName(), is("Berna House"));
    }

    private List<Postcode> mockListOfPostcodes() {
        return Arrays.asList(
          aPostcode()
                  .withLine1("12, Lemon St")
                  .withLine2("London, N1 ABC")
                  .withBuildingName("Yellow Building")
                  .build(),
          aPostcode()
                  .withLine1("Flat 3")
                  .withLine2("123, Beatles St")
                  .withLine3("London, N3 ZZZ")
                  .build(),
          aPostcode()
                  .withLine1("Flat 3, 32 Liverpool Rd")
                  .withLine2("London, N1 ABC")
                  .withLine3("Berna House")
                  .withBuildingName("Berna House")
                  .build()
        );
    }

}
