package sebn.backend.api.services;

import sebn.backend.api.entities.Department;
import sebn.backend.api.entities.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long userId);
    List<User> getAllUser();
    User updateUser(User user);
    void deleteUser(Long userId);
}
