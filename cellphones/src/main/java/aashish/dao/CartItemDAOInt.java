package aashish.dao;

import aashish.model.CartItem;

public interface CartItemDAOInt {
	public abstract void addCartItem(CartItem cartItem);
	public abstract CartItem getCartItem(String cartItemId);
	public abstract void removeCartItem(String cartItemId);
	public abstract void removeAllCartItems(String customerid);

}
