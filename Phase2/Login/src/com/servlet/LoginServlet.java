package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String searchname = request.getParameter("name");
		String searchpass = request.getParameter("pass");

		String username = "simplilearn";
		String password = "simplilearn";
		boolean userFound = false;
		try {
			if (searchname.equals(username) && searchpass.equals(password)) {
				response.getWriter().println("Login Successful");
				System.out.println("user found inside while");
				HttpSession session = request.getSession();
				session.setAttribute("sesname", username);
				response.sendRedirect("dashboard.jsp");
				userFound = true;
			}

			if (!userFound) {
				response.getWriter().println("Username and email do not match our records");
			}
		} catch (Exception e) {

		}
	}
}
