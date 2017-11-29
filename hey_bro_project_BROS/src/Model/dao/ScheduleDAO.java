package Model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import Model.vo.Group;
import Model.vo.Member;
import Model.vo.Schedule;

public class ScheduleDAO {
   
   public void scheduleRegistor(int number,String groupName, String userName,
         String date, String startTime, String endTime, String title, String contents){
      
      
      Properties prop = new Properties();
      Map<Integer,Schedule> gScheduleMap = new HashMap<>();
      
      int rnumber = 0;
      String rgroupName;
      String ruserName;
      String rdate;
      String rstartTime;
      String rendTime;
      String rtitle;
      String rcontents;
      
      try {
    	  
    	  prop.loadFromXML(new FileInputStream("hey_bro_project_BROS/src/Model/Data/xml/Schedule.xml"));
         for(int i = 0; i < prop.size(); i++){
            String str;
            
            String[] str_arr = new String[8];
            
            //System.out.println(prop.getProperty(String.valueOf(i).toString()));
            str = prop.getProperty(String.valueOf(i).toString());
            if(str!=null){
               //System.out.println(str);
               str_arr = str.split(", ");
               /*for(String s : str_arr){
                  System.out.println(s);
               }*/
               
               str_arr[0] = String.valueOf(rnumber);
               rgroupName = str_arr[1];
               ruserName = str_arr[2];
               rdate = str_arr[3];
               rstartTime = str_arr[4];
               rendTime = str_arr[5];
               rtitle = str_arr[6];   
               rcontents = str_arr[7];
               
               Schedule schedule = new Schedule(rnumber,rgroupName,ruserName,rdate,rstartTime,rendTime,rtitle,rcontents);
               gScheduleMap.put(gScheduleMap.size(), schedule);      
               
            }
         }   
      } catch (Exception e) {
         e.printStackTrace();
      }
      Schedule schedule = new Schedule(number, groupName, userName, date, startTime, endTime, title, contents);
      
      gScheduleMap.put(gScheduleMap.size(), schedule);
      
      Set<Integer> keys = gScheduleMap.keySet();
      Iterator<Integer> scheduleIter = keys.iterator();
     
      try {
         while(scheduleIter.hasNext()){
            int key = scheduleIter.next();
            prop.setProperty(String.valueOf(key).toString(), gScheduleMap.get(key).toString());
         }
         
         prop.storeToXML(new FileOutputStream("hey_bro_project_BROS\\src\\Model\\Data\\xml\\Schedule.xml"),String.valueOf(new Date()).toString());
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }   
   
   public ArrayList<Schedule> prcess(String date, String groupName){
	   System.out.println("æ»≥Á«œ¥œ?");
	   System.out.println(date);
	      Properties prop = new Properties();
	      ArrayList<Schedule> scheduleList = new ArrayList<>();
	      
	      int rnumber = 0;
	      String rgroupName;
	      String ruserName;
	      String rdate;
	      String rstartTime;
	      String rendTime;
	      String rtitle;
	      String rcontents;
	      
	      try {
	    	  
	    	  prop.loadFromXML(new FileInputStream("hey_bro_project_BROS/src/Model/Data/xml/Schedule.xml"));
	         for(int i = 0; i < prop.size(); i++){
	            String str;
	            
	            String[] str_arr = new String[8];
	            
	            //System.out.println(prop.getProperty(String.valueOf(i).toString()));
	            str = prop.getProperty(String.valueOf(i).toString());
	            if(str!=null){
	               //System.out.println(str);
	               str_arr = str.split(", ");
	               /*for(String s : str_arr){
	                  System.out.println(s);
	               }*/
	               
	               str_arr[0] = String.valueOf(rnumber);
	               rgroupName = str_arr[1];
	               ruserName = str_arr[2];
	               rdate = str_arr[3];
	               rstartTime = str_arr[4];
	               rendTime = str_arr[5];
	               rtitle = str_arr[6];   
	               rcontents = str_arr[7];
	               
	               
	               Schedule schedule = new Schedule(rnumber,rgroupName,ruserName,rdate,rstartTime,rendTime,rtitle,rcontents);
	               scheduleList.add(schedule);
	               System.out.println(scheduleList.size());
	            }
	         }   
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	      ArrayList<Schedule> copyList = new ArrayList<>();
	      for(int i = 0; i <scheduleList.size(); i++){
	    	  if(date.equals(scheduleList.get(i).getDate()) && groupName.equals(scheduleList.get(i).getGroupName())){
	    		copyList.add(new Schedule(scheduleList.get(i).getStartTime(), scheduleList.get(i).getEndTime(), scheduleList.get(i).getTitle(), scheduleList.get(i).getContents()));  
	    	  }
	      }
	   
	   System.out.println(copyList.size());
	   
	   return copyList;
   }
   

	   
   
      
}