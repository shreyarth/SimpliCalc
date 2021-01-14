package com.p3sec2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.p3sec2.entity.Feedback;

@Repository
public interface FeedbackDao extends CrudRepository<Feedback, Integer>{

}
