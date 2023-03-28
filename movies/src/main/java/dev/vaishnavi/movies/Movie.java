package dev.vaishnavi.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data // to get all the getters and setters
@AllArgsConstructor // to create a constructor that takes all the below private fields as arguments
@NoArgsConstructor // constructor that takes no parameters
public class Movie {
    @Id
    private ObjectId id; // unique id for each movie in database
    private String imdbID;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference // to create manual reference in MongoDB, reviewId stores the id of the review stored in the review database, one to many relation
    private List<Review> reviewIds;

}
