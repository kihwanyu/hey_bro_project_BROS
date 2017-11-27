
package Model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
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

					
					groupMap.put(groupMap.size(), new Group(rNum,rGname, rInterests, rPw, rContent, rNews, rLeader));
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
	//방 참여 비밀번호 확인 
	public boolean rLogin(String Pw, String groupSession){
		Properties prop = new Properties();
		Map<Integer,Group> groupMap = new HashMap<>();

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

				String[] str_arr = new String[7];
				String file_str = null;
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

					
					groupMap.put(groupMap.size(), new Group(rNum,rGname, rInterests, rPw, rContent, rNews, rLeader));
					//file_str = "hey_bro_project_BROS/src/Model/Data/xml/"+rGName+".xml";
				}
			}	

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Set<Integer> keys = groupMap.keySet();
		Iterator<Integer> iter = keys.iterator();
		
		while(iter.hasNext()){
			int key = iter.next();
			System.out.println("[key]:"+key);
			if(groupMap.get(key).getgName().equals(groupSession)&&
					groupMap.get(key).getPw().equals(Pw)){
				System.out.println("getName["+key+"]"+groupMap.get(key).getgName());
				System.out.println("getPw["+key+"]"+groupMap.get(key).getPw());
				//prop.storeToXML(new FileOutputStream(file_str), "comment");
				System.out.println("확인 완료");
				return true;
			}
		}
		return false;

	}
	//조성식 수정
	public void groupUpdate(Group g){
		Properties prop = new Properties();
		Map<Integer, Group> groupMap = new HashMap<>();
		ArrayList<Group> groupArrayList = new ArrayList<>();

		String rNum;
		String rGname;
		String rInterests;
		String rPw;
		String rContent;
		String rNews;
		String rLeader;

		try {
			prop.loadFromXML(new FileInputStream("hey_bro_project_BROS\\src\\Model\\Data\\xml\\groups.xml"));

			for(int i = 0; i < prop.size(); i++){
				String str;

				String[] str_arr = new String[7];

				str = prop.getProperty(String.valueOf(i).toString());
				if(str != null){
					str_arr = str.split(", ");

					rNum = str_arr[0];
					rGname = str_arr[1];
					rInterests = str_arr[2];
					rPw = str_arr[3];
					rContent = str_arr[4];
					rNews = str_arr[5];
					rLeader = str_arr[6];

					Group group = new Group(rNum, rGname, rInterests, rPw, rContent, rNews, rLeader);
					groupMap.put(groupMap.size(), group);
				}
			}
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Collection<Group> groupValues = groupMap.values();
		groupArrayList.addAll(groupValues);
		for(int i = 0; i < groupArrayList.size(); i++){
			if(groupArrayList.get(i).getNumber().equals(g.getNumber())){
				groupArrayList.set(i, g);
			}
			prop.setProperty(String.valueOf(i).toString(), groupArrayList.get(i).toString());

		}
		try {
			prop.storeToXML(new FileOutputStream("hey_bro_project_BROS\\src\\Model\\Data\\xml\\members.xml"), String.valueOf(new Date()).toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//구주승 (그룹장으로  그룹 검색하기)
	public void groupSearch() {

	}
	public ArrayList<String> groupListSearch(String userId, int type) {
		ArrayList<String> groupList = new ArrayList<>();
		Properties prop = new Properties();
		
		String rGname;
		String rLeader;

		try {
			prop.loadFromXML(new FileInputStream("hey_bro_project_BROS/src/Model/Data/xml/groups.xml"));
			for(int i = 0; i < prop.size(); i++){
				String str;
				String[] str_arr = new String[7];
				str = prop.getProperty(String.valueOf(i).toString());

				if(str!=null){
					str_arr = str.split(", ");

					rGname = str_arr[1];
					rLeader = str_arr[6];
					if(rLeader.equals(userId)) {
						groupList.add(rGname);
						//System.out.println(rGname);
					}		
				}
			}
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return groupList;
	}	
	//구주승 그룹장 과 그룸명을 저장해서 그 이 외의 사람들은 그룹 원으로 인식하는 기능 
	public void groupJoin(){
		
	}
}

