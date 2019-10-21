package be.thomasmore.ratingservice.repository;


import be.thomasmore.ratingservice.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {
    List<Rating> findRatingsByUserId(@Param("userid") Integer userid);
    List<Rating> findRatingsByMovieId(@Param("movieid") Integer movieId);
    Rating findRatingByUserIdAndMovieId(@Param("userid") Integer userid,@Param("movieid") Integer movieId);
}
