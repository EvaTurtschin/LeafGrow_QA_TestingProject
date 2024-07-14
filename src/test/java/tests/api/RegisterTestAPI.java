package tests.api;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class RegisterTestAPI extends BaseTestAPI {

    @Test(description = "assert status code 200 for positive registration")
    public void positiveTestRegisterEndpoint() {
        String name = newUserNameForRegistration();
        String email = newUserEmailForRegistration();
        String requestBody =
                "{\"username\":\"" + name + "\",\"email\":\"" + email +"\",\"password\":\"Sss12345\"}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(ENDPOINT_REGISTER)
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("Response: {}", response.asString());

        userId = response.path("id");
    }
}
