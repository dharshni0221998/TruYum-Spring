package com.cognizant.truyum;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;
import com.cognizant.truyum.service.MenuItemService;
import com.cognizant.truyum.util.DateUtil;

/**
 * 
 * @author 877962
 *
 */
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		MenuItemService service = (MenuItemService) ctx.getBean("menuItemService");
		System.out.println("====Admin Menu Item List====");
		List<MenuItem> menuItemListAdmin = service.getMenuItemListAdmin();
		for (MenuItem item : menuItemListAdmin) {
			System.out.println(item);
		}
		System.out.println("====Customer Menu Item List====");
		List<MenuItem> menuItemListCustomer = service.getMenuItemListCustomer();
		for (MenuItem item : menuItemListCustomer) {
			System.out.println(item);
		}

		System.out.println("===Get Menu Item===");
		System.out.println(service.getMenuItem(2));
		System.out.println("===Modify Menu Item===");
		service.editMenuItem(
				new MenuItem(1, "Sandwich", 100.00f, true, DateUtil.convertToDate("15/03/2017"), "Main Course", true));
		System.out.println("===Get Menu Item===");
		System.out.println(service.getMenuItem(1));

		CartService cService = (CartService) ctx.getBean("cartService");
		try {

			System.out.println(cService.getAllCartItems(10));
		} catch (CartEmptyException e1) {
			// TODO Auto-generated catch block

		}
		cService.addCartItem(100, 1);
		cService.addCartItem(100, 2);
		cService.addCartItem(101, 2);
		System.out.println("===Items Added to Cart===");
		try {
			List<MenuItem> cartList = cService.getAllCartItems(100);
			System.out.println("Items in Cart");
			for (MenuItem item : cartList) {
				System.out.println(item);
			}
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block

		}
		cService.removeCartItem(100, 2);
		System.out.println("===Item Removed===");
		try {
			List<MenuItem> cartList = cService.getAllCartItems(100);
			System.out.println("Items in Cart");
			for (MenuItem item : cartList) {
				System.out.println(item);
			}
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block

		}
	}

}
