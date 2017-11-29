package ie.cit.appdev.assginment2backend.entities;

import java.util.ArrayList;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {
	@Id 
	private String id;
	private int florestId;
	private String florestName;
	private ArrayList<Flower> contents;
	private double cost;
	
	
	
	public Order(int florestId, String florestName, ArrayList<Flower> contents, double cost) {
		this.florestId = florestId;
		this.florestName = florestName;
		this.contents = contents;
		this.cost = cost;
	}
	public Order() {
	}
	public Order(String id,int florestId, String florestName, ArrayList<Flower> contents, double cost) {
		this.id = id;
		this.florestId=florestId;
		this.florestName = florestName;
		this.contents = contents;
		this.cost = cost;
	}
	
	public int getFlorestId() {
		return florestId;
	}
	public void setFlorestId(int florestId) {
		this.florestId = florestId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFlorestName() {
		return florestName;
	}
	public void setFlorestName(String florestName) {
		this.florestName = florestName;
	}
	public ArrayList<Flower> getContents() {
		return contents;
	}
	public void setContents(ArrayList<Flower> contents) {
		this.contents = contents;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	
}
