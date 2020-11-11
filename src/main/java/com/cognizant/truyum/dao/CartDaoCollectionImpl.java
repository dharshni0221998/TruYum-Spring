package com.cognizant.truyum.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao{
	private  HashMap<Long,Cart> userCarts;
	
	public HashMap<Long, Cart> getUserCarts() {
		return userCarts;
	}
	public void setUserCarts(HashMap<Long, Cart> userCarts) {
		this.userCarts = userCarts;
	}
	public CartDaoCollectionImpl(){
		super();
		
	}
	public void addCartItem(long userId,long menuItemId){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		MenuItemDao menuItemDao =(MenuItemDao) ctx.getBean("menuDao");
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
		boolean set =false;
		if(!userCarts.isEmpty()){
		for(Entry<Long, Cart> e:userCarts.entrySet()){
			if(e.getKey()==userId){
				e.getValue().getMenuItemList().add(menuItem);
				set = true;
				break;
			}
			
		}
		}
		if(!set){
			List<MenuItem> menuItemList = new ArrayList<MenuItem>();
			//double total;
			menuItemList.add(menuItem);
			//total=menuItem.getPrice();
			userCarts.put(userId, new Cart(menuItemList,0));
		}
		
		
	}
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException{
		List<MenuItem> menuListItem=new ArrayList<MenuItem>();
		for(Entry<Long,Cart> e: userCarts.entrySet()){
			if(e.getKey()==userId){
				if(e.getValue().getMenuItemList().isEmpty()){
					throw new CartEmptyException();
				}
				else{
					double total=0;
					menuListItem = e.getValue().getMenuItemList();
					for(MenuItem m:menuListItem){
						total+=m.getPrice();
					}
					e.getValue().setTotal(total);
					//System.out.println(e.getValue().getTotal());
				}
				return e.getValue().getMenuItemList();
			}
		}
		return null;
		
	}
	public void removeCartItem(long userId,long menuItemId){
		
		List<MenuItem> menuListItem=new ArrayList<MenuItem>();
		for(Entry<Long,Cart>e:userCarts.entrySet()){
			if(e.getKey()==userId){
				menuListItem = e.getValue().getMenuItemList();
				for(int i=0;i<menuListItem.size();i++){
					if(menuListItem.get(i).getId()==menuItemId){
						menuListItem.remove(i);
					}
				}
				
			}
		}
		
		
		
	}
}