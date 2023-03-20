package post_requests;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PetStorePojo;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

public class Homework01 extends PetStoreBaseUrl {

    @Test
    public void homework01() {
/*
 Given
            1) https://petstore.swagger.io/

            2){
  "id": 35,
  "username": "Pati Lisa",
  "firstName": "Kubra",
  "lastName": "Tanribuyurdu",
  "email": "abc@gmail.com",
  "password": "12345",
  "phone": "123454321",
  "userStatus": 0
}

 When
            I send POST Request to the Url
        Then
            Status code is 201
             And response body should be like {
                                                "code": 200,
                                                "type": "unknown",
                                              //  "message": "message"
                                              }*/

   spec.pathParam("first","user");
   PetStorePojo obj = new PetStorePojo("Pati Lisa","Kubra","Tanribuyurdu","abc@gmail.com","12345","123454321",0);

     Response response = given().spec(spec).body(obj).post("{first}");
     response.prettyPrint();


       Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals("200",response.jsonPath().getString("code"));
        Assert.assertEquals("unknown",response.jsonPath().getString("type"));
      //  Assert.assertEquals("9223372036854748609",response.jsonPath().getString("message"));


    }

    @Test
    public void homework02() {
        spec.pathParams("first","user","second","Pati Lisa");
      Response response = given().spec(spec).get("/{first}/{second}");
      response.prettyPrint();
      PetStorePojo expectedData = new PetStorePojo("Pati Lisa","Kubra","Tanribuyurdu","abc@gmail.com","12345","123454321",0);
        System.out.println("expectedData = " + expectedData);

       PetStorePojo actualData= response.as(PetStorePojo.class);
       Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(expectedData.getEmail(),actualData.getEmail());
        Assert.assertEquals(expectedData.getFirstName(),actualData.getFirstName());
        Assert.assertEquals(expectedData.getUsername(),actualData.getUsername());
        Assert.assertEquals(expectedData.getLastName(),actualData.getLastName());
        Assert.assertEquals(expectedData.getPassword(),actualData.getPassword());
        Assert.assertEquals(expectedData.getPhone(),actualData.getPhone());
        Assert.assertEquals(expectedData.getUserStatus(),actualData.getUserStatus());





    }
}
