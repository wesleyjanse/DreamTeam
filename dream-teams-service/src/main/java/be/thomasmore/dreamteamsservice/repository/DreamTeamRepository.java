package be.thomasmore.dreamteamsservice.repository;

import be.thomasmore.dreamteamsservice.entity.DreamTeam;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DreamTeamRepository extends MongoRepository<DreamTeam, String> {
//    List<DreamTeam> findRatingsByUserId(@Param("userid") Integer userid);
//    List<DreamTeam> findRatingsByMovieId(@Param("movieid") Integer movieId);
//    DreamTeam findRatingByUserIdAndMovieId(@Param("userid") Integer userid,@Param("movieid") Integer movieId);
}