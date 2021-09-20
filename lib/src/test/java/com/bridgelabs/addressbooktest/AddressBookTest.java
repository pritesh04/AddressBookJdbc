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
}
