package com.capstone.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
@NoArgsConstructor
@ToString
@Entity
//@Data
@Table(name = "cap_product", uniqueConstraints = {
		@UniqueConstraint(columnNames = {
				"id",
				"productname"
		})
})
public class Product { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String productname;
	private String category;
	private String proddescription;
	private String image;
	private int price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProddescription() {
		return proddescription;
	}
	public void setProddescription(String proddescription) {
		this.proddescription = proddescription;
	}
	public Product(String productname, String category, String proddescription, String image, int price) {
		super();
		this.productname = productname;
		this.category = category;
		this.proddescription = proddescription;
		this.image = image;
		this.price = price;
	}
	
}
