package sebn.backend.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sebn.backend.api.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
