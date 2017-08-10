package aashish.service;

import java.util.List;

import aashish.model.Customer;
import aashish.model.VW_PROD_SUPP_XPS;

public interface CustomerServiceInt {
	public String addCustomer(Customer cust);
	public Customer getCustomerByUserId(String uid);
	public List<VW_PROD_SUPP_XPS> getProductsForUser();
	public List<VW_PROD_SUPP_XPS> getAllSuppProd(String pid);
	public Customer getCustomerByID(String custid);


}
