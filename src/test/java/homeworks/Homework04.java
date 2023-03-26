package homeworks;

import base_urls.AutomationexerciseBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Homework04 extends AutomationexerciseBaseUrl {

    //Given
    //		https://automationexercise.com/api/productsList
    //	When
    //		User sends Get request
    //	Then
    //		Assert that number of "Women" usertype is 12
    //		(Kadın usertype sayısının 12 olduğunu doğrulayın)
    @Test
    public void name() {
        spec.pathParam("first","productsList");
     Response response= given().when().spec(spec).get("{first}");
      response.jsonPath().prettyPrint();
        System.out.println(response.jsonPath().getList("products.category.usertype.findAll{it.usertype=='Women'}").size());
        assert response.jsonPath().getList("products.category.usertype.findAll{it.usertype=='Women'}").size() == 12;


    }
}
