package Model.vo;

public class Schedule {
	private String gName;
	private String sName;
	private int year;
	private int month;
	private int date;
	private int startHour;
	private int startMin;
	private int endHour;
	private int endMin;
	private String sContent;
	public Schedule() {
		super();
	}
	public Schedule(String gName, String sName, int year, int month, int date, int startHour, int startMin, int endHour,
			int endMin, String sContent) {
		super();
		this.gName = gName;
		this.sName = sName;
		this.year = year;
		this.month = month;
		this.date = date;
		this.startHour = startHour;
		this.startMin = startMin;
		this.endHour = endHour;
		this.endMin = endMin;
		this.sContent = sContent;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getStartHour() {
		return startHour;
	}
	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}
	public int getStartMin() {
		return startMin;
	}
	public void setStartMin(int startMin) {
		this.startMin = startMin;
	}
	public int getEndHour() {
		return endHour;
	}
	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}
	public int getEndMin() {
		return endMin;
	}
	public void setEndMin(int endMin) {
		this.endMin = endMin;
	}
	public String getsContent() {
		return sContent;
	}
	public void setsContent(String sContent) {
		this.sContent = sContent;
	}
	@Override
	public String toString() {
		return "Schedule [gName=" + gName + ", sName=" + sName + ", year=" + year + ", month=" + month + ", date="
				+ date + ", startHour=" + startHour + ", startMin=" + startMin + ", endHour=" + endHour + ", endMin="
				+ endMin + ", sContent=" + sContent + "]";
	}
	
	
}
