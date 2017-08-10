package aashish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aashish.dao.ProductDAOInt;
import aashish.model.Product;
@Service
public class ProductServiceImpl implements ProductServiceInt {
	@Autowired
	private ProductDAOInt productDao;
	public void addProduct(Product prd) {
		productDao.addProduct(prd);

	}

	public void deleteProduct(String pid) {
		  productDao.deleteProduct(pid);
	}

	public void updateProduct(Product prd) {
		productDao.updateProduct(prd);
		
	}

	public List<Product> getProducts() {
		return productDao.getProducts();
		}

	public Product getProductByID(String pid) {
		return productDao.getProductByID(pid);
	}

}
