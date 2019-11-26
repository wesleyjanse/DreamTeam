package be.thomasmore.userservice.repository;

import be.thomasmore.userservice.entity.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface UserRepository extends MongoRepository<AppUser, String> {
    AppUser findAppUserById(@Param("id") Integer id);
}