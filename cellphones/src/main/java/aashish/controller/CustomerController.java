package aashish.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aashish.model.BillingAddress;
import aashish.model.Cart;
import aashish.model.Customer;
import aashish.model.ShippingAddress;
import aashish.model.UserDetails;
import aashish.model.VW_PROD_SUPP_XPS;
import aashish.model.Vw_Cust_Rating;
import aashish.service.CustomerOrderServiceInt;
import aashish.service.CustomerServiceInt;
import aashish.service.UserDetailsServiceInt;

@Controller
public class CustomerController {

	@Autowired
	private CustomerServiceInt customerService;

	@Autowired
	private UserDetailsServiceInt userDetailsService;
	@Autowired
	private CustomerOrderServiceInt customerOrderService;

	@RequestMapping("/reqSignupPage")
	public String displaysignuppage(Model m) {
		UserDetails userDetails = new UserDetails();
		ShippingAddress shippingAddress = new ShippingAddress();
		Customer customer = new Customer();
		customer.setUserDetails(userDetails);
		customer.setShippingAddress(shippingAddress);
		m.addAttribute("customerObject", customer);
		return "signupForm";
	}

	@RequestMapping("/reqSendSignupData")
	public String sendSignUpData(@ModelAttribute("customerObject") Customer customer, Model m) {

		customer.setEnabled(true);
		customer.getUserDetails().setRole("ROLE_USER");
		customer.getUserDetails().setEnabled(true);

		BillingAddress billingAddress = new BillingAddress();
		billingAddress.setHouseno(customer.getShippingAddress().getHouseno());
		billingAddress.setStreet(customer.getShippingAddress().getStreet());
		billingAddress.setArea(customer.getShippingAddress().getArea());
		billingAddress.setCity(customer.getShippingAddress().getCity());
		billingAddress.setState(customer.getShippingAddress().getState());
		billingAddress.setCountry(customer.getShippingAddress().getCountry());
		billingAddress.setPincode(customer.getShippingAddress().getPincode());

		Cart cart = new Cart();

		customer.setBillingAddress(billingAddress);
		customer.setCart(cart);

		String userid = customerService.addCustomer(customer);
		String message = "Signup is successfull.\nNew User id : " + userid;
		m.addAttribute("signupmsg", message);
		m.addAttribute("userObject", new UserDetails());
		return "loginpage";
	}

	@RequestMapping("/reqLoginPage")
	public String loginPage(UserDetails userDetails, Model m) {
		m.addAttribute("userObject", new UserDetails());
		return "loginpage";
	}

	@RequestMapping("/reqLoginCheck")
	public String loginCheck(@ModelAttribute("userObject") UserDetails userDetails, Model m, HttpSession hsession) {

		UserDetails temp = userDetailsService.loginCheck(userDetails);
		System.out.println(temp);
		if (temp == null) {// if authentication failed
			String message = "Login failed..,\nTry again...";
			m.addAttribute("userObject", new UserDetails());
			m.addAttribute("msg", message);
			return "loginpage";
		} else if (temp.getRole().equals("ROLE_USER")) {
			List<VW_PROD_SUPP_XPS> productsuser = customerService.getProductsForUser();
			hsession.setAttribute("customerprofile", customerService.getCustomerByUserId(temp.getUserid()));
			m.addAttribute("productsuser", productsuser);
			System.out.println("data in controller  :" + productsuser);
			return "userHomePage";
		} else {
			m.addAttribute("userid", temp.getUserid());

			return "adminHomePage";
		}
	}

	/*@RequestMapping("/reqDisplayProductsUser")
	public String displayProductsUser(Model m){
		List <VW_PROD_SUPP_XPS> productsuser = customerService.getProductsForUser();
		m.addAttribute("productsuser", productsuser);
		return "userHomepage1";
	}*/
	@RequestMapping("/reqDisplayProductsUser")
	public String displayProductsUser(HttpSession hsession,Model m){	
		Customer oldcustomer = (Customer)hsession.getAttribute("customerprofile");
		Customer newcustomer = customerService.getCustomerByID(oldcustomer.getCustomerid());
		hsession.setAttribute("customerprofile", newcustomer);
		List <VW_PROD_SUPP_XPS> productsuser = customerService.getProductsForUser();
		m.addAttribute("productsuser", productsuser);
		return "userHomePage";
	}
	
	
	
	@RequestMapping("/reqProductAllSuppliers")
	public String getProductsAllSuppliers(@RequestParam("productid") String productid, Model m) {
		List<VW_PROD_SUPP_XPS> allSupplierProduct = customerService.getAllSuppProd(productid);
		List<Vw_Cust_Rating> reviewData = customerOrderService.getCommentsForProduct(allSupplierProduct.get(0).getProductid());
		m.addAttribute("allSupProd", allSupplierProduct);
		m.addAttribute("reviewData", reviewData);
		return "allProdSuppliers";

	}
	@RequestMapping("/reqLogout")
	public String logout(HttpSession hsession,Model m){
		hsession.invalidate();
		String logoutMessage = "Logged out successfully.\nThanks for visiting our site...";
		m.addAttribute("message", logoutMessage);
		return "index";

}
	@RequestMapping("/reqLoginPage1")
	public String loginPage1(@RequestParam(value="error", required=false)String error,Model m){
		if(error!=null){
			String message = "Login failed..,\nTry again...";
			m.addAttribute("errormsg", message);
		}
		return "springSecuityLoginPage";
	}

	@RequestMapping("/springLoginCheck") // comes here after spring security authenticates user
	public String loginCheck(Principal principal,HttpSession hsession,Model m){
		System.out.print("\nCustomerController - springLoginCheck()");
		System.out.println("\nName : " + principal.getName());
		Customer customer = customerService.getCustomerByUserId(principal.getName());
		UserDetails userDetials = customer.getUserDetails();
		System.out.println("\nRole : " + userDetials.getRole());

		if(userDetials.getRole().equals("ROLE_USER")){
			hsession.setAttribute("customerprofile", customer);
			return "redirect:/reqDisplayProductsUser";
		}

		if(userDetials.getRole().equals("ROLE_ADMIN")){
			hsession.setAttribute("adminprofile", customer);
			return "adminHomePage";
		}
		return "";
	}
	@RequestMapping("/reqLogoutSpring")  // spring security logout
	public String logoutSpring(HttpSession hsession,Model m){
		hsession.invalidate();
		String logoutMessage = "Logged out succcessfully.\nThanks for visiting our site...";
		m.addAttribute("message", logoutMessage);
		return "index";
	}

	
}