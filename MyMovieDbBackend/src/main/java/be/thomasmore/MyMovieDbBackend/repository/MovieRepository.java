package be.thomasmore.MyMovieDbBackend.repository;

import be.thomasmore.MyMovieDbBackend.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
