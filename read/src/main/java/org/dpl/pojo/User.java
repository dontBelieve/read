package org.dpl.pojo;

public class User {
	private String id;
	private String userName;
	private String mobile;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "User{" + "id='" + id + '\'' + ", userName='" + userName + '\'' + ", mobile='" + mobile + '\'' + '}';
	}
}