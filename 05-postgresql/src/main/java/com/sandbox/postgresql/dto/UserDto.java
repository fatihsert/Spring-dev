package com.sandbox.postgresql.dto;

import com.sandbox.postgresql.entity.UserAddress;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;
@Data
public class UserDto {
    private long id;

    private String name;

    private String lastName;

    private List<String> addressList;
}
