package Model.vo;

public class Schedule {
	private String groupName;
	private String userName;
	private String date;
	private int startTime;
	private int endTime;
	private String title;
	private String contents;
	
	public Schedule() {
		super();
	}
	public Schedule(String groupName, String userName, String date, int startTime, int endTime, String title,
			String contents) {
		super();
		this.groupName = groupName;
		this.userName = userName;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.title = title;
		this.contents = contents;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	@Override
	public String toString() {
		return groupName + ", " + userName + ", " + date + ", "
				+ startTime + ", " + endTime + ", " + title + ", " + contents;
	}
}
