package org.temkin.erp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.temkin.erp.model.customer.Customer;
import org.temkin.erp.services.customer.CustomersService;

@RestController
@RequestMapping("/customer")
public class CustomersController {

	@Autowired
	CustomersService customersService;
	
	@RequestMapping("/{id}")
	public Customer get(@PathVariable("id") int id) {
		return customersService.getCustomerById(id);
	}
}
