package com.brainmentors.cms.account;

class Product{
	private int id;
	private String name;
	private double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
}
public class ShopSearch {
	Product details(String productName) {
		Product p = new Product();
		p.setId(101);
		p.setName("IPhone");
		p.setPrice(90000);
		return p;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShopSearch shop = new ShopSearch();
		Product p1 = shop.details("Apple");
		System.out.println(p1);

	}

}
