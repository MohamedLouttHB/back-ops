package sebn.backend.api.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sebn.backend.api.Repositories.UserRepository;
import sebn.backend.api.entities.User;

import java.util.List;
@Service
@AllArgsConstructor
public class USerServiceImp implements UserService{
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId_user()).get();
        existingUser.setName_user(user.getName_user());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        User updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);

    }
}
