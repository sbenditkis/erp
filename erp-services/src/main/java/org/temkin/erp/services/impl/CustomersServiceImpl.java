package org.temkin.erp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.temkin.erp.dao.customer.CustomerDao;
import org.temkin.erp.model.customer.Customer;
import org.temkin.erp.services.CustomersService;

@Service("customersService")
public class CustomersServiceImpl implements CustomersService {

	@Autowired
	CustomerDao customerDao;
	
	public Customer getCustomerById(int id) {
		return customerDao.getByPrimaryKey(id);
	}

}
