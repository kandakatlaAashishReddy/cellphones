package aashish.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aashish.model.Customer;
import aashish.model.CustomerOrder;
import aashish.model.CustomerOrderHistory;
import aashish.model.Product;
import aashish.model.ProductReview;
import aashish.model.TempReview;
import aashish.service.CustomerOrderServiceInt;
import aashish.service.CustomerServiceInt;
import aashish.service.ProductServiceInt;

@Controller
public class CustomerOrderController {
	@Autowired
	private ProductServiceInt productService;

	@Autowired 
	private CustomerServiceInt customerService;
	
	@Autowired
	private CustomerOrderServiceInt customerOrderService;
	
	


	@RequestMapping("/order/{cartId}")
	public String displayCheckOut(@PathVariable("cartId")String cartId){
		System.out.println("\nCartid in checkout : " + cartId);
		return "redirect:/checkout?cartId="+cartId;
	}
	
	@RequestMapping("/reqDisplayOrderHistory")
	public String displayOrderHistory(@RequestParam("customerid")String customerid, Model m){
		Customer customer = customerService.getCustomerByID(customerid);
		List <CustomerOrder> orders = customerOrderService.custOrders(customer.getCustomerid());
		m.addAttribute("orders", orders);
		return "displayOrders";
	}
	
	@RequestMapping("/reqReviewProductPage/{orderhistoryid}")
	public String displayProductRevPage(@PathVariable String orderHistoryid,Model m){		
		CustomerOrderHistory orderHistory = customerOrderService.getCustomerOrderHistoryByOrderHistoryId(orderHistoryid);
		Product product = productService.getProductByID(orderHistory.getProductid());			
		TempReview temp = new TempReview();				
		m.addAttribute("product", product);
		m.addAttribute("ordhistroy",orderHistory);
		m.addAttribute("reviewobject",temp);
		return "productReviewPage";
	}
	
	@RequestMapping("/reqAddProductRating/{ordhistid}")
	public String rateProduct(@ModelAttribute("reviewobject")TempReview tempreview,@PathVariable("orderHistoryid")String orderHistoryid,HttpSession hsession){
		ProductReview productReview = new ProductReview();
		Customer customer = (Customer)hsession.getAttribute("customerprofile");
		productReview.setCustomerid(customer.getCustomerid());
		CustomerOrderHistory history = customerOrderService.getCustomerOrderHistoryByOrderHistoryId(orderHistoryid);
		productReview.setOrderhistoryid(orderHistoryid);
		//productReview.setCustomerorderhistoryid(orderHistoryid);
		productReview.setRating(tempreview.getRating());
		productReview.setComments(tempreview.getComment());
		productReview.setProductid(history.getProductid());
		//productReview.setComments("ok");
		customerOrderService.addProductReview(productReview);
/*		history.setComments(tempreview.getComment());
		history.setRating(tempreview.getRating());
		history.setReviewgiven(true);
		customerOrderService.updateOrderHistory(history);*/
		float rating = customerOrderService.getRating(history.getProductid());
		System.out.println("\nRating : " + rating);
		Product product = productService.getProductByID(history.getProductid());
		product.setRating(rating);
		//prd.setNoitemssold(customerOrderService.getNoOfItemsSold(history.getProductid()));
		product.setNoreviews(customerOrderService.getNoOfReviews(history.getProductid()));		
		productService.updateProduct(product);		
		return "redirect:/reqDisplayOrderHistory?custid="+customer.getCustomerid();
	}
}
