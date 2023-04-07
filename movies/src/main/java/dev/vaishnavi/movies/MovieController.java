package dev.vaishnavi.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController // this is our first official rest API controller
@RequestMapping("/api/v1/movies") // instead of mapping to localhost:8080, map it to localhost:8080/api/v1/movies
public class MovieController {
    @Autowired // we want the framework to instantiate the class MovieService for us
    private MovieService movieService;
    @GetMapping("/")
    public ResponseEntity<List<Movie>> getAllMovies(){
        // returns a response entity of type List<Movie>
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
        // on cmd: curl -i http://localhost:8080/api/v1/movies -> it returns the 200 response code
        // -> this comes in handy when working on a frontend application and any restAPI out there should return proper status codes.
    }

    @GetMapping("/{imdbId}") // to get the request from the user at localhost....(particular movie imdbId)
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        // @PathVariable lets the framework know that we be passing the information we get in the mapping as a path variable and will be converted into String called imdbId
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }
}
