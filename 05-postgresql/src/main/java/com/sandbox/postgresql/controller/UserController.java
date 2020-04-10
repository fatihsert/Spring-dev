package com.sandbox.postgresql.controller;

import com.sandbox.postgresql.dto.UserDto;
import com.sandbox.postgresql.entity.User;
import com.sandbox.postgresql.entity.UserAddress;
import com.sandbox.postgresql.repository.UserRepository;
import com.sandbox.postgresql.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/User")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserServiceImpl userService;

    @PostConstruct
    public void init() {
        User user = new User();
        user.setName("fatih");
        user.setLastName("sert");
        List<UserAddress> userAddresses = new ArrayList<>();

        UserAddress userAddress = new UserAddress();
        userAddress.setAddressType(UserAddress.AddressType.Home);
        userAddress.setAddress("ev adresi");
        userAddress.setIsActive(true);
        userAddresses.add(userAddress);

        user.setAddressList(userAddresses);

       // userRepository.save(user);
    }

    @GetMapping(value = "/GetAll")
    public ResponseEntity<List<UserDto>> GetAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping("/Save")
    public ResponseEntity<UserDto> Save(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.save(userDto));
    }
}
