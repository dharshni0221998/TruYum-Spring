package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;
/**
 * 
 * @author 877962
 *
 */
public interface MenuItemDao {

	/**
	 * 
	 * @return menuList Item
	 */
	 List<MenuItem> getMenuItemListAdmin();

	/**
	 * 
	 * @return menuList Item
	 */
	 List<MenuItem> getMenuItemListCustomer();

	/**
	 * 
	 * @param menuItem
	 */
	 void modifyMenuItem(MenuItem menuItem);

	/**
	 * 
	 * @param menuItemId
	 * @return menu Item
	 */
	 MenuItem getMenuItem(long menuItemId);

}