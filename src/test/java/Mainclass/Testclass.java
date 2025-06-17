package Mainclass;

import java.io.IOException;

import Baseclass.simplebooks;
import classes.Authentication;
import classes.Commoners;
import classes.CreateUrl;
import classes.PayLoadconverter;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;

public class Testclass extends simplebooks {


    //private static Object Authentication;
    public static String bearer_token = Authentication.getbearertoken();
    public static Response response;
    public static String id;

    @Test(priority = 1)
    public void authentication() throws IOException {
        String endpoint = CreateUrl.getbaseuri("/api-clients/");
        String request_payload = PayLoadconverter.generatepayload("\\Authentication.json");

        response = simplebooks.PostRequest(endpoint, request_payload, bearer_token);
        String responseBody = response.getBody().asString();

        Assert.assertEquals(Commoners.getResponsevalue(request_payload, "Postman"), Commoners.getResponsevalue(responseBody, "Postman"));
        Assert.assertEquals(Commoners.getstatuscode(response), 201);

        System.out.println("Request Payload:\n" + request_payload);
        System.out.println("Response Body:\n" + responseBody);

      //  String token = response.jsonPath().getString("accessToken");
      //  System.out.println("Access Token: " + token);
    }

    @Test(priority = 2)
    public void submitOrder() throws IOException {
        String endpoint = CreateUrl.getbaseuri("/orders");
        String request_payload = PayLoadconverter.generatepayload("\\SubmitOrder.json");

        response = simplebooks.PostRequest(endpoint, request_payload, bearer_token);
        String responseBody = response.getBody().asString();

        Assert.assertEquals(Commoners.getResponsevalue(request_payload, "Jhon"), Commoners.getResponsevalue(responseBody, "Jhon"));
        Assert.assertEquals(Commoners.getstatuscode(response), 201);

        id = response.jsonPath().getString("orderId");

       // System.out.println("Submit Order Response:\n" + responseBody);
        System.out.println("Order ID: " + id);
    }

    @Test(priority = 3)
    public void getOrder() throws IOException {
        String endpoint = CreateUrl.getbaseuri("/orders/"+id);
        response = simplebooks.GetRequest(endpoint, bearer_token);

        Assert.assertEquals(Commoners.getstatuscode(response), 200);
        System.out.println("Get Orders Response:\n" + response.getBody().asString());
    }

    @Test(priority = 4)
    public void updateOrder() throws IOException {
        String endpoint = CreateUrl.getbaseuri("/orders/" + id);
        String request_payload = PayLoadconverter.generatepayload("\\UpdateOrder.json");

        response = simplebooks.PatchRequest(endpoint,request_payload,bearer_token);
        String responseBody = response.getBody().asString();

      // Assert.assertEquals(Commoners.getResponsevalue(request_payload, "sree"), Commoners.getResponsevalue(responseBody, "sree"));
        Assert.assertEquals(Commoners.getstatuscode(response), 204);

       // System.out.println("Update Order Response:\n" + responseBody);
    }

    @Test(priority = 5)
    public void getOrderAfterUpdate() throws IOException {
        String endpoint = CreateUrl.getbaseuri("/orders/"+id);
        response = simplebooks.GetRequest(endpoint,bearer_token);
        Assert.assertEquals(Commoners.getstatuscode(response), 200);
        System.out.println("Get Orders After Update Response:\n" + response.getBody().asString());
    }

    @Test(priority = 6)
    public void deleteOrder() throws IOException {
        String endpoint = CreateUrl.getbaseuri("/orders/" + id);
        response = simplebooks.DeleteRequest(endpoint,bearer_token); // Corrected from getRequest to deleteRequest

        Assert.assertEquals(Commoners.getstatuscode(response), 204);
        System.out.println("Delete Order Status Code: " + response.getStatusCode());
    }


}
