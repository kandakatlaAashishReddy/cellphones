package aashish.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Cart {
	@Id
private String cartid;
private double totalbill;


@OneToOne(mappedBy="cart")
private Customer customer;


@OneToMany(mappedBy="cart",cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
private List<CartItem>cartItems;




public String getCartid() {
	return cartid;
}


public void setCartid(String cartid) {
	this.cartid = cartid;
}


public double getTotalbill() {
	return totalbill;
}


public void setTotalbill(double totalbill) {
	this.totalbill = totalbill;
}


public List<CartItem> getCartItems() {
	return cartItems;
}


public void setCartItems(List<CartItem> cartItems) {
	this.cartItems = cartItems;
}


public Customer getCustomer() {
	return customer;
}


public void setCustomer(Customer customer) {
	this.customer = customer;
}




}
