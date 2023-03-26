package delete_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.DummyRestApiDeleteBodyPojo;
import pojos.DummyRestApiResponseBodyPojo;
import util.ObjectMapperUtils;

import static io.restassured.RestAssured.given;

public class Delete02 extends DummyRestApiBaseUrl {
/*      Given
            URL: https://dummy.restapiexample.com/api/v1/delete/2
        When
            HTTP Request Method: DELETE Request
      
        Then
            Assert:     i) Status code is 200
        And    
            ii) "status" is "success"
            iii) "data" is "2"
            iv) "message" is "Successfully! Record has been deleted"

  */

    @Test
    public void name() {
        spec.pathParams("first", "delete", "second", 2);

        DummyRestApiDeleteBodyPojo expectedData=   new DummyRestApiDeleteBodyPojo("success","2","Successfully! Record has been deleted");
        System.out.println("expectedData = " + expectedData);
        Response response = given().when().spec(spec).delete("/{first}/{second}");
        response.prettyPrint();

        DummyRestApiDeleteBodyPojo actualData =   ObjectMapperUtils.convertJsonToJava(response.asString(),DummyRestApiDeleteBodyPojo.class);
        System.out.println("actualData = " + actualData);

        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(expectedData.getStatus(),actualData.getStatus());
        Assert.assertEquals(expectedData.getData(),actualData.getData());
        Assert.assertEquals(expectedData.getMessage(),actualData.getMessage());






    }
}
