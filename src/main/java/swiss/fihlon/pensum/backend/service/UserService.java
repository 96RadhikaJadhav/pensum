package swiss.fihlon.pensum.backend.service;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import swiss.fihlon.pensum.backend.entity.User;
import swiss.fihlon.pensum.backend.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmail(final String email) {
        return userRepository.findByEmail(email);
    }

    @PostConstruct
    public void populateTestData() {
        if (userRepository.count() == 0) {
            userRepository.saveAll(
                    Stream.of(
                            new User("user", "{noop}password")
                    ).collect(Collectors.toList()));
        }
    }

}
