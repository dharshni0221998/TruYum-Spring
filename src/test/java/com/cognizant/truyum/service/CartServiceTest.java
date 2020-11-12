package com.cognizant.truyum.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

public class CartServiceTest {

	private CartService cartService;

	@Before
	public void initializeService() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.cognizant.truyum");
		ctx.refresh();
		cartService = (CartService) ctx.getBean("cartService");
	}

	@Test(expected = CartEmptyException.class)
	public void testGetAllCartItemsThrowsException() throws CartEmptyException {
		cartService.addCartItem(102, 1);
		cartService.removeCartItem(102, 1);
		cartService.getAllCartItems(102);
	}

	@Test
	public void testAddCartItem() {
		 cartService.addCartItem(102, 2);
		 try {
			List<MenuItem> cartItem = cartService.getAllCartItems(102).stream().filter(e->e.getId()==2).collect(Collectors.toList());
		    assertFalse(cartItem.isEmpty());   
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Test
	public void testRemoveCartItem() {
		cartService.addCartItem(102, 1);
		cartService.addCartItem(102, 2);
		cartService.removeCartItem(102, 1);
		List<MenuItem> cartItem;
		try {
			cartItem = cartService.getAllCartItems(102).stream().filter(e->e.getId()==1).collect(Collectors.toList());
			assertTrue(cartItem.isEmpty()); 
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	}

}
