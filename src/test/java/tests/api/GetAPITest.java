package tests.api;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class GetAPITest extends BaseTestAPI{

    @Test
    public void testGetWithParams() {
        Response response = given()
                .param("userId", 1)
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println(response.getBody().asString());
    }

    @Test
    public void testGetEndpoint() {
        Response response = when().get("/auth/profile")
                .then()
                .statusCode(200)
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
