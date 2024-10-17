package test.java.demoqa.apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.demoqa.BaseTest;

public class UserRegistrationTest extends BaseTest {

    @Test
    public void RegistrationSuccessful() {
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        Response response = request.body("{" +
                "  \"password\" : \"Test@@1231yy\"," +
                "  \"userName\" : \"TOOLSQA-Test1yy\"" +
                "}").post("/Account/v1/User");

        Assert.assertEquals(response.getStatusCode(), 201);
        // We will need the userID in the response body for our tests, please save it in a local variable
        String userID = response.getBody().jsonPath().getString("userID");
    }
}
