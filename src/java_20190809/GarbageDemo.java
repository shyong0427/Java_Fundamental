package java_20190809;

import java.io.IOException;
import java.util.ArrayList;

public class GarbageDemo {
	public static void main(String[] args) throws IOException {
		// Dao (Data Access Object)
		CustomerDao cdao = new CustomerDao();
		
		Customer[] customers = cdao.getCustomers();
		for (Customer customer : customers) {
			System.out.println(customer.getName());
		}
	}
}

class Customer {
	String name;
	Customer(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}

class CustomerDao{
	public Customer[] getCustomers() {
		Customer[] cs = new Customer[10];
		Customer c1 = new Customer("1");
		Customer c2 = new Customer("2");
		Customer c3 = new Customer("3");
		Customer c4 = new Customer("4");
		Customer c5 = new Customer("5");
		Customer c6 = new Customer("6");
		Customer c7 = new Customer("7");
		Customer c8 = new Customer("8");
		Customer c9 = new Customer("9");
		Customer c10 = new Customer("10");
		
		cs[0] = new Customer("1");
		cs[1] = new Customer("2");
		cs[2] = new Customer("3");
		cs[3] = new Customer("4");
		cs[4] = new Customer("5");
		cs[5] = new Customer("6");
		cs[6] = new Customer("7");
		cs[7] = new Customer("8");
		cs[8] = new Customer("9");
		cs[9] = new Customer("10");
		
		return cs;
	}
	
	public ArrayList<Customer> getCustomer(){
		ArrayList<Customer> list = new ArrayList<Customer>();
		list.add(new Customer("1"));
		list.add(new Customer("2"));
		list.add(new Customer("3"));
		list.add(new Customer("4"));
		list.add(new Customer("5"));
		list.add(new Customer("6"));
		list.add(new Customer("7"));
		list.add(new Customer("8"));
		list.add(new Customer("9"));
		list.add(new Customer("10"));		
	}
}