package aashish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aashish.dao.CustomerDAOInt;
import aashish.model.Customer;
import aashish.model.VW_PROD_SUPP_XPS;
@Service
public class CustomerServiceImpl implements CustomerServiceInt {
	@Autowired
	private CustomerDAOInt customerDao;

	public String addCustomer(Customer cust) {
		return customerDao.addCustomer(cust);
			}

	public Customer getCustomerByUserId(String uid) {
		return customerDao.getCustomerByUserId(uid);	}

	public List<VW_PROD_SUPP_XPS> getProductsForUser() {
		return customerDao.getProductsForUser();
		}

	public List<VW_PROD_SUPP_XPS> getAllSuppProd(String pid) {
		return customerDao.getAllSuppProd(pid);

	}

	public Customer getCustomerByID(String custid) {	
		return customerDao.getCustomerByID(custid);
	}

	
	
	
	

}
