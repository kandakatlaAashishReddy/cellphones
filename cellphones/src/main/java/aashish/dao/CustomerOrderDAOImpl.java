package aashish.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import aashish.model.Cart;
import aashish.model.CartItem;
import aashish.model.Customer;
import aashish.model.CustomerOrder;
import aashish.model.CustomerOrderHistory;
import aashish.model.Product;
import aashish.model.ProductReview;
import aashish.model.Vw_Cust_Rating;
import aashish.model.XMAP_Product_Supplier;

@Repository
public class CustomerOrderDAOImpl implements CustomerOrderDAOInt {

	@Autowired
	private SessionFactory sessionFactory;

	public void addCustomerOrder(Cart cart) {// throws MessagingException {
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setOrderId(generateOrderId());
		// customerOrder.setCart(cart);
		customerOrder.setCustomer(cart.getCustomer());
		// customerOrder.setBillingAddress(cart.getCustomer().getBillingAddress());
		// customerOrder.setShippingAddress(cart.getCustomer().getShippingAddress());
		// customerOrder.setCustid(cart.getCustomer().getCustomerid());
		String shipadd = cart.getCustomer().getShippingAddress().getHouseno();
		shipadd += "\n" + cart.getCustomer().getShippingAddress().getStreet();
		shipadd += "\n" + cart.getCustomer().getShippingAddress().getArea();
		shipadd += "\n" + cart.getCustomer().getShippingAddress().getCity();
		shipadd += "\n" + cart.getCustomer().getShippingAddress().getState();

		// customerOrder.setShippedaddress(shipadd);

		Date date = new Date();
		customerOrder.setOrderDate(date);
		// Insert the data in CustomerOrder table
		Session session = sessionFactory.openSession();
		session.save(customerOrder);
		session.flush();
		session.close();
		// To update grandtotal in Cart table

		List<CartItem> cartItems = cart.getCartItems();

		Session soh = sessionFactory.openSession();
		Product prd;
		for (CartItem cartItem : cartItems) {
			CustomerOrderHistory orderHistory = new CustomerOrderHistory();
			orderHistory.setOrderhistoryid(generateOrderHistoryId());
			orderHistory.setCustomerOrder(customerOrder);
			orderHistory.setPrice(cartItem.getXmap_product_supplier().getProductsupplierprice());
			orderHistory.setProductid(cartItem.getXmap_product_supplier().getProductid());
			orderHistory.setSupplierid(cartItem.getXmap_product_supplier().getSupplierid());
			orderHistory.setQuantity(cartItem.getQuantity());
			orderHistory.setTotal(cartItem.getItemwisetotal());
			orderHistory.setReviewgiven(false);
			orderHistory.setCustomerid(customerOrder.getCustomer().getCustomerid());
			orderHistory.setRating((float) 0.0);
			orderHistory.setComments("NA");

			soh.save(orderHistory);
			soh.flush();
			XMAP_Product_Supplier xps = cartItem.getXmap_product_supplier();
			xps.setProductsupplierstock(xps.getProductsupplierstock() - cartItem.getQuantity());
			soh.update(xps);
			soh.flush();

			prd = soh.get(Product.class, xps.getProductid());
			prd.setNoitemssold(cartItem.getQuantity());
			soh.update(prd);
			soh.flush();

		}

		soh.close();

		Session soc = sessionFactory.openSession();
		cart.setTotalbill(0.0);
		soc.update(cart);
		soc.flush();
		soc.close();

		// Customer customer = cart.getCustomer();

	}

	public List<CustomerOrder> custOrders(String custid) {
		// String hq = "from CustomerOrder co "
		// TODO Auto-generated method stub
		String hq = "from CustomerOrder where customerid='" + custid + "'";
		Session ses = sessionFactory.openSession();
		Query qr = ses.createQuery(hq);
		List<CustomerOrder> orders = qr.list();
		ses.close();
		return orders;
	}

	public float getRating(String productid) {
		Session ses = sessionFactory.openSession();
		Query qr = ses.createQuery(
				"select count(orderhistoryid) from CustomerOrderHistory where productid=? and reviewgiven=true");
		qr.setParameter(0, productid);
		int recs = Integer.parseInt(qr.uniqueResult().toString());
		ses.flush();
		Query qr1 = ses
				.createQuery("select sum(rating) from CustomerOrderHistory where productid=? and reviewgiven=true");
		qr1.setParameter(0, productid);
		float total = Float.parseFloat(qr1.uniqueResult().toString());

		ses.close();
		float avgRating = (float) total / recs;
		return avgRating;
	}

	public int getNoOfReviews(String productid) {
		Session ses = sessionFactory.openSession();
		Query qr = ses.createQuery("select count(reviewid) from ProductReview where productid=?");
		qr.setParameter(0, productid);
		int recs = Integer.parseInt(qr.uniqueResult().toString());
		ses.close();
		return recs;
	}

