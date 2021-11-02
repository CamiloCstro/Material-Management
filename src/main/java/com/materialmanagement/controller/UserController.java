package com.materialmanagement.controller;

import com.materialmanagement.model.User;
import com.materialmanagement.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    IUserRepository userRepository;

    @GetMapping("/User")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/User/{id}")
    public User getUserById(@PathVariable Integer id) {
        User User =  userRepository.findById(id).get();
        return User;
    }

    @PostMapping("/User")
    public User createUser(@RequestBody User User) {
        return userRepository.save(User);
    }

    @PutMapping("/User/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User UserNew) {

        User user = userRepository.findById(id).get();

        user.setName(UserNew.getName());
        user.setLastName(UserNew.getLastName());
        user.setEmail(UserNew.getEmail());
        user.setActive(UserNew.isActive());
        user.setPassword(UserNew.getPassword());

        userRepository.save(user);

        return user;
    }

    @DeleteMapping("/User/{id}")
    public User deleteUser(@PathVariable Integer id) {
        User User = userRepository.findById(id).get();
        userRepository.deleteById(id);
        return User;
    }


}
