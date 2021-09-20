package com.bridgelabs.addressbooktest;

import java.sql.SQLException;

import org.junit.Test;

import com.bridgelabs.addressbook.AddressBook;

public class AddressBookTest {

	@Test
	public void retrieveDataFromDB_ShouldReturnData() {
		AddressBook book = new AddressBook();
		book.getDataFromDB();

	}

	@Test
	public void updateRecord_ShouldGiveUpdatedRecords() {
		AddressBook book = new AddressBook();
		book.updateRecord("India", "tiaa");
	}

	@Test
	public void retrieveDataFromSpecificPeriod() throws SQLException {
		AddressBook book = new AddressBook();
		book.getdataByDate("2018-09-01");

	}

	@Test
	public void retrieveDataForStateOrCity() throws SQLException {
		AddressBook book = new AddressBook();
		book.getContactsByCityOrState("dombivali", "Mumbai");
	}

	
	@Test
	public void insertDataIntoDB()
	{
		AddressBook book= new AddressBook();
		book.insertIntoDB("Prit", "Bhang", "Hyd", "Kalwa", "Maha", 421202, 8982288, "Äbc@gmail.com", "Friends");
	}

}
