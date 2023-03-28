package dev.vaishnavi.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // to let the framework know that this is a repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> { // to let the repository know what type of data and Id we are dealing with.
    Optional<Movie> findMovieByImdbID(String imdbId); // method to find the movie with the given imdbId from the database
    // dynamic queries can be formed using any property name in your model class as long as they are unique, because if it's not
    // unique, we will get the multiple movies with the same Id or same name.

}
