package be.thomasmore.favorietespelerservice.repository;

import be.thomasmore.favorietespelerservice.entity.FavorieteSpeler;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface FavorieteSpelerRepository extends MongoRepository<FavorieteSpeler, String> {
    FavorieteSpeler findFavorieteSpelerByUserId(@Param("userid") Integer userid);
    FavorieteSpeler findFavorieteSpelerById(@Param("id") String id);
}
