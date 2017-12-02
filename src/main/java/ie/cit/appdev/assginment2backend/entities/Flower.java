package ie.cit.appdev.assginment2backend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Flower {
	
	@Id
	private String id;
	private String name;
	private double price;
	private int quantity;
	
	
	
	
	public Flower(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Flower() {
	}

	public Flower(String id, String name, double price,int quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity=quantity;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
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
}