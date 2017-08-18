package aashish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aashish.model.Product;
import aashish.service.ProductServiceInt;

@Controller
public class ProductController {
	@Autowired
	private ProductServiceInt productService;
	
	@RequestMapping("/reqProductForm")
	public String addProdform(Model m){
		m.addAttribute("productObject", new Product());
		return "addProduct";
	}
	@RequestMapping("/reqproductform")
	public String displaysignupdata(@ModelAttribute("productObject")Product product,Model m){
		product.setIsproductavailable(true);
		productService.addProduct(product);
		return "adminHomePage";
}
	@RequestMapping("/reqDisplayProductsAdmin")
	public String displayProductsAdmin(Model m){
		List<Product> allproducts = productService.getProducts();
		System.out.println(allproducts);
		System.out.println(allproducts.get(0).getProductid());
		m.addAttribute("allproducts", allproducts);
		return "displayProductAdmin";
	}

	@RequestMapping("/reqDeleteProductAdmin")
	public String deleteproduct(@RequestParam("pid")String productid){
		productService.deleteProduct(productid);
		return "redirect:reqDisplayProductsAdmin";
	}
	@RequestMapping("/reqEditProductPageAdmin")
	public String editproduct(@RequestParam("pid")String productid,Model m){
		Product product= productService.getProductByID(productid);
		m.addAttribute("product",product);
		return "productEditAdmin";
	}
	@RequestMapping("/reqSendUpdatedProductToDB")
	public String updateProductToDB(@ModelAttribute("productObject")Product product){
		productService.updateProduct(product);
		return "redirect:reqDisplayProductsAdmin";
	}
}
