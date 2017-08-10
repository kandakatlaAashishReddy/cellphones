package aashish.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import aashish.model.Cart;
import aashish.model.CartItem;
@Repository
public class CartDAOImpl implements CartDAOInt {
	@Autowired
	private SessionFactory sessionFactory;

	public Cart getCart(String cartid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Cart cart=(Cart)session.get(Cart.class, cartid);
		System.out.println("cart : " + cart);
		session.close();
		return cart;
	}

	public int getCartSize(Cart cart) {
		// TODO Auto-generated method stub
		List<CartItem> cartitems = cart.getCartItems();
		return cartitems.size();
	}

	public void updateCart(Cart cart) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.update(cart);
		session.flush();
		session.close();
	}

}
