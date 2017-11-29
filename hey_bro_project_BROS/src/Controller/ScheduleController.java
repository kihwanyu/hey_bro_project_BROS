package Controller;

import java.util.ArrayList;

import Model.dao.ScheduleDAO;
import Model.vo.Schedule;

public class ScheduleController {
	ScheduleDAO sDao = new ScheduleDAO();
	Schedule schedule;

	public void process(String key,int number,String groupName, String userName,
			String date, String startTime, String endTime, String title, String contents){
		switch(key){
		case "Schedule.do" :
			sDao.scheduleRegistor(number, groupName, userName, date, startTime, endTime, title, contents);
			break;
		default : break;
		}
		//
	}
	public ArrayList<Schedule> process(String key, String date, String groupName){
		switch(key){
		case "ScheduleList.do" : 
		return	sDao.prcess(date, groupName);
		
		default : 
			break;
		}
		return null;
	}

}