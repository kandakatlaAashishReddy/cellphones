package aashish.controller;

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
import aashish.service.CustomerServiceInt;
import aashish.service.UserDetailsServiceInt;

@Controller
public class CustomerController {

	@Autowired
	private CustomerServiceInt customerService;

	@Autowired
	private UserDetailsServiceInt userDetailsService;

	@RequestMapping("/reqSignupPage")
	public String displaysignuppage(Model m) {
		UserDetails ud = new UserDetails();
		ShippingAddress sad = new ShippingAddress();
		Customer cust = new Customer();
		cust.setUserDetails(ud);
		cust.setShippingAddress(sad);
		m.addAttribute("customerObject", cust);
		return "signupForm";
	}

	@RequestMapping("/reqSendSignupData")
	public String sendSignUpData(@ModelAttribute("customerObject") Customer cust, Model m) {

		cust.setEnabled(true);
		cust.getUserDetails().setRole("ROLE_USER");
		cust.getUserDetails().setEnabled(true);

		BillingAddress bad = new BillingAddress();
		bad.setHouseno(cust.getShippingAddress().getHouseno());
		bad.setStreet(cust.getShippingAddress().getStreet());
		bad.setArea(cust.getShippingAddress().getArea());
		bad.setCity(cust.getShippingAddress().getCity());
		bad.setState(cust.getShippingAddress().getState());
		bad.setCountry(cust.getShippingAddress().getCountry());
		bad.setPincode(cust.getShippingAddress().getPincode());

		Cart crt = new Cart();

		cust.setBillingAddress(bad);
		cust.setCart(crt);

		String userid = customerService.addCustomer(cust);
		String message = "Signup is successfull.\nNew User id : " + userid;
		m.addAttribute("signupmsg", message);
		m.addAttribute("userObject", new UserDetails());
		return "loginpage";
	}

	@RequestMapping("/reqLoginPage")
	public String loginPage(UserDetails ud, Model m) {
		m.addAttribute("userObject", new UserDetails());
		return "loginpage";
	}

	@RequestMapping("/reqLoginCheck")
	public String loginCheck(@ModelAttribute("userObject") UserDetails ud, Model m, HttpSession hsession) {

		UserDetails temp = userDetailsService.loginCheck(ud);
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
			return "userHomepage1";
		} else {
			m.addAttribute("userid", temp.getUserid());

			return "adminHomePage";
		}
	}

	@RequestMapping("/reqDisplayProductsUser")
	public String displayProductsUser(Model m){
		List <VW_PROD_SUPP_XPS> productsuser = customerService.getProductsForUser();
		m.addAttribute("productsuser", productsuser);
		return "userHomepage1";
	}
	
	
	@RequestMapping("/reqProductAllSuppliers")
	public String getProductsAllSuppliers(@RequestParam("pid") String pid, Model m) {
		List<VW_PROD_SUPP_XPS> allSupProd = customerService.getAllSuppProd(pid);
		m.addAttribute("allSupProd", allSupProd);
		return "allProdSuppliers";

	}
	@RequestMapping("/reqLogout")
	public String logout(HttpSession hsession,Model m){
		hsession.invalidate();
		String logoutmessage = "Logged out successfully.\nThanks for visiting our site...";
		m.addAttribute("message", logoutmessage);
		return "index";

}
}