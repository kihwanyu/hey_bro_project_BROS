package Controller;

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
}