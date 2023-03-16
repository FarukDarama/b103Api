package get_requests;

import base_urls.HerOkuAppBaseUrl;
import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.reset;
import static org.junit.Assert.assertEquals;

public class Homework02 extends ReqresBaseUrl {
     /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Almedin&lastname=Alikadic
        When
            User sends get request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Almedin" and lastname is "Alikadic"

     */

    @Test
    public void get01() {
        spec.pathParam("first","booking").queryParams("firstname","Almedin","lastname","Alikadic");
        Response response = given().when().spec(spec).get("/{first}");
        response.prettyPrint();
        response.then().statusCode(200);
       JsonPath jsonPath= response.jsonPath();
        assertEquals("Almedin",jsonPath.getString("firstname"));
        assertEquals("Alikadic",jsonPath.getString("lastname"));
    }

          /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json; charset=utf-8"
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */

    @Test
    public void get02() {

        spec.pathParams("ilk","unknown","iki",3);
        Response response = given().when().spec(spec).get("/{ilk}/{iki}");
        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        response.then().statusCode(200).contentType(ContentType.JSON);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(jsonPath.getInt("data.id"),3);
        softAssert.assertEquals(jsonPath.getString("data.name"),"true red");
        softAssert.assertEquals(jsonPath.getInt("data.year"),2002);
        softAssert.assertEquals(jsonPath.getString("data.color"),"#BF1932");
        softAssert.assertEquals(jsonPath.getString("data.pantone_value"),"19-1664");
        softAssert.assertEquals(jsonPath.getString("support.url"),"https://reqres.in/#support-heading");
        softAssert.assertEquals(jsonPath.getString("support.text"),"To keep ReqRes free, contributions towards server costs are appreciated!");
        softAssert.assertAll();
    }
}
