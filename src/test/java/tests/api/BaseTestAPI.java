package tests.api;

import io.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tests.BaseTest;
import java.util.Random;

public class BaseTestAPI {
    static Logger logger = LoggerFactory.getLogger(BaseTest.class);
    Random random = new Random();
    public static final String ENDPOINT_REGISTER = "/register";
    public static final String ENDPOINT_EMAILCONFIRMATION = "/api/confirm-email";
    public static final String ENDPOINT_LOGIN = "/auth/login";
    public static final String ENDPOINT_LOGOUT = "/auth/logout";
    public static final String ENDPOINT_CHANGEPASSWORD = "/auth/profile/change-password";
    public static final String ENDPOINT_DELETE = "/api/account/{id}"; // + id
    public static final String ENDPOINT_GETUSERDATA = "/auth/profile";
    public static final String ENDPOINT_POTNEW = "/api/pots";
    public static final String ENDPOINT_POTACTIVATE = "/api/pots/{id}/activation"; // +id
    public static final String ENDPOINT_POTDELETE = "/api/pots/{id}"; // +id
    protected String accessToken = "";
    protected int userId;
    public static final String TOKEN_LEAF = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJMZWFmR3Jvd1VzZXJAZ21haWwuY29tIiwiZXhwIjoxNzIxNDgzOTI4LCJyb2xlcyI6W3siaWQiOjIsInRpdGxlIjoiUk9MRV9VU0VSIiwiYXV0aG9yaXR5IjoiUk9MRV9VU0VSIn1dLCJuYW1lIjoiTGVhZiJ9.oxc5KR9h4DEQ754y8B85DWWrqlWH-OQuNfA3EfPRrmE";

    static {
        RestAssured.baseURI = "https://leafgrow-app-foign.ondigitalocean.app/api";
    }
    public String newUserNameForRegistration() {
        return "John" + String.valueOf(random.nextInt(1000));
    }

    public String newUserEmailForRegistration() {
        return "test" + String.valueOf(random.nextInt(100000)) + "@mail.com";
    }
}
