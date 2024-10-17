package main.apiEngine.requests;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class RemoveBookRequest {

    public String isbn;
    public String userId;

    /**
     * No args constructor for use in serialization
     *
     */
    public RemoveBookRequest() {
    }

    public RemoveBookRequest(String isbn, String userId) {
        super();
        this.isbn = isbn;
        this.userId = userId;
    }

}