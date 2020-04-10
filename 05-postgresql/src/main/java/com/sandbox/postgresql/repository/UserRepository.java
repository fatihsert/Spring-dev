package com.sandbox.postgresql.repository;

import com.sandbox.postgresql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
