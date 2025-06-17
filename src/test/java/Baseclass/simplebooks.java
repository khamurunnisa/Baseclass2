package Baseclass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class simplebooks {
    public static Response GetRequest(String requesturl,String bearer_token)
    {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("Authorization","Bearer "+ bearer_token);
        Response response = requestSpecification.get(requesturl);
        return response;
    }

    public static Response PostRequest(String requesturl,String requestpayLoad,String bearer_token)
    {
        RequestSpecification requestSpecification = RestAssured.given().body(requestpayLoad);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("Authorization","Bearer "+ bearer_token);
        Response resposne = requestSpecification.post(requesturl);
        return resposne;
    }

    public static Response PostRequest(String requesturl,String bearer_token)
    {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("Authorization","Bearer "+ bearer_token);
        Response resposne = requestSpecification.post(requesturl);
        return resposne;
    }
    public static Response PatchRequest(String requesturl,String requestpayLoad,String bearer_token)
    {
        RequestSpecification requestSpecification = RestAssured.given().body(requestpayLoad);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("Authorization","Bearer "+ bearer_token);
        Response resposne = requestSpecification.patch(requesturl);
        return resposne;
    }

    public static Response PutRequest(String requesturl,String requestpayLoad,String bearer_token)
    {
        RequestSpecification requestSpecification = RestAssured.given().body(requestpayLoad);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("Authorization","Bearer "+ bearer_token);
        Response resposne = requestSpecification.put(requesturl);
        return resposne;
    }

    public static Response DeleteRequest(String requesturl,String bearer_token)
    {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("Authorization","Bearer "+ bearer_token);
        Response resposne = requestSpecification.delete(requesturl);
        return resposne;

    }
}
