package patch_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.RealSystem;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Patch01 extends JsonPlaceHolderBaseUrl {
    /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "title": "Wash the dishes"
               }
        When
	 		I send PATCH Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 10,
									    "title": "Wash the dishes",
									    "completed": true,
									    "id": 198
									    }
     */

    @Test
    public void patch01() {
        //set the url
        spec.pathParams("first","todos","second",198);
        //set the expected data
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
        Map<String,Object> expectedData =  obj.expectedData(null,"Wash the dishes",null);
        System.out.println("expectedData = " + expectedData);
        //send the request ....
       Response response=given().spec(spec).body(expectedData).patch("/{first}/{second}");
       response.prettyPrint();
     // Do
      Map<String,Object> actualData =  response.as(HashMap.class);
        System.out.println("actualData = " + actualData);
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("title"),actualData.get("title"));
        //Eğer tüm body assert edilecekse:
        assertEquals(10, actualData.get("userId"));
        assertEquals(true, actualData.get("completed"));


    }
}
