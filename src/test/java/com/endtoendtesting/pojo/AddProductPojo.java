package com.endtoendtesting.pojo;

public class AddProductPojo {
	
	private String username;
	private String password;
	private String product;
	
	
	public AddProductPojo(String username, String password, String product) {
		super();
		this.username = username;
		this.password = password;
		this.product = product;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "AddProductPojo [username=" + username + ", password=" + password + ", product=" + product + "]";
	}
	
	
	
	

}
