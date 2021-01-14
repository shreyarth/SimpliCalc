package com.p3sec2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Feedback {
	@Id
	@GeneratedValue
	private int id;
	private String feeback;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFeeback() {
		return feeback;
	}
	public void setFeeback(String feeback) {
		this.feeback = feeback;
	}
	public Feedback(String feeback) {
		super();
		this.feeback = feeback;
	}
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Feedback [id=" + id + ", feeback=" + feeback + "]";
	}
	
	
}
