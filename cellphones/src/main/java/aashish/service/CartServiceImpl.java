package aashish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aashish.dao.CartDAOInt;
import aashish.model.Cart;
@Service
public class CartServiceImpl implements CartServiceInt {
	@Autowired
	private CartDAOInt cartDao;

	public Cart getCart(String cartid) {
		// TODO Auto-generated method stub
		return cartDao.getCart(cartid);
	}

	public int getCartSize(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.getCartSize(cart);

	}

	public void updateCart(Cart cart) {
		// TODO Auto-generated method stub
		cartDao.updateCart(cart);

	}

}
