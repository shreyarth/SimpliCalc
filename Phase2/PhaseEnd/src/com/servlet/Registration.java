package com.servlet;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.EmpRegistration;
import com.service.UserService;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService = new UserService();

		System.out.println("inside servlet");

		EmpRegistration reg = new EmpRegistration(request.getParameter("uname"), request.getParameter("email"),
				request.getParameter("city"));

		userService.registration(reg);
		HttpSession session = request.getSession();

		session.setAttribute("sesname", request.getParameter("uname"));

		response.sendRedirect("registersuccess.jsp");

	}

}
