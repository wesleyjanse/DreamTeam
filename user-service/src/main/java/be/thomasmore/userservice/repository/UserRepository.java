package be.thomasmore.userservice.repository;
import org.springframework.data.repository.query.Param;
import be.thomasmore.userservice.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> findUserById(@Param("userid") Integer userid);
    List<User> findUserByUsername(@Param("username") String username);

    User findUserByUserIdAndUsername(@Param("userid") Integer userid, @Param("username") Integer username);
}
