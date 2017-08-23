package aashish.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aashish.model.Cart;
import aashish.model.CartItem;
import aashish.model.Customer;
import aashish.model.VW_PROD_SUPP_XPS;
import aashish.model.XMAP_Product_Supplier;
import aashish.service.CartItemServiceInt;
import aashish.service.CartServiceInt;
import aashish.service.CustomerServiceInt;
import aashish.service.XpsServiceInt;

@Controller
public class CartController {
	
	@Autowired
	private XpsServiceInt xpsService;
	
	@Autowired
	private CartItemServiceInt cartItemService;
	
	@Autowired
	private CustomerServiceInt customerService;
	
	@Autowired
	private CartServiceInt cartService;

	/*@RequestMapping("/order/{cartId}")
	public String displayCheckOut(@PathVariable("cartId")String cartId){
		System.out.println("\nCartid in checkout : " + cartId);
		return "redirect:/checkout?cartId="+cartId;
	}*/
	
	@RequestMapping("/reqAddItemToCart/{productSupplierid}")
	public String addItemToCart(@PathVariable("productSupplierid")String productSupplierid, @RequestParam("quantity")int quantity,HttpSession hsession,Model m){
		System.out.println("psid : "+productSupplierid + "  quantity : " + quantity);
		Customer customer = (Customer)hsession.getAttribute("customerprofile");
		Cart cart = customer.getCart();
		XMAP_Product_Supplier xps = xpsService.getXpsById(productSupplierid);
		CartItem cartitem = new CartItem();
		cartitem.setCart(cart);
		cartitem.setXmap_product_supplier(xps);
		cartitem.setQuantity(quantity);
		cartitem.setItemwisetotal(xps.getProductsupplierprice()*quantity);
		
		cartItemService.addCartItem(cartitem);
		
		Customer customer1=customerService.getCustomerByUserId(customer.getUserDetails().getUserid());
		Cart cart1=customer1.getCart();		
		
		List<CartItem> cartitems = cart1.getCartItems();
		int sum=0;
		for(CartItem critem :cartitems){
			sum+= critem.getItemwisetotal();
		}
		cart1.setTotalbill(sum);
		cartService.updateCart(cart1);	
		hsession.setAttribute("customerprofile", customerService.getCustomerByID(customer1.getCustomerid()));
		// it is wrong- hsession.setAttribute("customerprofile", customerService.getCustomerByUserId(customer1.getCustomerid()));
		List <VW_PROD_SUPP_XPS> productsuser = customerService.getProductsForUser();	
		m.addAttribute("productsuser", productsuser);
		m.addAttribute("cartmessage","Item added to cart successfully..");
		return "userHomePage";
	}

	@RequestMapping("/reqDisplayCart")
	public String displayCart(HttpSession hsession,Model m){
		
		Customer customer = (Customer)hsession.getAttribute("customerprofile");
		Customer customer1 = customerService.getCustomerByID(customer.getCustomerid());
		Cart cart = customer1.getCart();	
		hsession.setAttribute("customerprofile",customer1);		
		
		List<CartItem> cartitems = cart.getCartItems();	
		int sum=0;
		for(CartItem cartitem :cartitems){
			sum+= cartitem.getItemwisetotal();
		}
		
		cart.setTotalbill(sum);
		cartService.updateCart(cart);			

		m.addAttribute("cartitems", cartitems);
		return "displayCartItems";
	}
	
	@RequestMapping("/reqDeleteCartItem/{cartitemid}")
	public String deleteCartItem(@PathVariable("cartitemid")String cartitemid,HttpSession hsession ){
		cartItemService.removeCartItem(cartitemid);		
		return "redirect:/reqDisplayCart";
	}
	

	@RequestMapping("/reqClearCart/{customerid}")
	public String deleteAllCartItems(@PathVariable("customerid")String customerid,HttpSession hsession){
		cartItemService.removeAllCartItems(customerid);		
		Customer customer = (Customer)hsession.getAttribute("customerprofile");
		customer.getCart().setTotalbill(0);
		cartService.updateCart(customer.getCart());
		hsession.setAttribute("customerprofile", customerService.getCustomerByID(customer.getCustomerid()));
		return "redirect:/reqDisplayProductsUser";
	}

}
