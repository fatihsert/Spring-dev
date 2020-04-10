package com.sandbox.mongodb.api;

import com.sandbox.mongodb.entity.User;
import com.sandbox.mongodb.repository.IUserRepository;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    IUserRepository userRepository;

    @GetMapping("/GetUser")
    public ResponseEntity<Optional<User>> GetUser(String id) {

        Optional<User> user = userRepository.findById(id);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/GetUsers")
    public ResponseEntity<List<User>> GetUsers() {
        List<User> users = userRepository.findAll();

        return ResponseEntity.ok(users);
    }

    @PostMapping(value = "/User", consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> AddUser(@RequestBody User user)
            throws Exception {

        if (user == null || user.getName().isEmpty() || user.getLastName().isEmpty())
            return new ResponseEntity<User>(user, HttpStatus.NOT_ACCEPTABLE);

        User result = userRepository.insert(user);

        return ResponseEntity.ok(result);
    }
}
