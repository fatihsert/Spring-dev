package com.sandbox.elasticsearch.api;

import com.sandbox.elasticsearch.entity.User;
import com.sandbox.elasticsearch.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Users")
@RequiredArgsConstructor
public class UserController {
    private final IUserRepository userRepository;


    @PostConstruct
    public void Init()
    {
        User user = new User();
        user.setName("rıza");
        user.setLastName("özdemir");
        user.setAddress("yozgat");
        user.setBirthdate(DateTime.now().toDate());

        userRepository.save(user);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<User>> Users(@PathVariable String search) {
        List<User> result=userRepository.findByNameOrLastName(search,search);

       /*List<User> users = new ArrayList<User>();

        Iterable<User> userIterable = userRepository.findAll();
        userIterable.forEach(user -> users.add(user));

        return ResponseEntity.ok(users);

        */

        return ResponseEntity.ok(result);
    }

}
