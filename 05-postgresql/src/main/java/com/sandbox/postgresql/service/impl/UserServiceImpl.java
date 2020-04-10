package com.sandbox.postgresql.service.impl;

import com.sandbox.postgresql.dto.UserDto;
import com.sandbox.postgresql.entity.User;
import com.sandbox.postgresql.entity.UserAddress;
import com.sandbox.postgresql.repository.UserAddressRepository;
import com.sandbox.postgresql.repository.UserRepository;
import com.sandbox.postgresql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserAddressRepository userAddressRepository;


    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
       final User  userdb = userRepository.save(user);
        List<UserAddress> userAddressList = new ArrayList<>();

        for (String item : userDto.getAddressList()) {
            UserAddress userAddress = new UserAddress();
            userAddress.setAddress(item);
            userAddress.setAddressType(UserAddress.AddressType.Home);
            userAddress.setUser(userdb);
            userAddressList.add(userAddress);
        }

        userAddressRepository.saveAll(userAddressList);

        userDto.setId(userdb.getId());

        return userDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<UserDto> getAll() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();

        userList.forEach(item -> {
            UserDto userDto = new UserDto();
            userDto.setName(item.getName());
            userDto.setLastName(item.getLastName());
            userDto.setId(item.getId());
            userDto.setAddressList(item.getAddressList().stream().map(UserAddress::getAddress).collect(Collectors.toList()));

            userDtos.add(userDto);
        });

        return userDtos;
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return null;
    }
}
