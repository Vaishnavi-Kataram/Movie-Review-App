package dev.vaishnavi.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
@Data // to get all the getters and setters
@AllArgsConstructor // to create a constructor that takes all the below private fields as arguments
@NoArgsConstructor // constructor that takes no parameters
public class Review {
    // ids are autogenerated, cannot pass id to this class
    @Id
    private ObjectId id;
    private String body;

    public Review(String body) { // custom constructor takes only the body
        this.body = body;
    }
}
