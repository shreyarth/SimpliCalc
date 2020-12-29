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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchname = request.getParameter("uname");
		String searchemail = request.getParameter("email");
		
		
		
		String sql = "select uname, email from empregistration";
		try {
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			boolean userFound = false;
			System.out.println("outside while in login");
			while (rs.next()) {
				String name = rs.getString(1);
				String email = rs.getString(2);
				if (searchname.equals(name) && searchemail.equals(email)) {
					response.getWriter().println("Login Successful");
					userFound = true;
					System.out.println("user found inside while");
					HttpSession session= request.getSession();
					session.setAttribute("sesname", name);
					response.sendRedirect("loginsuccess.jsp");
					
					break;
				}
			}
			if (!userFound) {
				response.getWriter().println("Username and email do not match our records");
			}
		} catch (Exception e) {
			
		}
	}
}

