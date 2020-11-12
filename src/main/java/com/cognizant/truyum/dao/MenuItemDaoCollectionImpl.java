package com.cognizant.truyum.dao;

import java.util.Date;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;

/**
 * 
 * @author 877962
 *
 */
@Component
@ImportResource("classpath:spring-config.xml")
public class MenuItemDaoCollectionImpl implements MenuItemDao {
	/**
	 * List of Menu Item
	 */
	@Autowired
	private List<MenuItem> menuItemList;

	/**
	 * Default Constructor
	 */
	public MenuItemDaoCollectionImpl() {
		super();
	}

	public MenuItemDaoCollectionImpl(final List<MenuItem> menuItemList) {
        super();
        this.menuItemList = menuItemList;
    }
	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	/**
	 * list the menu Iteam for admin
	 */
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;

	}

	/**
	 * list the menu Iteam for customer
	 */
	public List<MenuItem> getMenuItemListCustomer() {

		return menuItemList.stream()
				.filter(e -> (e.getDateOfLaunch().before(new Date()) || e.getDateOfLaunch().compareTo(new Date()) == 0)
						&& (e.isActive()))
				.collect(Collectors.toList());

	}

	/**
	 * Modify the menuItem
	 */
	public void modifyMenuItem(MenuItem menuItem) {
		for (MenuItem e : menuItemList) {
			if (e.equals(menuItem)) {
				e.setActive(menuItem.isActive());
				e.setCategory(menuItem.getCategory());
				e.setDateOfLaunch(menuItem.getDateOfLaunch());
				e.setFreeDelivery(menuItem.isFreeDelivery());
				e.setId(menuItem.getId());
				e.setName(menuItem.getName());
				e.setPrice(menuItem.getPrice());
			}
		}

	}

	/**
	 * get menuItem corresponding to menuItem Id
	 */
	public MenuItem getMenuItem(long menuItemId) {
		for (MenuItem e : menuItemList) {
			if (e.getId() == menuItemId) {
				return e;
			}
		}
		return null;

	}

}