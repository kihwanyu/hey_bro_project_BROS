package Model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
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
import Model.vo.Session;

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
		//ArrayList<Schedule> scheduleList = new ArrayList<>();
		//scheduleList.addAll(gScheduleMap.values());
		//scheduleList.sort(new ScheduleSortASC());
		Iterator<Integer> scheduleIter = keys.iterator();


		try {
			while(scheduleIter.hasNext()){
						int key = scheduleIter.next();
						prop.setProperty(String.valueOf(key).toString(), gScheduleMap.get(key).toString());
					}
			//prop.clear();
			/*for(int i = 0; i < scheduleList.size(); i++){
				prop.setProperty(String.valueOf(i).toString(), scheduleList.get(i).toString());
			}*/

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

	public void scheduleUpdate(Schedule s) {
		Properties prop = new Properties();
		Map<Integer,Schedule> scheduleMap = new HashMap<>();
		ArrayList<Schedule> scheduleArrayList = new ArrayList<>(); 

		int number;
		String gName;
		String userID;
		String data;
		String startTime;
		String endTime;
		String title;
		String contents;

		try {
			prop.loadFromXML(new FileInputStream("hey_bro_project_BROS\\src\\Model\\Data\\xml\\schedule.xml"));
			//System.out.println(prop.size());
			for(int i = 0; i < prop.size(); i++){
				String str;

				String[] str_arr = new String[8];

				str = prop.getProperty(String.valueOf(i).toString());
				if(str!=null){
					str_arr = str.split(", ");

					number = Integer.parseInt(str_arr[0]);
					gName = str_arr[1];
					userID = str_arr[2];
					data = str_arr[3];
					startTime = str_arr[4];
					endTime = str_arr[5];
					title = str_arr[6];	
					contents = str_arr[7];
					//contents = str_arr[8];
					//
					Schedule schedule = new Schedule(number, gName,userID,data,startTime,endTime,title,contents);

					scheduleMap.put(scheduleMap.size(), schedule);
				}
			}	

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Collection<Schedule> scheduleValues = scheduleMap.values();
		scheduleArrayList.addAll(scheduleValues);
		prop.clear();
		for(int i = 0; i <scheduleArrayList.size(); i++){
			if(scheduleArrayList.get(i).getNumber()==(s.getNumber())){
				//System.out.println(scheduleArrayList.get(i));
				scheduleArrayList.set(i, s);
				//System.out.println(scheduleArrayList.get(i));
			}
			prop.setProperty(String.valueOf(i).toString(), scheduleArrayList.get(i).toString());
		}

		try {
			prop.storeToXML(new FileOutputStream("hey_bro_project_BROS\\src\\Model\\Data\\xml\\schedule.xml"),String.valueOf(new Date()).toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public boolean scheduleDelete(int sNamber) {
		
		Properties prop = new Properties();
		Map<Integer,Schedule> scheduleMap = new HashMap<>();
		ArrayList<Schedule> scheduleArrayList = new ArrayList<>(); 

		boolean result = false;
		
		int number;
		String gName;
		String userID;
		String data;
		String startTime;
		String endTime;
		String title;
		String contents;
		
		try {
			prop.loadFromXML(new FileInputStream("hey_bro_project_BROS\\src\\Model\\Data\\xml\\schedule.xml"));
			//System.out.println(prop.size());
			for(int i = 0; i < prop.size(); i++){
				String str;

				String[] str_arr = new String[8];

				str = prop.getProperty(String.valueOf(i).toString());
				if(str!=null){
					str_arr = str.split(", ");

					number = Integer.parseInt(str_arr[0]);
					gName = str_arr[1];
					userID = str_arr[2];
					data = str_arr[3];
					startTime = str_arr[4];
					endTime = str_arr[5];
					title = str_arr[6];	
					contents = str_arr[7];
					//contents = str_arr[8];
					//
					Schedule schedule = new Schedule(number, gName,userID,data,startTime,endTime,title,contents);

					scheduleArrayList.add(schedule);
				}
			}	

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < scheduleArrayList.size(); i++){
			if(scheduleArrayList.get(i).getNumber()==(sNamber)){
				System.out.println("scheduleArrayList.get(i):"+scheduleArrayList.get(i));
				scheduleArrayList.remove(i);
				result = true;
				break;
			}
		}
		
		for(int i = 0; i < scheduleArrayList.size(); i++){
			System.out.println(scheduleArrayList.get(i));
			scheduleMap.put(i, scheduleArrayList.get(i));
		}
		
		Set<Integer> keys = scheduleMap.keySet();
		Iterator<Integer> shceIter = keys.iterator();
		
		try {
			prop.clear();
			while(shceIter.hasNext()){
				int key = shceIter.next();
				prop.setProperty(String.valueOf(key).toString(), scheduleMap.get(key).toString());
			}
			
			prop.storeToXML(new FileOutputStream("hey_bro_project_BROS\\src\\Model\\Data\\xml\\schedule.xml"),String.valueOf(new Date()).toString());
			//System.out.println("성공적으로 회원가입이 완료되었습니다.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	

}