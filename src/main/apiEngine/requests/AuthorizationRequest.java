package main.apiEngine.requests;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class AuthorizationRequest {

    public String userName;
    public String password;

    /**
     * No args constructor for use in serialization
     *
     */
    public AuthorizationRequest() {
    }

    public AuthorizationRequest(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }

}