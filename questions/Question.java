package questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Question {

	public static void main(String[] args) {
		// Fill
		HashMap<String, Customer> customerMap = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Range of the Customers");
		int n = scanner.nextInt();
		for(int i = 1;i<=n; i++) {
			Customer customer = new Customer(i, "ram"+i,9000*i);
			customerMap.put(customer.getName(), customer);
			
		}
		Address address1 = new Address("delhi","India","110007");
		Address address2 = new Address("delhi","India","110007");
		Address address3 = new Address("mumbai","India","220007");
		HashSet<Address> home = new HashSet<>();
		home.add(address1);
		home.add(address2);
		home.add(address3);
		Address address4 = new Address("delhi","India","110005");
		Address address5 = new Address("delhi","India","110005");
		Address address6 = new Address("mumbai","India","220009");
		HashSet<Address> office = new HashSet<>();
		office.add(address4);
		office.add(address5);
		office.add(address6);
		HashMap<String, HashSet<Address>> addressMap = 
				new HashMap<>();
		addressMap.put("home", home);
		addressMap.put("office", office);
		Order order = new Order(1001, "Order1",3,300);
		ArrayList<Product> productList =new ArrayList<>();
		for(int i = 1; i<=n; i++) {
			productList.add(new Product(i, "P"+i,10000*i));
		}
		order.setProductList(productList);
		Collections.sort(productList,(first, second)->(int)(second.getPrice() - first.getPrice()));
		HashMap<Integer, Order> orderMap= new HashMap<>();
		orderMap.put(order.getId(), order);
		for(int i = 1;i<=n; i++) {
			customerMap.get("ram"+i).setAddressMap(addressMap);
			customerMap.get("ram"+i).setOrderMap(orderMap);
			//Customer customer = new Customer(i, "ram"+i,9000*i);
			//customerMap.put(customer.getName(), customer);
			
		}
		System.out.println("Enter the Name to Search");
		String name = scanner.next();
		if(customerMap.get(name)==null) {
			System.out.println("Not Found...");
		}
		else {
			Customer customer = customerMap.get(name);
			System.out.println(customer.getName()+" "+customer.getBalance());
			System.out.println("Office / Home");
			String type = scanner.next();
			HashSet<Address> address = customer.getAddressMap().get(type);
			System.out.println(address);
			System.out.println("Enter the Order Id ");
			int oid = scanner.nextInt();
			System.out.println(orderMap.get(oid)==null?"Not Found ":orderMap.get(oid));
		}
		

	}

}
