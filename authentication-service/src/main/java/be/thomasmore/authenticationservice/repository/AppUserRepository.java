package be.thomasmore.authenticationservice.repository;

import be.thomasmore.authenticationservice.model.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppUserRepository extends MongoRepository<AppUser, String> {

}
