package Model.vo;

public class Session {
	private String userName;
	private String userPw;
	
	
	public Session() {
		super();
	}


	public Session(String userName, String userPw) {
		super();
		this.userName = userName;
		this.userPw = userPw;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPw() {
		return userPw;
	}


	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}


	@Override
	public String toString() {
		return "Session [userName=" + userName + ", userPw=" + userPw + "]";
	}
	
	
}
