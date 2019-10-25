package be.thomasmore.spelerservice.repository;

import be.thomasmore.spelerservice.entity.Speler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface SpelerRepository extends JpaRepository<Speler, Integer> {
    Speler findSpelerByNaam(@Param("naam") String naam);
}
