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
	public void updateRecord(String city, String name) {
		try (java.sql.Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
			String query = ("update address_book set city=?  where firstName=?");
			java.sql.PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, city);
			ps.setString(2, name);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getdataByDate(String date) throws SQLException {
		try (java.sql.Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

				java.sql.PreparedStatement stmt = conn.prepareStatement(
						"select phoneNumber from address_book where startdate between CAST(? AS DATE) AND DATE(NOW()) ")) {
			stmt.setString(1, date);
			ResultSet rs = stmt.executeQuery();
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
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void getContactsByCityOrState(String city, String state) {
		try (java.sql.Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				java.sql.PreparedStatement stmt = conn
						.prepareStatement("select * from address_book where city = ? or state = ? ");) {
			stmt.setString(1, city);
			stmt.setString(2, state);
			ResultSet rs = stmt.executeQuery();
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
		rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}




	public void insertIntoDB(String firstName, String lastName, String address, String city, String state, int zipcode,
			int phoneNumber, String email, String type) {
		try (java.sql.Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				java.sql.PreparedStatement stmt = conn
						.prepareStatement("insert into address_book values (?,?,?,?,?,?,?,?,?) ");) {
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, address);
			stmt.setString(4, city);
			stmt.setString(5, state);
			stmt.setInt(6, zipcode);
			stmt.setInt(7, phoneNumber);
			stmt.setString(8, email);
			stmt.setString(9, type);
			// stmt.setString(10, startDate);
			stmt.executeUpdate();
			int status = stmt.executeUpdate();
			if (status > 0) {
				System.out.println("Record  inserted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}




	
}
