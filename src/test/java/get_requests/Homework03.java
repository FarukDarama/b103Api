package get_requests;

import base_urls.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.ReqresTestData;

import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Homework03 extends ReqresBaseUrl {
//  Given
//              https://reqres.in/api/unknown/
//       When
//            I send GET Request to the URL
//       Then
//            1)Status code is 200
//            2)Print all pantone_values
//              (Tüm pantone_value değerlerini yazdırınız)
//            3)Print all ids greater than 3 on the console
//              (3'ten büyük id'leri yazdırınız)
//              Assert that there are 3 ids greater than 3
//              (3'ten büyük 3 adet id olduğunu doğrulayınız)
//            4)Print all names whose ids are less than 3 on the console
//              (id'si 3'ten küçük isimleri yazdırınız)
//              Assert that the number of names whose ids are less than 3 is 2
//              (id'si 3'ten küçük 2 isim olduğunu doğrulayınız)


    @Test
    public void homework03() {
        spec.pathParam("first","unknown");

      Response response = given().when().spec(spec).get("{first}");
        response.prettyPrint();

        Assert.assertEquals(200,response.statusCode());
        JsonPath jsonPath = response.jsonPath();
        List<String> pantone = jsonPath.getList("data.pantone_value");
        System.out.println(pantone);
       List<Integer> idList=jsonPath.getList("data.findAll{it.id>3}.id");
        System.out.println("id = " + idList);
        Assert.assertEquals(3,idList.size());
        List<String> nameList=jsonPath.getList("data.findAll{it.id<3}.name");
        System.out.println("nameList = " + nameList);
        Assert.assertEquals(2,nameList.size());

    }
     /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */

    @Test
    public void homework02() {
        spec.pathParam("first","users");
        Map<String, String> expectedData= new ReqresTestData().expectedMethod("morpheus","leader");
        Response response = given().spec(spec).body(expectedData).post("{first}");
        response.prettyPrint();
//       expectedData.put("id",response.jsonPath().getString("id"));
//       expectedData.put("createdAt",response.jsonPath().getString("createdAt"));
        Assert.assertEquals(201,response.statusCode());

        Map<String,String> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(expectedData.get("name"),actualData.get("name"));
        Assert.assertEquals(expectedData.get("job"),actualData.get("job"));

    }




}
