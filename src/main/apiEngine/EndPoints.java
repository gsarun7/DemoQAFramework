package main.apiEngine;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import main.apiEngine.requests.AddBooksRequest;
import main.apiEngine.requests.AuthorizationRequest;
import main.apiEngine.requests.RemoveBookRequest;

public class EndPoints {

    public static final String BASE_URL = "https://bookstore.toolsqa.com";

    public static Response authenticateUser(AuthorizationRequest authRequest) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        return request.body(authRequest).post("/Account/v1/GenerateToken");
    }
    public static Response getBooks() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        return request.get("/BookStore/v1/Books");
    }

    public static Response addBook(AddBooksRequest addBooksRequest, String token) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        return request.body(addBooksRequest).post("/BookStore/v1/Books");
    }

    public static Response removeBook(RemoveBookRequest removeBookRequest, String token) {

        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        return request.body(removeBookRequest).delete("/BookStore/v1/Book");
    }

    public static Response getUserAccount(String userId, String token) {

        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        return request.get("/Account/v1/User/" + userId);
    }


}
