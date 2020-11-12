package com.cognizant.truyum.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
//import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

/**
 * 
 * @author 877962
 *
 */
public class MenuItemServiceTest {

	/**
	 * Menu Item service object
	 */
	private MenuItemService menuItemService;

	@Before
	public void initializeService() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.cognizant.truyum");
		ctx.refresh();
		menuItemService = (MenuItemService) ctx.getBean("menuItemService");
	}

	@Test
	/**
	 * test getMenuItemListAdmin() method
	 */
	public void testGetMenuItemListAdminSize() {

		assertEquals(5, menuItemService.getMenuItemListAdmin().size());

	}

	@Test
	/**
	 * test GetMenuItemListAdminContainsSandwich() method
	 */
	public void testGetMenuItemListAdminContainsSandwich() {
		List<MenuItem> menuItem = menuItemService.getMenuItemListAdmin().stream()
				.filter(e -> e.getName().equalsIgnoreCase("Sandwich")).collect(Collectors.toList());
		assertTrue(!menuItem.isEmpty());
	}

	@Test
	/**
	 * test GetMenuItemListAdminContainsBurger
	 */
	public void testGetMenuItemListAdminContainsBurger() {
		List<MenuItem> menuItem = menuItemService.getMenuItemListAdmin().stream()
				.filter(e -> e.getName().equalsIgnoreCase("Burger")).collect(Collectors.toList());
		assertTrue(!menuItem.isEmpty());
	}

	@Test
	/**
	 * test GetMenuItemListAdminContainsPizza
	 */
	public void testGetMenuItemListAdminContainsPizza() {
		List<MenuItem> menuItem = menuItemService.getMenuItemListAdmin().stream()
				.filter(e -> e.getName().equalsIgnoreCase("Pizza")).collect(Collectors.toList());
		assertTrue(!menuItem.isEmpty());
	}

	@Test
	/**
	 * test GetMenuItemListAdminContainsFries
	 */
	public void testGetMenuItemListAdminContainsFries() {
		List<MenuItem> menuItem = menuItemService.getMenuItemListAdmin().stream()
				.filter(e -> e.getName().equalsIgnoreCase("French Fries")).collect(Collectors.toList());
		assertTrue(!menuItem.isEmpty());
	}

	@Test
	/**
	 * test GetMenuItemListAdminContainsBrownies
	 */
	public void testGetMenuItemListAdminContainsBrownies() {
		List<MenuItem> menuItem = menuItemService.getMenuItemListAdmin().stream()
				.filter(e -> e.getName().equalsIgnoreCase("Chocolate Brownie")).collect(Collectors.toList());
		assertTrue(!menuItem.isEmpty());
	}

	@Test
	/**
	 * test GetMenuItemListCustomerSize
	 */
	public void testGetMenuItemListCustomerSize() {
		assertEquals(3, menuItemService.getMenuItemListCustomer().size());
	}

	@Test
	/**
	 * test GetMenuItemListCustomerNotContainsFrenchFries
	 */
	public void testGetMenuItemListCustomerNotContainsFrenchFries() {
		List<MenuItem> menuItem = menuItemService.getMenuItemListCustomer().stream()
				.filter(e -> e.getName().equalsIgnoreCase("French Fries")).collect(Collectors.toList());
		assertTrue(menuItem.isEmpty());
	}

	@Test
	/**
	 * test GetMenuItemListCustomerNotContainsChocolateBrownie
	 */
	public void testGetMenuItemListCustomerNotContainsChocolateBrownie() {
		List<MenuItem> menuItem = menuItemService.getMenuItemListCustomer().stream()
				.filter(e -> e.getName().equalsIgnoreCase("Chocolate Brownie")).collect(Collectors.toList());
		assertTrue(menuItem.isEmpty());
	}

	@Test
	/**
	 * test GetMenuItem
	 */
	public void testGetMenuItem() {
		assertEquals(2, menuItemService.getMenuItem(2).getId());

	}

	@Test
	/**
	 * test ModifyMenuItem
	 */
	public void testModifyMenuItem() {
		menuItemService.editMenuItem(
				new MenuItem(2, "Burger", 100.00f, true, DateUtil.convertToDate("15/03/2017"), "Main Course", true));
		MenuItem menuItem = menuItemService.getMenuItem(2);
		// assertEquals(2,menuItem.getId());
		assertEquals("Burger", menuItem.getName());
		assertTrue(100.00f == menuItem.getPrice());
		assertEquals(true, menuItem.isActive());
		assertTrue(DateUtil.convertToDate("15/03/2017").compareTo(menuItem.getDateOfLaunch()) == 0);
		assertEquals("Main Course", menuItem.getCategory());
		assertEquals(true, menuItem.isFreeDelivery());
	}

}
