package com.srivastava.apps;

public class ItemDTO {
	
	private int id;
	private String name;
	private String desc;
	private double price;
	private String imageURL;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	@Override
	public String toString() {
		return "ItemDTO [id=" + id + ", name=" + name + ", desc=" + desc + ", price=" + price + ", imageURL=" + imageURL
				+ "]";
	}
	

}
