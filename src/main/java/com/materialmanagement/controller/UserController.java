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
        // The BookRepository is already injected and you can use it
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

        User User = userRepository.findById(id).get();

        User.setName(UserNew.getName());
        User.setLastName(UserNew.getLastName());
        User.setEmail(UserNew.getEmail());
        User.setActive(UserNew.isActive());
        User.setPassword(UserNew.getPassword());

        userRepository.save(User);

        return User;
    }

    @DeleteMapping("/User/{id}")
    public User deleteUser(@PathVariable Integer id) {
        User User = userRepository.findById(id).get();
        userRepository.deleteById(id);
        return User;
    }


}
