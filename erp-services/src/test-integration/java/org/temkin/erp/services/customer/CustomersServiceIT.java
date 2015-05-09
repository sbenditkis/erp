package org.temkin.erp.services.customer;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.temkin.erp.model.customer.Customer;
import org.temkin.erp.services.IntegrationTestConfig;
import org.temkin.erp.services.customer.CustomersService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
public class CustomersServiceIT {
	
	@Autowired
	CustomersService customersService;
	
	@Test
	@Transactional
	@Sql("customer.sql")
	public void testFindCustomerById() {
		Customer customer = customersService.getCustomerById(1);
		assertNotNull(customer);
		assertEquals("Vasya", customer.getName());
	}
	
	@Configuration
	@Import(IntegrationTestConfig.class)
	@ComponentScan(basePackages={"org.temkin.erp.dao.hib.customer", "org.temkin.erp.services.impl.customer"})
	static class Config {
		@Bean
		ArrayList<Class<?>> annotatedClasses() {
			ArrayList<Class<?>> classes = new ArrayList<Class<?>>();
			classes.add(Customer.class);
			return classes;
		}
	}
}
