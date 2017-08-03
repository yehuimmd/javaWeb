package com.tedu.entity;

public class userInfo {
    private String id;
    private String user;
    private String password;
    private String phone;
    private String identity;
    
    
	@Override
	public String toString() {
		return "userInfo [id=" + id + ", user=" + user + ", password="
				+ password + ", phone=" + phone + ", identity=" + identity
				+ "]";
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getIdentity() {
		return identity;
	}


	public void setIdentity(String identity) {
		this.identity = identity;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
