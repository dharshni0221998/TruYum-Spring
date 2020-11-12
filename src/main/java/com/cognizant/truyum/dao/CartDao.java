package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;
/**
 * 
 * @author 877962
 *
 */
public interface CartDao {
	/**
	 * 
	 * @param userId
	 * @param menuItemId
	 */
	void addCartItem(long userId, long menuItemId);
    /**
     * 
     * @param userId
     * @return List items in user cart
     * @throws CartEmptyException
     */
	 List<MenuItem> getAllCartItems(long userId) throws CartEmptyException;
	 /**
	  * 
	  * @param userId
	  * @param menuItemId
	  */
	 void removeCartItem(long userId, long menuItemId);

}