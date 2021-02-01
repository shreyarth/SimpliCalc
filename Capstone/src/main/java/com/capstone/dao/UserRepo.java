package com.capstone.dao;

import org.springframework.data.repository.CrudRepository;

import com.capstone.entity.User;

public interface UserRepo extends CrudRepository<User, Integer>{
}
