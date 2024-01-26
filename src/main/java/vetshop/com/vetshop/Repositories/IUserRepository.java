package vetshop.com.vetshop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import vetshop.com.vetshop.Entities.User;

import java.util.UUID;

public interface IUserRepository extends JpaRepository<User, String> {
    UserDetails findByLogin(String login);
}
