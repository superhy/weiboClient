package org.superhy.weibo.httpclient;

public class WeiBoUser {

	private String userName;
	private String userPass;
	private String displayName;

	public WeiBoUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WeiBoUser(String userName, String userPass, String displayName) {
		super();
		this.userName = userName;
		this.userPass = userPass;
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	@Override
	public String toString() {
		return "WeiBoUser [userName=" + userName + ", userPass=" + userPass
				+ ", displayName=" + displayName + "]";
	}

}
