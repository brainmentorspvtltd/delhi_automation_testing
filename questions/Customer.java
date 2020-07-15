package questions;

import java.util.HashMap;
import java.util.HashSet;

public class Customer {
	private int id;
	private String name;
	private double balance;
	private HashMap<String, HashSet<Address>> addressMap = new HashMap<>();
	private HashMap<Integer, Order> orderMap  = new HashMap<>();
	
	public Customer(int id, String name, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public HashMap<String, HashSet<Address>> getAddressMap() {
		return addressMap;
	}
	public void setAddressMap(HashMap<String, HashSet<Address>> addressMap) {
		this.addressMap = addressMap;
	}
	public HashMap<Integer, Order> getOrderMap() {
		return orderMap;
	}
	public void setOrderMap(HashMap<Integer, Order> orderMap) {
		this.orderMap = orderMap;
	}
	
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", balance=" + balance + ", addressMap=" + addressMap
				+ ", orderMap=" + orderMap + "]";
	}
	
	

}
