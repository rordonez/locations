package com.example.locations.web.api.ideal.postcodes;

import com.example.locations.web.Address;
import com.example.locations.web.api.PostcodeApi;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.collection.IsEmptyCollection.empty;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IdealPostcodesApiIT {

    @Autowired
    private PostcodeApi idealPostcodesApi;

    @Test
    public void getAddressListByPostcodeShouldIntegrateWithIdealPostcodesApi() throws Exception {
        List<Address> addressList = idealPostcodesApi.getAddressListBy("N76LJ");

        Assert.assertThat(addressList, is(not(empty())));
    }
}