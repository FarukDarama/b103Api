package homeworks;

import base_urls.Covid19BaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.Covid19TestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class HomeworkCan03 extends Covid19BaseUrl {
    /*
      Given
           https://api.covid19api.com/world/total
       When
            Kullanıcı GET Methodu ile Request Gönder
        Then
             Status Code un "200" olduğunu Assert et
        And
            Response body nin bu şekilde olduğunu doğrula
 {
    "TotalConfirmed": 674300771,
    "TotalDeaths": 6793224,
    "TotalRecovered": 0
}
     */

    @Test
    public void name() {
        //set the url
        spec.pathParams("first", "world", "second", "total");
        //set the expected data
        Covid19TestData obj = new Covid19TestData();
        Map<String, Integer> expectedData =  obj.expectedDataMethod(674300771,6793224,0);
        System.out.println("expectedData = " + expectedData);

        //sen request get the response
        Response response = given().when().spec(spec).get("/{first}/{second}");
        response.prettyPrint();
       Map<String,Integer> actualData =response.as(HashMap.class);
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(expectedData.get("TotalDeaths"),actualData.get("TotalDeaths"));
        Assert.assertEquals(expectedData.get("TotalConfirmed"),actualData.get("TotalConfirmed"));
        Assert.assertEquals(expectedData.get("TotalRecovered"),actualData.get("TotalRecovered"));

    }
}
