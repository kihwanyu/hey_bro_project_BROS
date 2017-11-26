package Model.vo;

public class Group {
	private String number;
	
	
	private String gName;
	private String interests;
	private String pw;
	private String content;
	private String news;
	private String leader;
	
	public Group() {
		super();
	}
	
	public Group(String gName) {
		this.gName = gName;
	}

	public Group(String gName, String interests, String pw, String content, String news, String leader) {
		super();
		this.gName = gName;
		this.interests = interests;
		this.pw = pw;
		this.content = content;
		this.news = news;
		this.leader = leader;
	}
	
	
	public Group(String gNum, String gName, String interests, String pw, String content, String news, String leader) {
		super();
		this.number = gNum;
		this.gName = gName;
		this.interests = interests;
		this.pw = pw;
		this.content = content;
		this.news = news;
		this.leader = leader;
	}
	

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		leader = leader;
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
		return number+", "+ gName + ", "+  interests + ", "+  pw + ", "+ content + ", " +news +", " +leader;
	}

	
}
