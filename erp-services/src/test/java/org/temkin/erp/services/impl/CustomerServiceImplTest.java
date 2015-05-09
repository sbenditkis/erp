package org.temkin.erp.services.impl;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.temkin.erp.dao.customer.CustomerDao;
import org.temkin.erp.model.customer.Customer;
import org.temkin.erp.services.impl.customer.CustomersServiceImpl;

public class CustomerServiceImplTest {
	
	private CustomerDao customerDao;
	private CustomersServiceImpl customersServiceImpl;
	
	@Before
	public void setUp() {
		customerDao = mock(CustomerDao.class);
		customersServiceImpl = new CustomersServiceImpl();
		customersServiceImpl.setCustomerDao(customerDao);
	}
	
	@Test
	public void testFindCustomerById() {
		Customer ret = new Customer();
		ret.setId(1);
		ret.setName("Vasya");
		when(customerDao.getByPrimaryKey(1)).thenReturn(ret);
		
		Customer customer = customersServiceImpl.getCustomerById(1);
		assertEquals("Vasya", customer.getName());
		
		verify(customerDao).getByPrimaryKey(1);
	}
}
