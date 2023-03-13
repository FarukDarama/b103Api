package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class Get03 {

    /*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
      And
          Response format should be “application/json”
      And
          “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
      And
          “completed” is false
      And
          “userId” is 2
     */

    @Test
    public void get03() {
        //set the URL
        String url = "https://jsonplaceholder.typicode.com/todos/23";

        //Set the expected data

        //Send the request and get the response
        Response response = given().when().get(url);
        response.prettyPrint();

        //Do Assertion
        //1. Yol:
        response.
                then().
                statusCode(200).
                contentType("application/json").
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).//“title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
                body("completed", equalTo(false)).//"completed": false
                body("userId", equalTo(2));//"userId": 2
        //Tek body() method'u icerisinde coklu assertion yaparak soft assertion olusturabilirsiniz.
        //Fail durumunda body() Java calismayi durdurmaz
        //Coklu body() method'u ile asserion yapildiginda fail durumunda Java birsonraki body() method'u oncesi calismayi durdurur


        //2. Yol:
        response.
                then().
                statusCode(200).
                contentType("application/json").
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed", equalTo(false),
                        "userId", equalTo(2));



    }


}