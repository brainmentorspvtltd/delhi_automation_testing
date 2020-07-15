package questions;

import java.util.ArrayList;

public class Order {
	private int id;
	private String name;
	private int qty;
	private int amount;
	private ArrayList<Product> productList = new ArrayList<>();
	
	public Order(int id, String name, int qty, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.qty = qty;
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public ArrayList<Product> getProductList() {
		return productList;
	}
	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", qty=" + qty + ", amount=" + amount + ", productList="
				+ productList + "]";
	}
	

}
