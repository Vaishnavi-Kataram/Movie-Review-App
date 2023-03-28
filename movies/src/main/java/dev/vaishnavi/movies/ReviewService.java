package dev.vaishnavi.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service // to tell the compiler its a service class
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository; // instance of ReviewRepository

    // we need a template to associate a review to a movie
    // Repository is one of the ways of talking to the DB, the other way is a template
    // operations can be complex to implement within a repository or may not be suitable, so we need a Template
    // template can be used to form up a new dynamic query and do the job inside the DB without using the repository.
    @Autowired
    private MongoTemplate mongoTemplate;
    public Review createReview(String reviewBody, String imdbId){
        // this method looks for movie with the given imdbId, creates new review, associate that reviewBody with the found movie
        Review review= reviewRepository.insert(new Review(reviewBody)); // inserts the review object to the DB
        // save the review on insert, because when we call insert it actually returns the data that we just pushed inside the DB

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbID").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first(); // .first() is to make sure we are getting a single movie and we are updating that
        // mongoTemplate updates the movie in the Movie class, where the imdbID matches the imdbID received from the user, then we apply this update
        // we create a new update definition which does the job of making the change inside the database, push reviewIds says we want ot update the reviewIds array in the found movie in the DB
        // the value of the movie will be revealed, the new review will be pushed inside the reviewIds array.

        return review;
    }
}
