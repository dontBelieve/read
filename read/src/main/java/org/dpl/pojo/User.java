package org.dpl.pojo;

import org.springframework.stereotype.Service;

public class User {
	private String id;
	private String username;
	private String mobile;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "User{" + "id='" + id + '\'' + ", userName='" + username + '\'' + ", mobile='" + mobile + '\'' + '}';
	}
}