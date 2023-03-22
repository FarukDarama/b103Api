package homeworks;

import base_urls.ZippopotamBaseUrl;
import com.fasterxml.jackson.databind.util.CompactStringObjectMap;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.ZipopotTestData;
import util.ObjectMapperUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class HomeworkCan02 extends ZippopotamBaseUrl {
    @Test
    public void name() {
        spec.pathParams("first", "ES", "second", "01001");
        //set the expected data
        ZipopotTestData expectedPlace = new ZipopotTestData();
        List<Map<String, String>> listPlaces = expectedPlace.expectedInMethod("Vitoria-Gasteiz", "-2.6667", "Pais Vasco", "PV", "42.85");
        Map<String, Object> expectedData = expectedPlace.expectedDataMethod("01001", "Spain", "ES", listPlaces);
        //send the request get the ressponse
        Response response = given().when().spec(spec).get("/{first}/{second}");
        response.prettyPrint();
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        //Do assertion
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(expectedData.get("post code"), actualData.get("post code"));
        Assert.assertEquals(expectedData.get("country"), actualData.get("country"));
        Assert.assertEquals(expectedData.get("country abbreviation"), actualData.get("country abbreviation"));
        Assert.assertEquals(expectedData.get("places.place name"), actualData.get("places.place name"));
        Assert.assertEquals(expectedData.get("places.longitude"), actualData.get("places.longitude"));
        Assert.assertEquals(expectedData.get("places.state"), actualData.get("places.state"));
        Assert.assertEquals(expectedData.get("places.state abbreviation"), actualData.get("places.state abbreviation"));
        Assert.assertEquals(expectedData.get("places.state latitude"), actualData.get("places.latitude"));

    }
}
