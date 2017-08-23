package aashish.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;
@Entity
public class Customer implements Serializable{
	@Id
private String customerid;
	
@NotEmpty(message="Customer Name can not be empty")
private String customername;
@NotEmpty(message="Customer mailid can not be empty")
private String mailid;
@NotEmpty(message="Customer mobileno can not be empty")
private String mobileno;
private boolean enabled;
@Transient
private MultipartFile customerImage;

@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="userid")
private UserDetails userDetails;



@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="billingaddressid")
private BillingAddress billingAddress;



@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="shippingaddressid")
private ShippingAddress shippingAddress;

@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="cartid")
private Cart cart;


@OneToMany(mappedBy="customer",cascade=CascadeType.REFRESH,fetch=FetchType.LAZY)

private List<CustomerOrder>customerorders;



public boolean isEnabled() {
	return enabled;
}

public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}

public List<CustomerOrder> getCustomerorders() {
	return customerorders;
}

public void setCustomerorders(List<CustomerOrder> customerorders) {
	this.customerorders = customerorders;
}

public String getCustomerid() {
	return customerid;
}

public void setCustomerid(String customerid) {
	this.customerid = customerid;
}

public String getCustomername() {
	return customername;
}

public void setCustomername(String customername) {
	this.customername = customername;
}

public String getMailid() {
	return mailid;
}

public void setMailid(String mailid) {
	this.mailid = mailid;
}

public String getMobileno() {
	return mobileno;
}

public void setMobileno(String mobileno) {
	this.mobileno = mobileno;
}

public MultipartFile getCustomerImage() {
	return customerImage;
}

public void setCustomerImage(MultipartFile customerImage) {
	this.customerImage = customerImage;
}

public UserDetails getUserDetails() {
	return userDetails;
}

public void setUserDetails(UserDetails userDetails) {
	this.userDetails = userDetails;
}

public BillingAddress getBillingAddress() {
	return billingAddress;
}

public void setBillingAddress(BillingAddress billingAddress) {
	this.billingAddress = billingAddress;
}

public ShippingAddress getShippingAddress() {
	return shippingAddress;
}

public void setShippingAddress(ShippingAddress shippingAddress) {
	this.shippingAddress = shippingAddress;
}

public Cart getCart() {
	return cart;
}

public void setCart(Cart cart) {
	this.cart = cart;
}


}

