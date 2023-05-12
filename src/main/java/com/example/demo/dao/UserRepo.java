package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.User;

public interface UserRepo extends CrudRepository<User, Integer>{

}
