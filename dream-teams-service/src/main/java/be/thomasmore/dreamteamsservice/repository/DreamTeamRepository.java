package be.thomasmore.dreamteamsservice.repository;

import be.thomasmore.dreamteamsservice.entity.DreamTeam;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
public interface DreamTeamRepository extends MongoRepository<DreamTeam, String> {
    DreamTeam findDreamTeamByUserId(@Param("userid") Integer userid);
    DreamTeam findDreamTeamById(@Param("id") String id);
}