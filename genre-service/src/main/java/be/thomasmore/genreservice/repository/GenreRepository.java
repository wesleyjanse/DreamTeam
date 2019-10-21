package be.thomasmore.genreservice.repository;

import java.util.List;

import be.thomasmore.genreservice.entity.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface GenreRepository extends MongoRepository<Genre, String> {
    List<Genre> findGenreByUserId(@Param("userid") Integer userid);
    List<Genre> findRatingsByMovieId(@Param("movieid") Integer movieId);
    Genre findGenreByUserIdAndMovieId(@Param("userid") Integer userid,@Param("movieid") Integer movieId);
}
