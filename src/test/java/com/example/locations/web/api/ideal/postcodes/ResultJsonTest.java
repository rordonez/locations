package com.example.locations.web.api.ideal.postcodes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class ResultJsonTest {

    @Autowired
    private JacksonTester<Result> json;

    @Test
    public void deserializeResultWithEmptyListOfPostcodes() throws Exception {
        String content = "{\"result\":[]}";
        assertThat(this.json.parse(content)).isEqualTo(new Result(new ArrayList<>()));
        assertThat(this.json.parseObject(content).getResult()).isEmpty();
    }
}
