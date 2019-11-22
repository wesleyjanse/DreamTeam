package be.thomasmore.favorieteteamservice.repository;
import be.thomasmore.favorieteteamservice.entity.favorieteTeam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
public interface favorieteTeamRepository{
    favorieteTeam findTeamByNaam(@Param("naam") String naam);

}