	public int getNoOfItemsSold(String productid) {
		Session ses = sessionFactory.openSession();
		Query qr = ses.createQuery("select count(quantity) from CustomerOrderHistory where productid=?");
		qr.setParameter(0, productid);
		int recs = Integer.parseInt(qr.uniqueResult().toString());
		ses.close();
		return recs;
	}

	public CustomerOrderHistory getCustomerOrderHistoryByOrderHistoryId(String ordhistid) {
		CustomerOrderHistory temp = sessionFactory.openSession().get(CustomerOrderHistory.class, ordhistid);
		return temp;
	}

	public void updateOrderHistory(CustomerOrderHistory coh) {
		Session ses = sessionFactory.openSession();
		ses.update(coh);
		ses.flush();
		ses.close();
	}

	private String generateOrderId() {

		String newOid = "";

		Session s = sessionFactory.openSession();
		Query qr = s.createQuery("from CustomerOrder");
		List<Product> data = qr.list();
		s.close();
		if (data.size() == 0) {
			newOid = "ORD00001";
		} else {
			Session ss = sessionFactory.openSession();
			Query q = ss.createQuery("select max(orderId) from CustomerOrder");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : " + prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : " + id);
			id = id + 1;
			if (id <= 9)
				newOid = "ORD0000" + id;
			else if (id <= 99)
				newOid = "ORD000" + id;
			else if (id <= 999)
				newOid = "ORD00" + id;
			else if (id <= 9999)
				newOid = "ORD0" + id;
			else
				newOid = "ORD" + id;
			System.out.print("\nGenerated : " + newOid);
			ss.close();
		}
		return newOid;
	}

	private String generateOrderHistoryId() {

		String newOHid = "";

		Session s = sessionFactory.openSession();
		Query qr = s.createQuery("from CustomerOrderHistory");
		List<Product> data = qr.list();
		s.close();
		if (data.size() == 0) {
			newOHid = "ORDH00001";
		} else {
			Session ss = sessionFactory.openSession();
			Query q = ss.createQuery("select max(orderhistoryid) from CustomerOrderHistory");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : " + prevId);
			int id = Integer.parseInt(prevId.substring(4));
			System.out.print("\nExisting id : " + id);
			id = id + 1;
			if (id <= 9)
				newOHid = "ORDH0000" + id;
			else if (id <= 99)
				newOHid = "ORDH000" + id;
			else if (id <= 999)
				newOHid = "ORDH00" + id;
			else if (id <= 9999)
				newOHid = "ORDH0" + id;
			else
				newOHid = "ORDH" + id;
			System.out.print("\nGenerated : " + newOHid);
			ss.close();
		}
		return newOHid;
	}

	private String generateProductReviewId() {

		String newPRid = "";

		Session s = sessionFactory.openSession();
		Query qr = s.createQuery("from ProductReview");
		List<Product> data = qr.list();
		s.close();
		if (data.size() == 0) {
			newPRid = "PREV00001";
		} else {
			Session ss = sessionFactory.openSession();
			Query q = ss.createQuery("select max(reviewid) from ProductReview");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : " + prevId);
			int id = Integer.parseInt(prevId.substring(4));
			System.out.print("\nExisting id : " + id);
			id = id + 1;
			if (id <= 9)
				newPRid = "PREV0000" + id;
			else if (id <= 99)
				newPRid = "PREV000" + id;
			else if (id <= 999)
				newPRid = "PREV00" + id;
			else if (id <= 9999)
				newPRid = "PREV0" + id;
			else
				newPRid = "PREV" + id;
			System.out.print("\nGenerated : " + newPRid);
			ss.close();
		}
		return newPRid;
	}

	public void addProductReview(ProductReview pr) {
		// TODO Auto-generated method stub
		Session ses = sessionFactory.openSession();
		pr.setReviewid(generateProductReviewId());
		ses.save(pr);
		ses.flush();
		CustomerOrderHistory hist = ses.get(CustomerOrderHistory.class, pr.getOrderhistoryid());
		hist.setComments(pr.getComments());
		hist.setRating(pr.getRating());
		hist.setReviewgiven(true);
		ses.update(hist);
		ses.flush();
		ses.close();
	}

	public List<Vw_Cust_Rating> getCommentsForProduct(String productid) {
		// TODO Auto-generated method stub
		Session ses = sessionFactory.openSession();
		Query qr = ses.createQuery("from Vw_Cust_Rating where productid=?");
		qr.setParameter(0, productid);
		List<Vw_Cust_Rating> data = qr.list();
		ses.flush();
		ses.close();
		return data;
	}

}
