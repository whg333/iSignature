package com.whg.iSignature.bo;

public class User {

	private String name;
	private String address;
	private String mobile;
	private long money;
	
	@Override
	public String toString() {
		return "User [name=" + name + ", address=" + address + ", mobile=" + mobile + ", money=" + money + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
	}
	
}
