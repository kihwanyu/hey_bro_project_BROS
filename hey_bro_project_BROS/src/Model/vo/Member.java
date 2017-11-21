package Model.vo;

public class Member {
	private String userId;
	private String userPw;
	private String userName;
	private String birthday;
	private String phone;
	private String email;
	
	public Member() {
		super();
	}

	public Member(String userId, String userPw, String userName, String birthday, String phone, String email) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getuserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return userId + ", " + userPw + ", " + userName + ", " + birthday
				+ ", " + phone + ", " + email;
	}

}
