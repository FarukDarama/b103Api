package homeworks;

import base_urls.GorestBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.GoRestDataPojo02;
import pojos.GoRestPojo02;
import util.ObjectMapperUtils;

import static io.restassured.RestAssured.given;

public class HomeworkCan01 extends GorestBaseUrl {
    /*
        Given
           https://gorest.co.in/public/v2/posts/174
       When
            Kullanıcı GET Methodu ile Request Gönder
        Then
             Status Code un "200" olduğunu Assert et
        And
            Response body nin bu şekilde olduğunu doğrula
 {
    "id": 174,
    "user_id": 612,
    "title": "Tertius valeo sint est vesica doloribus rerum casus cetera nisi sapiente vigor pecus voluptas asperiores et sto vapulus.",
    "body": "Et demens tergo. Cohors copia adeptio. Cotidie speciosus coaegresco. Concido crastinus degero. Tristis fugit supellex. Sustineo cogo odit. Pel patria crur. Amplus comitatus modi. Ater omnis solutio. Voluptatem acies unde. Taceo delinquo ustilo. Alo possimus vaco. Sit cognomen thesaurus. Appositus vel amicitia. Cetera textus defungo."
}

     */

    @Test
    public void name() {
        spec.pathParams("first","posts","second",174);

      Response response = given().when().spec(spec).get("/{first}/{second}");
      response.prettyPrint();
        GoRestDataPojo02 expectedData = new GoRestDataPojo02(612,"Tertius valeo sint est vesica doloribus rerum casus cetera nisi sapiente vigor" +
              " pecus voluptas asperiores et sto vapulus.","Et demens tergo. Cohors copia adeptio. Cotidie speciosus coaegresco. Concido crastinus degero. Tristis fugit supellex. Sustineo cogo odit. Pel patria crur. Amplus comitatus modi. Ater omnis solutio." +
              " Voluptatem acies unde. Taceo delinquo ustilo. Alo possimus vaco. Sit cognomen thesaurus. Appositus vel amicitia. Cetera textus defungo.");
       GoRestPojo02 actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), GoRestPojo02.class);
       System.out.println("actualData = " + actualData);
        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(expectedData.getUser_id(),actualData.getData().getUser_id());
        Assert.assertEquals(expectedData.getTitle(),actualData.getData().getTitle());
        Assert.assertEquals(expectedData.getBody(),actualData.getData().getBody());


    }
}
