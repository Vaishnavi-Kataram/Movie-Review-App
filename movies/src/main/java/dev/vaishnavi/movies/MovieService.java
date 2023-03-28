package dev.vaishnavi.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired // we want the framework to instantiate the class MovieRepository for us
    private MovieRepository movieRepository; // this is a reference to MovieRepository class, it has to be initialized using a constructor or Autowired annotation
    public List<Movie> allMovies(){ // to get the list of all movies
        return movieRepository.findAll(); // findAll() method is written inside MongoRepository class to return list of all movies
    }

    public Optional<Movie> singleMovie(String imdbId){ // this method finds a particular movie using the function findMovieById(id) from the Repository
        // the return type is Optional<Movie> - says that a movie with the given id may or may not exist in the database, the result may be null
        return movieRepository.findMovieByImdbID(imdbId); // call the method in Repository
    }
}

