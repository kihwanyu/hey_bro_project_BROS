package Model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
import Model.vo.ScheduleSortASC;

public class ScheduleDAO {

	public void scheduleRegistor(String groupName, String userName,
			String date, String startTime, String endTime, String title, String contents){


		Properties prop = new Properties();
		Map<Integer,Schedule> gScheduleMap = new HashMap<>();

		int rnumber;
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

				str = prop.getProperty(String.valueOf(i).toString());
				if(str!=null){
					str_arr = str.split(", ");

					rnumber = Integer.parseInt(str_arr[0]);
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
		Schedule schedule = new Schedule(gScheduleMap.size(), groupName, userName, date, startTime, endTime, title, contents);
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
	public ArrayList<Schedule> scheduleSatting(String gName) {
		Properties prop = new Properties();
		ArrayList<Schedule> scheduleArrayList = new ArrayList<>(); 
		// registered 등록된
		int rNumber;
		String rGroupName;
		String rUserName;
		String rDate;
		String rStartTime;
		String rEndTime;
		String rTitle;
		String rContents;

		try {
			prop.loadFromXML(new FileInputStream("hey_bro_project_BROS\\src\\Model\\Data\\xml\\schedule.xml"));
			//System.out.println(prop.size());
			for(int i = 0; i < prop.size(); i++){
				String str;

				String[] str_arr = new String[8];

				str = prop.getProperty(String.valueOf(i).toString());
				System.out.println(str);
				if(str!=null){
					str_arr = str.split(", ");
					/*for(String s : str_arr){
						System.out.println(s);
					}*/


					rNumber = scheduleArrayList.size();
					rGroupName = str_arr[1];
					rUserName = str_arr[2];
					rDate = str_arr[3];
					rStartTime = str_arr[4];
					rEndTime = str_arr[5];
					rTitle = str_arr[6];	
					rContents = str_arr[7];	

					if(rGroupName.equals(gName)){
						Schedule schedule = new Schedule(rNumber, rGroupName, rUserName, rDate, rStartTime, rEndTime, rTitle, rContents);

						scheduleArrayList.add(schedule);
					}		
				}
			}	

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		scheduleArrayList.sort(new ScheduleSortASC());
		System.out.println("스케쥴 리스트 : " + scheduleArrayList);
		return scheduleArrayList;
	}

	public void scheduleUpdate(Schedule schedule) {
		Properties prop = new Properties();
		Map<Integer,Member> memberMap = new HashMap<>();
		ArrayList<Member> memberArrayList = new ArrayList<>(); 
		
		String title;
		String contents;
		String startTime;
		String endTime;
		
	}
}
