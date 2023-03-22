package homeworks;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class Homework01 extends ReqresBaseUrl {

   /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

    @Test
    public void homework01() {
    // set the URL
     spec.pathParam("id","3");

    //Set expected data

    //Send the request get the Response
        Response response = given().when().spec(spec).get("/{id}");
        response.prettyPrint();
    //Do Assertion
        response.then().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");

    }

    /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */

    @Test
    public void homework02() {
        // set the URL
        spec.pathParam("id","23");

        //Set expected data

        //Send the request get the Response
        Response response = given().when().spec(spec).get("/{id}");
        response.prettyPrint();
        //Do Assertion
        assertEquals(404, response.statusCode());
        assertEquals("HTTP/1.1 404 Not Found", response.statusLine());
        assertEquals("cloudflare", response.getHeader("Server"));
        assertEquals(2, response.asString().replaceAll("\\s","").length());//2,{} cift
    }

    /*
       Given
           https://reqres.in/api/users/2
       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be “application/json”
       And
           “email” is “janet.weaver@reqres.in”,
       And
           “first_name” is "Janet"
       And
           “last_name” is "Weaver"
       And
           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
    */

    @Test
    public void homework03() {
        spec.pathParam("id","2");
        Response response= given().when().spec(spec).get("/{id}");
        response.prettyPrint();

        response.then().statusCode(200).
                contentType(ContentType.JSON).body("data.email",equalTo("janet.weaver@reqres.in"),"data.first_name",equalTo("Janet"),
                        "data.last_name",equalTo("Weaver"),"support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

    }
}
