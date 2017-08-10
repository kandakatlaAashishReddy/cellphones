package aashish.dao;

import java.util.List;

import aashish.model.Product;

public interface ProductDAOInt {

	void addProduct(Product prd);
	void deleteProduct(String pid);
	void updateProduct(Product prd);
	List<Product> getProducts();
	Product getProductByID(String pid);

	
}
