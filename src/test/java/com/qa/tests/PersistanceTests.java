package com.qa.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qa.persistance.repository.Service;
import com.qa.persistence.domain.Account;

public class PersistanceTests {

	Service service = new Service();
	Account account = new Account("Michael", "Jordan", 1);

	@Test
	public void addAccountTest() {
		assertTrue("Test failed", service.addAccount("Jeff", "Jeffers"));
	}
	
	@Test
	public void getFirstNameTest() {
		service.addAccount("Jeff", "Jeffers");
		assertEquals("Jeff", service.getAccount(1).getFirstName());
	}
	
	@Test
	public void getLastNameTest() {
		service.addAccount("Jeff", "Jeffers");
		assertEquals("Jeffers", service.getAccount(1).getLastName());
	}
	
	@Test
	public void addAccountNumberTest() {
		service.addAccount("Jeff", "Jeffers");
		assertEquals(1, service.getAccount(1).getAccountNumber());
	}

	@Test
	public void deleteAccountTest() {
		service.addAccount("Tom", "Jerry");
		assertEquals(true, service.deleteAccount(1));
	}

	@Test
	public void getAccountTest() {
		service.addAccount("Chris", "Bowers");
		assertEquals(1, service.getAccount(1).getAccountNumber());
	}
	
	@Test
	public void firstNameSearchTest() {
		
		service.addAccount("Jeff", "Jeffers");
		service.addAccount("Jeff", "Bowers");
		service.addAccount("Jeff", "Jeff");

		assertEquals(3,service.firstNameSearch("Jeff"));
	}

	@Test
	public void firstNameSearchTest2() {
		
		service.addAccount("Steph", "Jeffers");
		service.addAccount("Jeff", "Bowers");
		service.addAccount("Jeff", "Jeff");

		assertEquals(2,service.firstNameSearch("Jeff"));
	}
	
	@Test 
	public void lastNameSearchTest() {
		service.addAccount("Mick", "Jenkins");
		service.addAccount("Leeroy", "Jenkins");
		service.addAccount("Jennifer", "Jenkins");
		
		assertEquals(3, service.lastNameSearch("Jenkins"));
	}
	@Test 
	public void lastNameSearchTest2() {
		service.addAccount("Mick", "Jenkins");
		service.addAccount("Leeroy", "Jenkins");
		service.addAccount("Jennifer", "Lawrence");
		
		assertEquals(2, service.lastNameSearch("Jenkins"));
	}

	
	


}