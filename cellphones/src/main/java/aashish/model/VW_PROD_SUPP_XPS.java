package aashish.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VW_PROD_SUPP_XPS {
	@Id
	private String psid;
	private String productid;
	private String productname;
	private String productdesc;
	private double rating;
	private int noitemssold;
	private int noreviews;
	private String supplierid;
	private String suppliername;
	private int productsupplierprice;
	private int productsupplierstock;
	public String getPsid() {
		return psid;
	}
	public void setPsid(String psid) {
		this.psid = psid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductdesc() {
		return productdesc;
	}
	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getNoitemssold() {
		return noitemssold;
	}
	public void setNoitemssold(int noitemssold) {
		this.noitemssold = noitemssold;
	}
	public int getNoreviews() {
		return noreviews;
	}
	public void setNoreviews(int noreviews) {
		this.noreviews = noreviews;
	}
	public String getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public int getProductsupplierprice() {
		return productsupplierprice;
	}
	public void setProductsupplierprice(int productsupplierprice) {
		this.productsupplierprice = productsupplierprice;
	}
	public int getProductsupplierstock() {
		return productsupplierstock;
	}
	public void setProductsupplierstock(int productsupplierstock) {
		this.productsupplierstock = productsupplierstock;
	}
	
	
	

}
