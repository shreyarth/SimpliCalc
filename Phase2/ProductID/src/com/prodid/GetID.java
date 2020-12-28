package com.prodid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.product.Product;

public class GetID {
	public static List<Product> getProducts(int id) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		DBConn dbcon;
		List<Product> products = new ArrayList<Product>();
		try {
			dbcon = new DBConn();
			conn = dbcon.getCon();
			PreparedStatement pst;
			pst = conn.prepareStatement("select * from Products where id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Product prod = new Product();
				prod.setId(rs.getInt(1));
				prod.setName(rs.getString(2));
				prod.setAmount(rs.getInt(3));
				products.add(prod);
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return products;
	}
}
