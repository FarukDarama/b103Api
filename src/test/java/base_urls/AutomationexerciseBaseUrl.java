package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class AutomationexerciseBaseUrl {

    protected RequestSpecification spec ;

    @Before//Her test methodunda once calısır .

    public void  setUp(){

        spec =new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri("https://automationexercise.com/api").build();
    }



}
