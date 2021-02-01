package com.capstone.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.capstone.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
}
