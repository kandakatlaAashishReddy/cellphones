package aashish.service;

import aashish.model.CartItem;

public interface CartItemServiceInt {
	public abstract void addCartItem(CartItem cartItem);
	public abstract CartItem getCartItem(String cartItemId);
	public abstract void removeCartItem(String cartItemId);
	public abstract void removeAllCartItems(String customerid);
}
