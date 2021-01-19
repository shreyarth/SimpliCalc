package com.springbootphase3end.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springbootphase3end.entity.Tasks;

@Repository
public interface TaskDao extends CrudRepository<Tasks, Integer>{

}
