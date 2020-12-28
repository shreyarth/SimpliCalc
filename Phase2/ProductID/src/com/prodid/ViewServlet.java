package com.prodid;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.Product;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String searchID = request.getParameter("id");
		int prodID = Integer.parseInt(searchID);
		PrintWriter out = response.getWriter();

		List<Product> list;
		boolean prodExists = false;
		try {
			list = GetID.getProducts(prodID);
			out.println("<h1>Products List</h1>");
			out.print("<table border='1' width='100%'");
			for (Product p : list) {
				if (p.getId() == prodID) {
					prodExists = true;
					out.print("<tr><th>Id</th><th>Name</th><th>Amount</th></tr>");
					out.print("<tr><td>" + p.getId() + "</td><td>" + p.getName() + "</td><td>" + p.getAmount()
							+ "</td></tr>");
				} 
			}
			out.print("</table>");
			if(!prodExists) {
				out.println("<h2>Sorry...no product with that ID</h2>");
			}
			
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
	}
}
