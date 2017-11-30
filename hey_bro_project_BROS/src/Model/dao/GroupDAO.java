
package Model.dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
		//리더 추가
		prop.clear();
		String fileName = "hey_bro_project_BROS/src/Model/Data/xml/group/"+gName+".xml";
		prop.setProperty(String.valueOf(0), leader);
		try{
			prop.storeToXML(new FileOutputStream(fileName),String.valueOf(new Date()).toString());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	//그룹삭제
		public void groupDelete(Session session){
			
			Properties prop = new Properties();
			LinkedList<Group> groupList = new LinkedList<>();
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

						Group group = new Group(rNum, rGname, rInterests, rPw, rContent, rNews, rLeader);
						
						groupList.add(group);
						
					}
				}

			} catch (InvalidPropertiesFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*for(int i = 0; i<groupList.size();i++){
				System.out.println(":D");
				System.out.println(groupList.get(i));
			}*/
						
			for(int i=0; i<groupList.size();i++){
				System.out.println(groupList.get(i).getLeader() + "랑 " + groupList.get(i).getgName());
				System.out.println(session.getUserId());
				
				
				if(session.getUserId().equals(groupList.get(i).getLeader())){
					
					 File file = new File("hey_bro_project_BROS/src/Model/Data/xml/group/"+groupList.get(i).getgName()+".xml");
			        System.out.println("hey_bro_project_BROS/src/Model/Data/xml/group/"+groupList.get(i).getgName() + ".xml");
			     
			     
			       if( file.exists() ){
			            if(file.delete()){
			                System.out.println("파일삭제 성공");
			                groupList.remove(i);
			            }else{
			                System.out.println("파일삭제 실패");
			            }
			        }else{
			            System.out.println("파일이 존재하지 않습니다.");
			        }

			        
			         
				} else{
					System.out.println("틀림");
				}	

			}
			for(int i=0; i<groupList.size();i++){
				groupMap.put(i, groupList.get(i));
			}
			
			
			Set<Integer> keys = groupMap.keySet();
			Iterator<Integer> grIter = keys.iterator();
					
			
			try {
				prop.clear();
				while(grIter.hasNext()){
					int key = grIter.next();
					prop.setProperty(String.valueOf(key).toString(), groupMap.get(key).toString());
				}
				
				prop.storeToXML(new FileOutputStream("hey_bro_project_BROS/src/Model/Data/xml/groups.xml"),String.valueOf(new Date()).toString());
				
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
	public Group groupSetting(String gName){
		Properties prop = new Properties();
		ArrayList<Group> groupArrayList = new ArrayList();
		
		String rNumber;
		String rGName;
		String rInterests;
		String rPw;
		String rContent;
		String rNews;
		String rLeader;
		
		try{
			prop.loadFromXML(new FileInputStream("hey_bro_project_BROS\\src\\Model\\Data\\xml\\groups.xml"));
			
			for(int i = 0 ; i < prop.size(); i++){
				String str;
				
				String[] str_arr = new String[7];
				
				str = prop.getProperty(String.valueOf(i).toString());
				
				if(str != null){
					str_arr = str.split(", ");
					
					rNumber = str_arr[0];
					rGName = str_arr[1];
					rInterests = str_arr[2];
					rPw = str_arr[3];
					rContent = str_arr[4];
					rNews = str_arr[5];
					rLeader = str_arr[6];
					
					Group group = new Group(rGName, rInterests, rPw, rContent, rNews, rLeader);
					
					groupArrayList.add(group);
					
					System.out.println(groupArrayList.get(i));
					
				}
			}
		}catch(InvalidPropertiesFormatException e){
			e.printStackTrace();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		for(int i = 0; i < groupArrayList.size(); i++){
			if(gName.equals(groupArrayList.get(i).getgName())){
				System.out.println(groupArrayList.get(i));
				
				return groupArrayList.get(i);
			}
		}
		
		return null;
	}
	
	//조성식
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
		//

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

					Group group = new Group(rGname, rInterests, rPw, rContent, rNews, rLeader);
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
		
		prop.clear();
		for(int i = 0; i < groupArrayList.size(); i++){
			if(groupArrayList.get(i).getgName().equals(g.getgName())){
				
				groupArrayList.set(i, g);
			}
			prop.setProperty(String.valueOf(i).toString(), groupArrayList.get(i).toString());

		}
		try {
			prop.storeToXML(new FileOutputStream("hey_bro_project_BROS/src/Model/Data/xml/groups.xml"), String.valueOf(new Date()).toString());
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//조성식(그룹 중복검사)
	public boolean GroupNameOverlap(String groupName){
		Properties prop = new Properties();
		ArrayList<String> groupNameList = new ArrayList<>();
		String rGroupName;
		try {
			prop.loadFromXML(new FileInputStream("hey_bro_project_BROS\\src\\Model\\Data\\xml\\groups.xml"));
			//System.out.println(prop.size());
			for(int i = 0; i < prop.size(); i++){
				String str;
				
				String[] str_arr = new String[7];
				
				str = prop.getProperty(String.valueOf(i).toString());
				if(str!=null){

					str_arr = str.split(", ");
	
					System.out.println("groupName = " + str_arr[1]);
					rGroupName = str_arr[1];
					
					groupNameList.add(rGroupName);
				}
			}	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < groupNameList.size(); i++ ) {
			if(groupNameList.get(i).equals(groupName)){
				//System.out.println("중복되었습니다.");
				return false;
			}
		}
		return true;
		
	}
	public ArrayList<String> groupListSearch(String userId) {
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
	//구주승 그룹장 과 그룸명을 XML로 저장해서 그 이 외의 사람들은 그룹 원으로 인식하는 기능 
	public boolean groupJoin(String gName, String userName){

		Properties prop = new Properties();
		ArrayList<String> userNameList = new ArrayList<>();
		Map<String,Group> groupMap = new HashMap<>();

		String rgName;
		String ruserName;
		String rLeader;
		boolean result = false;
		try {
			prop.loadFromXML(new FileInputStream("hey_bro_project_BROS/src/Model/Data/xml/Group/"+gName+".xml"));

			for(int i = 0; i < prop.size(); i++){
				String str;
				//Group group = new Group();
				//str = group.toString();
				//String[] str_arr = new String[3];
				str = prop.getProperty(String.valueOf(i).toString());
				//System.out.println(str);
				if(str!=null){
					ruserName = str;

					userNameList.add(ruserName);
					//Group group = new Group(rLeader, ruserName);
					//groupMap.put(rgName, new Group(rLeader, ruserName));
				}
			}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int a = 0;
		for(int i = 0; i < userNameList.size(); i++) {
			if(!userNameList.get(i).equals(userName)){
				a = 0;
			}else if (userNameList.get(i).equals(userName)){
				a = 1;
			}
		}
		if(a==0){
			userNameList.add(userName);
			result = true;	
		}
		prop.clear();
		for(int i = 0; i < userNameList.size(); i++){
			prop.setProperty(String.valueOf(i).toString(), userNameList.get(i).toString());
		}

		//prop.clear();
		//prop.setProperty(gName,userName);
		try {
			prop.storeToXML(new FileOutputStream("hey_bro_project_BROS/src/Model/Data/xml/group/"+gName+".xml"),String.valueOf(new Date()).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	//그룹 탈퇴
	public void leaveGroup(Session session, String gName){
		Properties prop = new Properties();
		ArrayList<String> userNameList = new ArrayList<>();
	

		String rgName;
		String ruserName;
		String rKey;
		
		try {
			prop.loadFromXML(new FileInputStream("hey_bro_project_BROS/src/Model/Data/xml/group/"+gName+".xml"));
			//해당하는 그룹 xml 파일 소환
			
			for(int i = 0; i < prop.size(); i++){
				String str;
				
				str = prop.getProperty(String.valueOf(i).toString());
				//str에 prop에 있는 해당 그룹 아이디 저장
				
				
				userNameList.add(str);
			//	System.out.println(i +": "+ str + ":D");
				/*System.out.println("prop.size: "+prop.size());
				System.out.println("userNameList.size: "+ userNameList.size());*/
				
				if(str!=null){
					ruserName = str; //ruserName에 담음 
					System.out.println(ruserName + ":O");
										
				if(ruserName.equals(session.getUserId())){
					for(int j = 0; j<userNameList.size();j++){
						if(userNameList.get(j).equals(session.getUserId())){
						//현재 사용자 ID와 ruserName이 같다면
							System.out.println(ruserName + "&" + session.getUserId());
							System.out.println("userNameList" + userNameList);{
						
							userNameList.remove(j); //해당 인덱스 삭제
									break;
							}
						
						}
					}
				}
				}
			}	
		} catch (InvalidPropertiesFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		prop.clear();
		for(int i = 0; i < userNameList.size(); i++){
			prop.setProperty(String.valueOf(i).toString(), userNameList.get(i).toString());
			//새로운 userNameList를 prop에 다시 저장
		}
		
		try {
			prop.storeToXML(new FileOutputStream("hey_bro_project_BROS/src/Model/Data/xml/group/"+gName+".xml"),String.valueOf(new Date()).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	// 그룹 입장 콤보박스
	public ArrayList<String> groupCombo(String userId){
		Properties prop = new Properties();
		ArrayList<String> arrList = new ArrayList<>();
		try {
			Files.walk(Paths.get("hey_bro_project_BROS/src/Model/Data/xml/Group")).forEach(filePath -> {
				if (Files.isRegularFile(filePath)) {
					try {
						prop.loadFromXML(new FileInputStream(String.valueOf(filePath)));
						for(int i = 0; i < prop.size(); i++){
							String str;
							str = prop.getProperty(String.valueOf(i).toString());
							if(str.equals(userId)){
								String fileName = String.valueOf(filePath.getFileName());
								arrList.add(fileName);
								//System.out.println(fileName);
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arrList;
	}
}

