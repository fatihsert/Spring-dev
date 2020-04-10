package com.sandbox.postgresql.service;

import com.sandbox.postgresql.dto.UserDto;
import com.sandbox.postgresql.service.impl.UserServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService{
    UserDto save(UserDto userDto);
    void delete(Long id);
    List<UserDto> getAll();
    Page<UserDto> getAll(Pageable pageable);
}
