package aashish.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductReview {
	@Id
	private String reviewid;
	private String orderhistoryid;	
	private String customerid;	
	private String productid;
	private float rating;
	private String comments;
	public String getReviewid() {
		return reviewid;
	}
	public void setReviewid(String reviewid) {
		this.reviewid = reviewid;
	}
	public String getOrderhistoryid() {
		return orderhistoryid;
	}
	public void setOrderhistoryid(String orderhistoryid) {
		this.orderhistoryid = orderhistoryid;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	

}
