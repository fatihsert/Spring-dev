package com.sandbox.elasticsearch.repository;

import com.sandbox.elasticsearch.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public  interface IUserRepository  extends ElasticsearchRepository<User,String> {

    List<User> findByName(String query);

    List<User> findByNameOrLastName(String name,String lastName);
}
