package be.thomasmore.authenticationservice.repository;

import be.thomasmore.authenticationservice.model.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
public interface AppUserRepository extends MongoRepository<AppUser, String> {
    Boolean existsAppUserByUsernameEquals(String userName);
    AppUser findByUsernameEquals(String userName);
    AppUser findAppUserByUsername(@Param("username") String username);
}
