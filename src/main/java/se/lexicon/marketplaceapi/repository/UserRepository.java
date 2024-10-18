package se.lexicon.marketplaceapi.repository;

import se.lexicon.marketplaceapi.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by username
    Optional<User> findByUsername(String username);

    // Find user by email
    Optional<User> findByEmail(String email);

    // Find user by email and password (for authentication)
    Optional<User> findByEmailAndPassword(String email, String password);

    // Find user by username and password (for advertisement creation authentication)
    Optional<User> findByUsernameAndPassword(String username, String password);

}
