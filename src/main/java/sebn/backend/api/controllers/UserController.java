package sebn.backend.api.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sebn.backend.api.entities.User;
import sebn.backend.api.services.UserService;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // Get User by Id endpoint
    @GetMapping("{id}")
    public User getUserById(@PathVariable("id") Long userId) {
        return userService.getUserById(userId);
    }

    // Get All User endpoint
    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    //Update User endpoint
    @PutMapping("{id}")
    public User updatedUser(@PathVariable("id") Long userId, @RequestBody User user) {
        user.setId_user(userId);
        User updatedUser = userService.updateUser(user);
        return updatedUser;
    }

    //Delete department endpoint
    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
    }

}



