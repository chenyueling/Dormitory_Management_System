package com.zhbit.form;

public class UpdatePersonalInfoForm {
	
	private String Home;
	private	String name;
	private	String phone;
	private	String sex;
	private String ownerId;
	
	
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getHome() {
		return Home;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getSex() {
		return sex;
	}
	public void setHome(String home) {
		Home = home;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
