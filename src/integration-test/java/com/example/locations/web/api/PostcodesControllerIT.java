package com.example.locations.web.api;

import com.example.locations.LocationsApplication;
import com.example.locations.web.PostcodeResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.empty;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = LocationsApplication.class)
public class PostcodesControllerIT {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void shouldReturnResultsForW60LG() {
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<PostcodeResponse> response = restTemplate.exchange(
                createURLWithPort("/postcodes/W60LG"),
                HttpMethod.GET, entity, PostcodeResponse.class);

        Assert.assertThat(response.getStatusCode(), is(HttpStatus.OK));
        Assert.assertThat(response.getBody().getAddressList(), is(not(empty())));
    }

    @Test
    public void shouldReturnResultsForSW1A2AA() {
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<PostcodeResponse> response = restTemplate.exchange(
                createURLWithPort("/postcodes/SW1A2AA"),
                HttpMethod.GET, entity, PostcodeResponse.class);

        Assert.assertThat(response.getStatusCode(), is(HttpStatus.OK));
        Assert.assertThat(response.getBody().getAddressList(), is(not(empty())));
    }

    @Test
    public void shouldReturnResultsForBT486DQ() {
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<PostcodeResponse> response = restTemplate.exchange(
                createURLWithPort("/postcodes/BT486DQ"),
                HttpMethod.GET, entity, PostcodeResponse.class);

        Assert.assertThat(response.getStatusCode(), is(HttpStatus.OK));
        Assert.assertThat(response.getBody().getAddressList(), is(not(empty())));
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
