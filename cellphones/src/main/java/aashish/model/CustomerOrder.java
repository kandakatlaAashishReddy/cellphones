package aashish.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class CustomerOrder {
@Id
	private String orderId;


@ManyToOne
@JoinColumn(name="customerid")
private Customer customer;


@OneToMany(mappedBy="customerOrder",cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
private List<CustomerOrderHistory>customerOrdersHistory;

public String getOrderId() {
	return orderId;
}


public void setOrderId(String orderId) {
	this.orderId = orderId;
}


public Customer getCustomer() {
	return customer;
}


public void setCustomer(Customer customer) {
	this.customer = customer;
}


public List<CustomerOrderHistory> getCustomerOrdersHistory() {
	return customerOrdersHistory;
}


public void setCustomerOrdersHistory(List<CustomerOrderHistory> customerOrdersHistory) {
	this.customerOrdersHistory = customerOrdersHistory;
}


}
