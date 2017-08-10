package aashish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aashish.dao.CartItemDAOInt;
import aashish.model.CartItem;
@Service
public class CartItemServiceImpl implements CartItemServiceInt {

	@Autowired
	private CartItemDAOInt cartitemdao;

	public void addCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartitemdao.addCartItem(cartItem);

	}

	public CartItem getCartItem(String cartItemId) {
		// TODO Auto-generated method stub
		return cartitemdao.getCartItem(cartItemId);
	}

	public void removeCartItem(String cartItemId) {
		// TODO Auto-generated method stub
		cartitemdao.removeCartItem(cartItemId);

	}

	public void removeAllCartItems(String customerid) {
		// TODO Auto-generated method stub
		cartitemdao.removeAllCartItems(customerid);
		
	}

}
