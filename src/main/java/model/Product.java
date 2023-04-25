package model;

public class Product {
	
	private int idProduct;
	private String description;
	private int quantity;
	private double price;
	private boolean onLine;
	
	public Product() {}
	
	public Product(String description, int quantity, double price, boolean onLine) {
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.onLine = onLine;
	}
	
	public Product(int idProduct, String description, int quantity, double price, boolean onLine) {
		this.idProduct = idProduct;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.onLine = onLine;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isOnLine() {
		return onLine;
	}

	public void setOnLine(boolean onLine) {
		this.onLine = onLine;
	}


}
