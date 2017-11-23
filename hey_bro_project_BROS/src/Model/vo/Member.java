package Model.vo;

public class Member {
	private String userId;
	private String userPw;
	private String userName;
	private String birthday;
	private String email;
	private String pictureUrl;
	public Member() {
		super();
	}

	public Member(String userId, String userPw, String userName, 
			String birthday, String email, String pictureUrl) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.birthday = birthday;
		this.email = email;
		this.pictureUrl = pictureUrl;
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	@Override
	public String toString() {
		return userId + ", " + userPw + ", " + userName + ", " + birthday
				+ ", " + pictureUrl + ", " + email;
	}

}
