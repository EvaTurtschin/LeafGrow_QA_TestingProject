package tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class APITest {

    static Logger logger = LoggerFactory.getLogger(BaseTest.class);
    static {
        RestAssured.baseURI = "https://leafgrow-app-foign.ondigitalocean.app/api";
    }

    @Test
    public void testPostEndpoint() {
        String requestBody =
                "{\"username\":\"Manny\",\"email\":\"test5603434679@mail.com\",\"password\":\"Sss12345\"}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/register")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("Response: {}", response.asString());
    }

//TODO
//    @Test
//    public void testGetWithParams() {
//        Response response = given()
//                .param("userId", 1)
//                .when()
//                .get("/posts")
//                .then()
//                .statusCode(200)
//                .extract().response();
//
//        Assert.assertEquals(response.getStatusCode(), 200);
//        System.out.println(response.getBody().asString());
//    }
//
//    @Test
//    public void testGetEndpoint() {
//        Response response = when().get("/auth/profile")
//                .then()
//                .statusCode(200)
//                .extract().response();
//
//        Assert.assertEquals(response.getStatusCode(), 200);
//        // Добавьте дополнительные проверки на основе структуры ответа
//    }
}
