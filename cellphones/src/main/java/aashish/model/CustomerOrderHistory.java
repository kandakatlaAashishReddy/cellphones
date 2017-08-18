package aashish.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class CustomerOrderHistory {
	@Id
private String orderhistoryid;
private String productid;
private String supplierid;
private int price;
private int  quantity;
private int  total;
private String customerid;
private boolean reviewgiven;
private float rating;
private String Comments;

@ManyToOne
@JoinColumn(name="orderId")
private CustomerOrder customerOrder;


public String getOrderhistoryid() {
	return orderhistoryid;
}

public void setOrderhistoryid(String orderhistoryid) {
	this.orderhistoryid = orderhistoryid;
}

public String getProductid() {
	return productid;
}

public void setProductid(String productid) {
	this.productid = productid;
}

public String getSupplierid() {
	return supplierid;
}

public void setSupplierid(String supplierid) {
	this.supplierid = supplierid;
}





public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public int getTotal() {
	return total;
}

public void setTotal(int total) {
	this.total = total;
}

public String getCustomerid() {
	return customerid;
}

public void setCustomerid(String customerid) {
	this.customerid = customerid;
}

public boolean isReviewgiven() {
	return reviewgiven;
}

public void setReviewgiven(boolean reviewgiven) {
	this.reviewgiven = reviewgiven;
}

public float getRating() {
	return rating;
}

public void setRating(float rating) {
	this.rating = rating;
}

public String getComments() {
	return Comments;
}

public void setComments(String comments) {
	Comments = comments;
}

public CustomerOrder getCustomerOrder() {
	return customerOrder;
}

public void setCustomerOrder(CustomerOrder customerOrder) {
	this.customerOrder = customerOrder;
}

}
