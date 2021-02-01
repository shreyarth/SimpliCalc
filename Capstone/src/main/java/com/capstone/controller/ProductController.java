package com.capstone.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.capstone.entity.Product;
import com.capstone.service.ProdService;

import javassist.expr.NewArray;

@Controller
public class ProductController {
	@Autowired
	private ProdService prodService;
	List<Product> cartList = new ArrayList<>();
	
	@GetMapping("/")
	public String home(ModelMap model) {
		model.put("products", prodService.getAllProducts());
		model.put("carts", cartList);	
		return "home";
	}
	
	@GetMapping("/addproduct")
	public String addProduct(@SessionAttribute("username")String username, @SessionAttribute("password")String password,ModelMap model) {
		if(username.equals("admin") && password.equals("admin")) {
			model.addAttribute("product", new Product());
			return "addprod";
		}
		return "Not an admin";
	}
	
	@PostMapping("/addproduct")
	public String addProductPost(@ModelAttribute("product")Product product, ModelMap model) {
		prodService.addProduct(product);
		return ("redirect:/");
	}
	
	@GetMapping("/addtocart/{id}")
	public String addToCart(@PathVariable("id")int id, HttpSession session) {
		if(session.getAttribute("username") != null) {
			cartList.add(prodService.getOneProduct(id));
			return ("redirect:/");
		}
		return ("redirect:/login");
	}
	
	@GetMapping("/viewcart")
	public String viewCart(ModelMap model){
		System.out.println(cartList);
		model.addAttribute("carts", cartList);
		return "viewcart";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		cartList.clear();
		session.invalidate();
		return ("redirect:/");
	}
	
	@GetMapping("/editproduct/{id}")
	public String editProduct(@PathVariable("id")int id, ModelMap model) {
		Product product = prodService.getOneProduct(id);
		System.out.println(product);
		model.addAttribute("singleproduct", product);
		return "editproduct";
	}
	
	@PostMapping("/editproduct/{id}")
	public String editSaveProduct(@ModelAttribute("singleproduct")Product product) {
		prodService.addProduct(product);
		return ("redirect:/");
	}
	
	@GetMapping("/productlist")
	public String findProducts(@RequestParam(value = "search")String string, ModelMap model) {
		List<Product> searchResultList = prodService.findByProductsByString(string);
		System.out.println(searchResultList);
		model.addAttribute("searchresults", searchResultList);
		return "productlist";
	}
}
