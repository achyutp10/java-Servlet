package models;

public class Cart {
	private String id;
	private String productId;
	private String product;
	private String user;

	public Cart(String id, String productId, String product, String user) {
	
		this.id = id;
		this.productId = productId;
		this.product = product;
		this.user = user;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	
}
