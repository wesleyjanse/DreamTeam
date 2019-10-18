package be.thomasmore.movieinfoservice.repository;


import be.thomasmore.movieinfoservice.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findMovieByTitle(@Param("title") String title);
}
