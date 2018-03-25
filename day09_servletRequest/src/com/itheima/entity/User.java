package com.itheima.entity;

import java.util.Arrays;

public class User {
	private String userName;
	private String pwd;
	private String sex;
	private String [] hobhy;
	private String city;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String[] getHobhy() {
		return hobhy;
	}
	public void setHobhy(String[] hobhy) {
		this.hobhy = hobhy;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", pwd=" + pwd + ", sex=" + sex
				+ ", hobhy=" + Arrays.toString(hobhy) + ", city=" + city + "]";
	}
	
}
