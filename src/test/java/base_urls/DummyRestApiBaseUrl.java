package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyRestApiBaseUrl {
    protected RequestSpecification spec ;

    @Before//Her test methodunda once calısır .

    public void  setUp(){

        spec =new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri("https://dummy.restapiexample.com/api/v1").build();
    }

}
