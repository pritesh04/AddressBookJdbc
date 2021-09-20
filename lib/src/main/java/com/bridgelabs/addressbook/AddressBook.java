package com.bridgelabs.addressbook;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class AddressBook {
	static final String DB_URL = "jdbc:mysql://localhost/address_bookservice";
	static final String USER = "root";
	static final String PASS = "root";

	public void getDataFromDB() {
		try (java.sql.Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				java.sql.Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from address_book")) {
			while (rs.next()) {
				System.out.print("FirstName" + rs.getString(1) + "  ");
				System.out.print("LastName: " + rs.getString(2) + "  ");
				System.out.print("Address: " + rs.getString(3) + "  ");
				System.out.print("City: " + rs.getString(4) + "  ");
				System.out.print("State: " + rs.getString(5) + "  ");
				System.out.print("Zip: " + rs.getInt(6) + "  ");
				System.out.print("PhoneNumbers: " + rs.getInt(7) + "  ");
				System.out.print("Email: " + rs.getString(8) + "  ");
				System.out.println("Type: " + rs.getString(9) + "  ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
