package com.section1.dao;

import org.springframework.data.repository.CrudRepository;

import com.section1.model.User;

public interface UserDao extends CrudRepository<User, Long>{

}
