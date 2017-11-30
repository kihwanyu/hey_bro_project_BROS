package Controller;
//
import java.util.ArrayList;

import Model.dao.ScheduleDAO;
import Model.vo.Member;
import Model.vo.Schedule;

public class ScheduleController {
	ScheduleDAO sDao = new ScheduleDAO();
	Schedule schedule;

	public void process(String key,String groupName, String userName,
			String date, String startTime, String endTime, String title, String contents){
		switch(key){
		case "ScheduleRegister.do" :
			sDao.scheduleRegistor(groupName, userName, date, startTime, endTime, title, contents);
			break;
		default : 
			break;
		}
		//
	}

	public ArrayList<Schedule> process(String key, String gName) {
		ArrayList<Schedule> scheduleArrayList = new ArrayList<>();
		switch (key) {
		case "ScheduleSatting.do":
			scheduleArrayList = sDao.scheduleSatting(gName);
			break;

		default:
			break;
		}
		return scheduleArrayList;
	}
	public void process(String key, Member member){
		switch (key) {
		case "ScheduleUpdate.do":
			////sDao.scheduleUpdate(member);
			break;
		default:
			break;
		}
	}
	
}