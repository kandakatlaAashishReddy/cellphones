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
	public String displaysignupdata(@ModelAttribute("productObject")Product prd,Model m){
		prd.setIsproductavailable(true);
		productService.addProduct(prd);
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
	public String deleteproduct(@RequestParam("pid")String pid){
		productService.deleteProduct(pid);
		return "redirect:reqDisplayProductsAdmin";
	}
	@RequestMapping("/reqEditProductPageAdmin")
	public String editproduct(@RequestParam("pid")String pid,Model m){
		Product prd= productService.getProductByID(pid);
		m.addAttribute("product",prd);
		return "productEditAdmin";
	}
	@RequestMapping("/reqSendUpdatedProductToDB")
	public String updateProductToDB(@ModelAttribute("productObject")Product prd){
		productService.updateProduct(prd);
		return "redirect:reqDisplayProductsAdmin";
	}
}
