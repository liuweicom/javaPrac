package com.weiwei.mybatis.pojo;

import java.util.List;

public class UserQueryVo {
	private UserCustomer userCustomer;
	private List<Integer> ids;
	public UserCustomer getUserCustomer() {
		return userCustomer;
	}
	public void setUserCustomer(UserCustomer userCustomer) {
		this.userCustomer = userCustomer;
	}
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	
}
