package Model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import Model.vo.Group;
import Model.vo.Member;
import Model.vo.Session;

public class GroupDAO {
	
	
	
	public void groupRegister(String gName, String interests, String pw, String content, String news, String leader){
		Properties prop = new Properties();
		LinkedList<String> groupList = new LinkedList<>();
		Map<Integer,Group> groupMap = new HashMap<>();
		
		
		//Registered
		
		String rNum;
		String rGname;
		String rInterests;
		String rPw;
		String rContent;
		String rNews;
		String rLeader;
		
		
		try {
			prop.loadFromXML(new FileInputStream("hey_bro_project_BROS/src/Model/Data/xml/groups.xml"));
			
			for(int i = 0; i < prop.size(); i++){
				String str;
				Group group = new Group();
				str = group.toString();
				String[] str_arr = new String[7];
				str = prop.getProperty(String.valueOf(i).toString());
				
				if(str!=null){
		
					str_arr = str.split(", ");
					
					
					rNum = str_arr[0];
					rGname = str_arr[1];
					rInterests = str_arr[2];
					rPw = str_arr[3];
					rContent = str_arr[4];
					rNews = str_arr[5];
					rLeader = str_arr[6];
					
					new Group(rNum,rGname, rInterests, rPw, rContent, rNews, rLeader);
					groupMap.put(groupMap.size(), group);
				}
				
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		groupMap.put(groupMap.size(),new Group(gName, interests, pw, content, news, leader));
		
		Set<Integer> keys = groupMap.keySet();
		Iterator<Integer> gIter = keys.iterator();
		try {
			while(gIter.hasNext()){
				int key = gIter.next();
				prop.setProperty(String.valueOf(key).toString(), groupMap.get(key).toString());
			}
			
			prop.storeToXML(new FileOutputStream("hey_bro_project_BROS/src/Model/Data/xml/groups.xml"), null);
			//System.out.println("성공적으로 모임생성이 완료되었습니다.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//방 입장 비밀번호 확인 = 미해결
	public boolean rLogin(String Pw){
		Properties prop = new Properties();
		ArrayList<Session> sessionList = new ArrayList<>();
		String pw;
		
		try {
			prop.loadFromXML(new FileInputStream("hey_bro_project_BROS/src/Model/Data/xml/groups.xml"));
			
			for(int i = 0; i < prop.size(); i++){
				String str;
				
				String[] str_arr = new String[6];
				
				str = prop.getProperty(String.valueOf(i).toString());
				if(str!=null){

					str_arr = str.split(", ");

					pw = str_arr[2];
					
					
					
					/*//용도는 다르지만 아이디와 비밀번호를 묶어 놓을 수 있어서 세션 클래스를 사용한다.
					sessionList.add(new Session(rUserId, rUserPw));*/
				}
			}	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return true; 
		
	}

	
}
