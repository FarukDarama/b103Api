package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import util.ObjectMapperUtils;

import static io.restassured.RestAssured.given;

public class Get14ObjectMapper_Pojo extends JsonPlaceHolderBaseUrl {
    /*
        Given
	        https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send GET Request to the URL
	 	Then
	 		Status code is 200
	 		And response body is like {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }
     */

    @Test
    public void get14() {
        //Set the url
        spec.pathParams("first","todos","second",198);
        //set expected data
        JsonPlaceHolderPojo expectedData = new JsonPlaceHolderPojo(10,"quis eius est sint explicabo",true);
        System.out.println("expectedData = " + expectedData);
        // Send the req get res
       Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //Do assertion
        JsonPlaceHolderPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), JsonPlaceHolderPojo.class);
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(expectedData.getUserId(),actualData.getUserId());
        Assert.assertEquals(expectedData.getTitle(),actualData.getTitle());
        Assert.assertEquals(expectedData.getCompleted(),actualData.getCompleted());

    }
}
