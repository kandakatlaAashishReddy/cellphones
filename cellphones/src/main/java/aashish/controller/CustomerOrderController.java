package aashish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aashish.model.Customer;
import aashish.service.CustomerServiceInt;

@Controller
public class CustomerOrderController {
	@Autowired 
	private CustomerServiceInt customerService;
	
	
	
	@RequestMapping("/reqDisplayOrderHistory")
	public String displayOrderHistory(@RequestParam("custid")String custid, Model m){
		Customer cust = customerService.getCustomerByUserId(custid);
		//List <CustomerOrder> orders = customerOrderService.custOrders(cust.getCustomerid());
		//System.out.print("\nOrders : " + orders);
		//System.out.print("\nOrderItems : " + orders.get(0).getCustomerOrdersHistory());
		//System.out.print("\nOrderItems : " + orders.get(1).getCustomerOrdersHistory());
		
		//m.addAttribute("orders", orders);
	//	m.addAttribute("imagenum", CommonController.generateRandomNum());
		
		return "displayOrders";
	

}
}
