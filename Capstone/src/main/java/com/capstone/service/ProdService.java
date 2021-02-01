package com.capstone.service;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.capstone.dao.ProductRepo;
import com.capstone.dao.UserRepo;
import com.capstone.entity.Product;
import com.capstone.entity.User;

import lombok.val;

@Service
public class ProdService {
	private static List<Product> products =  new ArrayList<>();
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private UserService userService;
	
	public List<Product> getAllProducts(){
		
		return (List<Product>) productRepo.findAll();
	}
	
	public Product getOneProduct(int id) {
		return productRepo.findById(id).orElse(null);
	}
	
	public boolean adminLogin() {
		List<User> users = userService.getAllUsers();
		Iterator<User> uIterator = users.iterator();
		while(uIterator.hasNext()) {
			User user = uIterator.next();
			if(user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
				return true;
			}
		}
		return false;
	}
	
	public void addProduct(Product product) {
		productRepo.save(product);
	}
	
	public List<Product> findByProductsByString(String string) {
		List<Product> searchedProducts = getAllProducts().stream()
				.filter(p->p.getCategory().equalsIgnoreCase(string) || 
						p.getProddescription().equalsIgnoreCase(string) ||
						p.getProductname().equalsIgnoreCase(string))
				.collect(Collectors.toList());
		System.out.println(searchedProducts);
		return searchedProducts;
	}

}
