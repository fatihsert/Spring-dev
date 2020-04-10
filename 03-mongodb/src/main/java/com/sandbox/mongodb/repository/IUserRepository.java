package com.sandbox.mongodb.repository;

import com.sandbox.mongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserRepository extends MongoRepository<User,String> {
}
