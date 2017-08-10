package aashish.service;

import java.util.List;

import aashish.model.Product;

public interface ProductServiceInt {
	void addProduct(Product prd);
	void deleteProduct(String pid);
	void updateProduct(Product prd);
	List<Product> getProducts();
	Product getProductByID(String pid);

}
