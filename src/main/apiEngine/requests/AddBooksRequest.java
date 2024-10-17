package main.apiEngine.requests;

import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class AddBooksRequest {

    public String userId;
    public List<ISBN> collectionOfIsbns;

    /**
     * No args constructor for use in serialization
     *
     */
    public AddBooksRequest() {
    }

    public AddBooksRequest(String userId, List<ISBN> collectionOfIsbns) {
        super();
        this.userId = userId;
        this.collectionOfIsbns = collectionOfIsbns;
    }

}