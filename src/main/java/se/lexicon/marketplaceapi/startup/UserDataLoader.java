package se.lexicon.marketplaceapi.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.marketplaceapi.domain.entity.User;
import se.lexicon.marketplaceapi.repository.UserRepository;

@Component
public class UserDataLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public UserDataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(" ");
        System.out.println("#########################");
        System.out.println("Save 10 users in database");
        userRepository.save(new User("john_doe", "password123", "john.doe@example.com"));
        userRepository.save(new User("jane_smith", "password123", "jane.smith@example.com"));
        userRepository.save(new User("mike_jones", "password123", "mike.jones@example.com"));
        userRepository.save(new User("lisa_white", "password123", "lisa.white@example.com"));
        userRepository.save(new User("david_brown", "password123", "david.brown@example.com"));
        userRepository.save(new User("emily_black", "password123", "emily.black@example.com"));
        userRepository.save(new User("will_smith", "password123", "will.smith@example.com"));
        userRepository.save(new User("nancy_davis", "password123", "nancy.davis@example.com"));
        userRepository.save(new User("paul_taylor", "password123", "paul.taylor@example.com"));
        userRepository.save(new User("rachel_martin", "password123", "rachel.martin@example.com"));

    }
}
