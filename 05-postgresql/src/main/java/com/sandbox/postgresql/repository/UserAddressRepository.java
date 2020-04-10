package com.sandbox.postgresql.repository;

import com.sandbox.postgresql.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends  JpaRepository<UserAddress, Long>  {
}
