package com.cognizant.truyum.model;

import java.util.Date;

/**
 * 
 * @author 877962
 *
 */
public class MenuItem {
	/**
	 * menu Item Id : Unique value
	 */
	private long id;
	/**
	 * Item name
	 */
	private String name;
	/**
	 * price of item
	 */
	private float price;
	/**
	 * Menu Item available or not
	 */
	private boolean active;
	/**
	 * Launch date
	 */
	private Date dateOfLaunch;
	/**
	 * category
	 */
	private String category;
	/**
	 * Free Delivery
	 */
	private boolean freeDelivery;

	/**
	 * 
	 * @param id
	 * @param name
	 * @param price
	 * @param active
	 * @param dateOfLaunch
	 * @param category
	 * @param freeDelivery
	 */
	public MenuItem(long id, String name, float price, boolean active, Date dateOfLaunch, String category,
			boolean freeDelivery) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.category = category;
		this.freeDelivery = freeDelivery;
	}

	/**
	 * Default constructor
	 */
	public MenuItem() {
		// TODO Auto-generated constructor stub
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isFreeDelivery() {
		return freeDelivery;
	}

	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", price=" + price + ", active=" + active + ", dateOfLaunch="
				+ dateOfLaunch + ", category=" + category + ", freeDelivery=" + freeDelivery + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (id != other.id)
			return false;
		return true;
	}

}