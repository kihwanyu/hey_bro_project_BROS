package Controller;

import java.util.ArrayList;

import Model.dao.ScheduleDAO;
import Model.vo.Member;
import Model.vo.Schedule;
import Model.vo.Session;

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
//
	public ArrayList<Schedule> process(String key, String gName) {
		ArrayList<Schedule> scheduleArrayList = new ArrayList<>();
		switch (key) {
		case "ScheduleSatting.do":
			return scheduleArrayList = sDao.scheduleSatting(gName);
			
			
		case "ScheduleDelete.do" :
			sDao.gName(gName);
			break;
		default:
			break;
		}
		return null;
	}
	public void process(String key, Schedule schedule){
		switch (key) {
		case "ScheduleUpdate.do":
			sDao.scheduleUpdate(schedule);
			break;
		default:
			break;
		}
	}
	public boolean process(String key, int sNamber){
		boolean result = false; 
				
		switch (key) {
		case "ScheduleDelete.do":
			result = sDao.scheduleDelete(sNamber);
			break;
		
		default:
			break;
		}
		return result;
	}
	public void process(String key, String userId, boolean types){
		switch (key) {
		case "includeNameInGroup.do":
			sDao.includeNameInGroup(userId);
			break;
		
		default:
			break;
		}
		
	}
}