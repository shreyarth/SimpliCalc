package com.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Product;
import com.utility.HibernateUtility;

public class UserService {

	public void registration(Product prod) {
		System.out.println("inside service");

		try {
			Session session = HibernateUtility.getSession();
			Transaction tx = session.beginTransaction();
			session.save(prod);
			tx.commit();
			System.out.println(("product is registered"));

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
