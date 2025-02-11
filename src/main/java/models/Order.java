package models;

public class Order {
	private String orderId;
	private String product;
	private String price;
	private String quantity;
	private String user;
	public Order(String orderId, String product, String price, String quantity, String user) {
		super();
		this.orderId = orderId;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
		this.user = user;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
}
