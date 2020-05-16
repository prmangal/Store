package model.vendor;

import java.util.Arrays;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Vendor {
	@Id
	private Integer id;
	private String name;
	private HashMap<Integer,Double> products;
	public Vendor() {
	}
	public Vendor(Integer id, String name, HashMap<Integer, Double> products) {
		super();
		this.id = id;
		this.name = name;
		this.products = products;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<Integer, Double> getProducts() {
		return products;
	}
	public void setProducts(HashMap<Integer, Double> products) {
		this.products = products;
	}
	
	
}
