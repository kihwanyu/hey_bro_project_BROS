package Controller;

import java.util.ArrayList;

import Model.dao.ScheduleDAO;
import Model.vo.Schedule;

public class ScheduleController {
   ScheduleDAO sDao = new ScheduleDAO();
   Schedule schedule;
   
   public void process(String key,String groupName, String userName,
   String date, String startTime, String endTime, String title, String contents){
      switch(key){
      case "Schedule.do" :
         sDao.scheduleRegistor(groupName, userName, date, startTime, endTime, title, contents);
         break;
      
      default : break;
      }
      //
   }
  
	public ArrayList<Schedule> process(String key, String gName, String year, String month) {
		//날짜순으로 정렬 - 오름차순
		ArrayList<Schedule> scheduleArrayList = new ArrayList<>();
		switch (key) {
		case "ScheduleSatting.do":
				scheduleArrayList = sDao.scheduleSatting(gName, year, month);
			break;

		default:
			break;
		}
		return scheduleArrayList;
	}
}