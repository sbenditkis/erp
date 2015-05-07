package org.temkin.erp.dao.hib.customer;

import org.springframework.stereotype.Repository;
import org.temkin.erp.dao.customer.CustomerDao;
import org.temkin.erp.dao.hib.generic.GenericHibernateDao;
import org.temkin.erp.model.customer.Customer;

@Repository("customerDao")
public class CustomerHibernateDao extends GenericHibernateDao<Integer, Customer> implements CustomerDao {

}
