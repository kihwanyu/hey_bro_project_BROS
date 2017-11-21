package Model.vo;

public class Group {
	private int number;
	private String Leader;
	private String gName;
	private String pw;
	private String content;
	public Group() {
		super();
	}
	public Group(int number, String leader, String gName, String pw, String content) {
		super();
		this.number = number;
		Leader = leader;
		this.gName = gName;
		this.pw = pw;
		this.content = content;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getLeader() {
		return Leader;
	}
	public void setLeader(String leader) {
		Leader = leader;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return number + ", " + Leader + ", " + gName + ", " + pw + ", "
				+ content;
	}
	
	
}
