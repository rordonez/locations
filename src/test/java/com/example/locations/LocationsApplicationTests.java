package com.example.locations;

import com.example.locations.web.PostcodesController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationsApplicationTests {
    @Autowired
    private PostcodesController controller;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }
}
