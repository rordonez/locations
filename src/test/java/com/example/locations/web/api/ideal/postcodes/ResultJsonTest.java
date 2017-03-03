package com.example.locations.web.api.ideal.postcodes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class ResultJsonTest {

    @Autowired
    private JacksonTester<Result> json;

    @Test
    public void deserializeResultWithEmptyListOfPostcodes() throws Exception {
        String content = "{\"result\":[]}";
        assertThat(this.json.parse(content)).hasNoNullFieldsOrProperties();
        assertThat(this.json.parseObject(content).getResult()).isEmpty();
    }

    @Test
    public void deserializeResultWithNonEmptyListOfPostcodes() throws Exception {
        String result = "{" +
                "  \"result\": [" +
                "    {" +
                "      \"postcode\": \"N7 6LJ\"," +
                "      \"postcode_inward\": \"6LJ\"," +
                "      \"postcode_outward\": \"N7\"," +
                "      \"post_town\": \"LONDON\"," +
                "      \"dependant_locality\": \"\"," +
                "      \"double_dependant_locality\": \"\"," +
                "      \"thoroughfare\": \"Holloway Road\"," +
                "      \"dependant_thoroughfare\": \"\"," +
                "      \"building_number\": \"\"," +
                "      \"building_name\": \"419-427\"," +
                "      \"sub_building_name\": \"\"," +
                "      \"po_box\": \"\"," +
                "      \"department_name\": \"\"," +
                "      \"organisation_name\": \"Odeon Cinemas Ltd\"," +
                "      \"udprn\": 15539467," +
                "      \"umprn\": \"\"," +
                "      \"postcode_type\": \"S\"," +
                "      \"su_organisation_indicator\": \"Y\"," +
                "      \"delivery_point_suffix\": \"2H\"," +
                "      \"line_1\": \"Odeon Cinemas Ltd\"," +
                "      \"line_2\": \"419-427 Holloway Road\"," +
                "      \"line_3\": \"\"," +
                "      \"premise\": \"419-427\"," +
                "      \"longitude\": -0.122501114852409," +
                "      \"latitude\": 51.5587247582969," +
                "      \"eastings\": 530250," +
                "      \"northings\": 186097," +
                "      \"country\": \"England\"," +
                "      \"traditional_county\": \"Greater London\"," +
                "      \"administrative_county\": \"\"," +
                "      \"postal_county\": \"London\"," +
                "      \"county\": \"London\"," +
                "      \"district\": \"Islington\"," +
                "      \"ward\": \"St George's\"" +
                "    }," +
                "    {" +
                "      \"postcode\": \"N7 6LJ\"," +
                "      \"postcode_inward\": \"6LJ\"," +
                "      \"postcode_outward\": \"N7\"," +
                "      \"post_town\": \"LONDON\"," +
                "      \"dependant_locality\": \"\"," +
                "      \"double_dependant_locality\": \"\"," +
                "      \"thoroughfare\": \"Holloway Road\"," +
                "      \"dependant_thoroughfare\": \"\"," +
                "      \"building_number\": \"\"," +
                "      \"building_name\": \"429a\"," +
                "      \"sub_building_name\": \"\"," +
                "      \"po_box\": \"\"," +
                "      \"department_name\": \"\"," +
                "      \"organisation_name\": \"\"," +
                "      \"udprn\": 51897807," +
                "      \"umprn\": \"\"," +
                "      \"postcode_type\": \"S\"," +
                "      \"su_organisation_indicator\": \"\"," +
                "      \"delivery_point_suffix\": \"4R\"," +
                "      \"line_1\": \"429a Holloway Road\"," +
                "      \"line_2\": \"\"," +
                "      \"line_3\": \"\"," +
                "      \"premise\": \"429a\"," +
                "      \"longitude\": -0.122501114852409," +
                "      \"latitude\": 51.5587247582969," +
                "      \"eastings\": 530250," +
                "      \"northings\": 186097," +
                "      \"country\": \"England\"," +
                "      \"traditional_county\": \"Greater London\"," +
                "      \"administrative_county\": \"\"," +
                "      \"postal_county\": \"London\"," +
                "      \"county\": \"London\"," +
                "      \"district\": \"Islington\"," +
                "      \"ward\": \"St George's\"" +
                "    }" +
                "]" +
                "}";
        assertThat(this.json.parseObject(result).getResult()).isNotEmpty();
        assertThat(this.json.parseObject(result).getResult()).hasSize(2);
        assertThat(this.json.parseObject(result).getResult().get(0)).hasNoNullFieldsOrProperties();
        assertThat(this.json.parseObject(result).getResult().get(1)).hasNoNullFieldsOrProperties();

    }
}
