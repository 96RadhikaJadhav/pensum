package swiss.fihlon.pensum.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swiss.fihlon.pensum.backend.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User getByEmail(String email);

}
