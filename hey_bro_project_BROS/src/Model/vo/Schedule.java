package Model.vo;

public class Schedule {//
	private int number;
	private String groupName;
	private String userName;
	private String date;
	private String startTime;
	private String endTime;
	private String title;
	private String contents;
	
	public Schedule() {
		super();
	}
	public Schedule(int number,String groupName, String userName, String date, String startTime, String endTime, String title,
			String contents) {
		super();
		this.number = number;
		this.groupName = groupName;
		this.userName = userName;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.title = title;
		this.contents = contents;
	}
	
	public Schedule(String startTime, String endTime, String title, String contents){
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.title = title;
		this.contents = contents;
		
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
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
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
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
		return number+ ", " + groupName + ", " + userName + ", " + date + ", "
				+ startTime + ", " + endTime + ", " + title + ", " + contents;
	}
}
