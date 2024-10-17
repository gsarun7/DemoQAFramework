package test.java.demoqa.apiTests;

import io.restassured.response.Response;
import main.apiEngine.EndPoints;
import main.apiEngine.requests.AddBooksRequest;
import main.apiEngine.requests.AuthorizationRequest;
import main.apiEngine.requests.ISBN;
import main.apiEngine.requests.RemoveBookRequest;
import main.apiEngine.model.Book;
import main.apiEngine.responses.Books;
import main.apiEngine.responses.Token;
import main.apiEngine.responses.UserAccount;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.demoqa.BaseTest;

import java.util.*;

public class BookApiTests extends BaseTest {
    final String userID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
    Response response;
    static Token tokenResponse;
    static Book book;

    //Test will start from generating Token for Authorization
    @Test
    public void validateAuthorizedUserByGeneratingToken() {
        AuthorizationRequest authRequest = new AuthorizationRequest( dataReaderApi.getProperty("userapi"), dataReaderApi.getProperty("pwdapi"));
        response = EndPoints.authenticateUser(authRequest);
        tokenResponse = response.getBody().as(Token.class);
        //This token will be used in later requests
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    // Get Books - No Auth is required for this.
    @Test
    public void validateListOfBooksAreAvailable() {
        response = EndPoints.getBooks();
        Books books = response.getBody().as(Books.class);
        book = books.books.get(0);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertFalse(books.books.isEmpty());
    }

    //Add a book - with Auth
    //The token we had saved in the variable before from response in Step 1,
    //we will be passing in the headers for each of the succeeding request
    @Test(dependsOnMethods = {"validateListOfBooksAreAvailable","validateAuthorizedUserByGeneratingToken"})
    public void validateAddBookWithAuth() {
        ISBN isbn = new ISBN(book.isbn);
        List<ISBN> listISBN = new ArrayList<>();
        listISBN.add(isbn);
        AddBooksRequest addBooksRequest = new AddBooksRequest(userID, listISBN);
        response = EndPoints.addBook(addBooksRequest, tokenResponse.token);
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    // Delete a book - with Auth
    @Test(dependsOnMethods = {"validateListOfBooksAreAvailable","validateAuthorizedUserByGeneratingToken"})
    public void validateDeleteBookWithAuth() {
        RemoveBookRequest removeBookRequest = new RemoveBookRequest(userID, book.isbn);
        response = EndPoints.removeBook(removeBookRequest, tokenResponse.token);
        Assert.assertEquals(response.getStatusCode(), 204);
    }

    // Get User
    @Test(dependsOnMethods = {"validateAuthorizedUserByGeneratingToken"})
    public void validateBookIsRemovedForUser() {
        response = EndPoints.getUserAccount(userID, tokenResponse.token);
        Assert.assertEquals(response.getStatusCode(), 200);
        UserAccount userAccount = response.getBody().as(UserAccount.class);
        Assert.assertEquals(userAccount.books.size(), 0);
    }
}
