package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Get07 extends JsonPlaceHolderBaseUrl {
/*
        Given
              https://jsonplaceholder.typicode.com/todos
      When
          I send GET Request to the URL == > URL'e Get Request gonderin
      Then
          1)Status code is 200 == > Status kodu 200 olmali
          2)Print all ids greater than 190 on the console ==> id si 190 dan buyuk olanlari konsola yazdirin
            Assert that there are 10 ids greater than 190 == > 10 tane id nin 190 dan buyuk oldugunu dogrulayin
          3)Print all userIds whose ids are less than 5 on the console ==> id si 5 den kucuk olan tum userid lerini konsolunu yazdirin
            Assert that the number of userIds whose ids are less than 5 is 4 ==> id si 5 den kucuk olan 4 tane userId oldugunu dogrulayin
          4)Print all titles whose ids are less than 5 ==> ıd si 5 den kucuk olan tum basliklari yazdirin
            Assert that "delectus aut autem" is one of the titles whose id is less than 5 ==> id si 5 den kucuk olan datalarin birinin
            basliginin "delectus aut autem" icerdigini dogrulayin
     */

    @Test
    public void get07() {
        //set the     URL
        spec.pathParam("first", "todos");

        //set the expected data

        //set the request and get the response

        Response response = given().spec(spec).get("/{first}");
        response.prettyPrint();

        //Do Assertion
        Assert.assertEquals(200, response.statusCode());
        //2)Print all ids greater than 190 on the console ==> id si 190 dan buyuk olanlari konsola yazdirin
        JsonPath jsonPath = response.jsonPath();//body nın içindeki bilgilere tek tek ulasabilmek için
        List<Object> list = jsonPath.getList("findAll{it.id>190}.userId");//Groovy java temelli bir programala dilidir
        System.out.println("list = " + list);
        Assert.assertEquals(10, list.size());
        //3)Print all userIds whose ids are less than 5 on the console ==> id si 5 den kucuk olan tum userid lerini konsolunu yazdirin
        // Assert that the number of userIds whose ids are less than 5 is 4 ==> id si 5 den kucuk olan 4 tane userId oldugunu dogrulayin
        List<Integer> userIdList = jsonPath.getList("findAll{it.id<5 || it.userId==9}.userId");
        System.out.println("userIdList = " + userIdList);
        //4)Print all titles whose ids are less than 5 ==> ıd si 5 den kucuk olan tum basliklari yazdirin
        List<String> titleList = jsonPath.getList("findAll{it.id<5}.title");
        System.out.println("titleList = " + titleList);
        //Assert that "delectus aut autem" is one of the titles whose id is less than 5 ==> id si 5 den kucuk olan datalarin birinin
        //basliginin "delectus aut autem" icerdigini dogrulayin
        Assert.assertTrue(titleList.contains("delectus aut autem"));
    }
}
