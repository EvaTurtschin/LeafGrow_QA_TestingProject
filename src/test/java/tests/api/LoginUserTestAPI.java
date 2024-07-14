package tests.api;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.PositiveTestUserData;


import static io.restassured.RestAssured.given;

public class LoginUserTestAPI extends BaseTestAPI {

    @Test(description = "assert status code 200 for positive login")
    public void loginUser() {
        String userLeaf = "{\"email\":\"" + PositiveTestUserData.EMAIL + "\",\"password\":\"" + PositiveTestUserData.PASSWORD + "\"}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userLeaf)
                .when()
                .post(ENDPOINT_LOGIN)
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("Response: {}", response.asString());

        accessToken = response.path("accessToken");

    }

}
