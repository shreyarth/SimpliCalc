package com.config;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Product;
import com.service.UserService;

@WebServlet("/AddClass")
public class AddClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService = new UserService();
		System.out.println("inside servlet");
		Product prod = new Product(request.getParameter("name"), Integer.parseInt(request.getParameter("amount")));

		userService.registration(prod);
		HttpSession session = request.getSession();
		session.setAttribute("sesname", request.getParameter("name"));
		session.setAttribute("sesamt", request.getParameter("amount"));
		response.sendRedirect("registersuccess.jsp");

	}

}
