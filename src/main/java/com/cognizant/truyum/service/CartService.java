package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

@Service("cartService")

/**
 * 
 * @author 877962
 *
 */
public class CartService {

	@Autowired
	/**
	 * object of cartdao collection implementation
	 */
	private CartDao cartDao;

	public CartDao getCartDao() {
		return cartDao;
	}

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	/**
	 * 
	 * @param userId
	 * @return
	 * @throws CartEmptyException
	 */
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		return cartDao.getAllCartItems(userId);

	}

	public void addCartItem(long userId, long menuItemId) {
		cartDao.addCartItem(userId, menuItemId);

	}

	public void removeCartItem(long userId, long menuItemId) {
		cartDao.removeCartItem(userId, menuItemId);

	}

}
