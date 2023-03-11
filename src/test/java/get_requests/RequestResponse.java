package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class RequestResponse {
    /*
    1) Postman manuel API testi için kullanılır.
    2) API otomasyonu için Rest-Assured Library
    3) Otomasyon kodlarının yazımı için şu adımları izliyoruz:
        a) Gereksinimleri anlama
        b) Test case'i yazma:
            -Test case'i yazmak için "Gherkin Language" kullanıyoruz.
            x) Given: Ön koşullar --> Endpoint, body
            y) When: İşlemler--> Get, Put, Delete ...
            z) Then: Dönütler--> Assert
            t) And: Çoklu işlemlerin art arda yazılacağı yerlerde kullanılır.
        c) Test kodunu yazarken şu adımları izleriz:
            i)   Set the URL
            ii)  Set the expected data
            iii) Send the request and get the response
            iv)  Do assertion

     */

    public static void main(String[] args) {

        //Get request nasıl yapılır:
        String url="https://restful-booker.herokuapp.com/booking/55";
        Response response = given().when().get(url);

        response.prettyPrint();//prettyPrint() methodu response datayı yazdırır.
        //Status Code nasil yazdirilir?
       int statusCode = response.statusCode();
        System.out.println(statusCode);
        //contentType nasıl yazdirilir
       String contenType= response.contentType();
        System.out.println("contenType = " + contenType);
        //statusLine nasıl yazdırılır
       String statusLine= response.statusLine();
        System.out.println("statusLine = " + statusLine);
        //Header nasıl yazdırılır
        System.out.println(response.header("Connection"));
        System.out.println(response.header("Server"));
       //Headers nasıl yazdırılır
        System.out.println(response.getHeaders());
        //Time nasil yazdirilir
        System.out.println(response.time());

    }
}