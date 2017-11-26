package Model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import Model.vo.Member;
import Model.vo.Session;

public class MemberDAO {
	//
	//ȸ������
	public void memberRegister(String userId, String userPw, String userName,  
			String userGender, String birthday, String email, String pictureUrl){
		Properties prop = new Properties();
		Map<Integer,Member> memberMap = new HashMap<>();
		
		// registered ��ϵ�
		String rUserId;
		String rUserPw;
		String rUserName;
		String rUserGender;
		String rBirthday;
		String rEmail;
		String rPictureUrl;
		
		try {
			prop.loadFromXML(new FileInputStream("hey_bro_project_BROS\\src\\Model\\Data\\xml\\members.xml"));
			System.out.println(prop.size());
			for(int i = 0; i < prop.size(); i++){
				String str;
				
				String[] str_arr = new String[7];
				
				//System.out.println(prop.getProperty(String.valueOf(i).toString()));
				str = prop.getProperty(String.valueOf(i).toString());
				if(str!=null){
					//System.out.println(str);
					str_arr = str.split(", ");
					/*for(String s : str_arr){
						System.out.println(s);
					}*/
					
					rUserId = str_arr[0];
					rUserPw = str_arr[1];
					rUserName = str_arr[2];
					rUserGender = str_arr[3];
					rBirthday = str_arr[4];
					rEmail = str_arr[5];
					rPictureUrl = str_arr[6];	
					
					Member member = new Member(rUserId, rUserPw, rUserName, rUserGender, rBirthday, rEmail, rPictureUrl);
					memberMap.put(memberMap.size(), member);					
				}
			}	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		memberMap.put(memberMap.size(),new Member(userId, userPw, userName, userGender, birthday, email, pictureUrl));
	
		Set<Integer> keys = memberMap.keySet();
		Iterator<Integer> memIter = keys.iterator();
		
		try {
			while(memIter.hasNext()){
				int key = memIter.next();
				prop.setProperty(String.valueOf(key).toString(), memberMap.get(key).toString());
			}
			
			prop.storeToXML(new FileOutputStream("hey_bro_project_BROS\\src\\Model\\Data\\xml\\members.xml"),String.valueOf(new Date()).toString());
			//System.out.println("���������� ȸ�������� �Ϸ�Ǿ����ϴ�.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	//ȸ������ - �ߺ��˻�
	public boolean MemberIdOverlap(String userId){
		Properties prop = new Properties();
		ArrayList<String> userIdList = new ArrayList<>();
		String rUserId;
		try {
			prop.loadFromXML(new FileInputStream("hey_bro_project_BROS\\src\\Model\\Data\\xml\\members.xml"));
			//System.out.println(prop.size());
			for(int i = 0; i < prop.size(); i++){
				String str;
				
				String[] str_arr = new String[6];
				
				str = prop.getProperty(String.valueOf(i).toString());
				if(str!=null){

					str_arr = str.split(", ");
	
					
					rUserId = str_arr[0];
					
					userIdList.add(rUserId);
				}
			}	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < userIdList.size(); i++ ) {
			if(userIdList.get(i).equals(userId)){
				//System.out.println("�ߺ��Ǿ����ϴ�.");
				return false;
			}
		}
		return true;
	}
	//�α���
	public boolean Login(String userId, String userPw){
		Properties prop = new Properties();
		ArrayList<Session> sessionList = new ArrayList<>();
		
		String rUserId;
		String rUserPw;
		try {
			prop.loadFromXML(new FileInputStream("hey_bro_project_BROS\\src\\Model\\Data\\xml\\members.xml"));
			//System.out.println(prop.size());
			for(int i = 0; i < prop.size(); i++){
				String str;
				
				String[] str_arr = new String[6];
				
				str = prop.getProperty(String.valueOf(i).toString());
				if(str!=null){

					str_arr = str.split(", ");
	
					
					rUserId = str_arr[0];
					rUserPw = str_arr[1];
					//�뵵�� �ٸ����� ���̵�� ��й�ȣ�� ���� ���� �� �־ ���� Ŭ������ ����Ѵ�.
					sessionList.add(new Session(rUserId, rUserPw));
				}
			}	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < sessionList.size(); i++ ) {
			if(sessionList.get(i).getUserId().equals(userId)
					&&sessionList.get(i).getUserPw().equals(userPw)){
				//System.out.println("�α��μ���.");
				return true;
			}
		}
		return false;
	}
	
	public Member memberSetting(Session session) {
		Properties prop = new Properties();
		ArrayList<Member> memberArrayList = new ArrayList<>(); 
		
		// registered ��ϵ�
		String rUserId;
		String rUserPw;
		String rUserName;
		String rUserGender;
		String rBirthday;
		String rEmail;
		String rPictureUrl;
		
		try {
			prop.loadFromXML(new FileInputStream("hey_bro_project_BROS\\src\\Model\\Data\\xml\\members.xml"));
			//System.out.println(prop.size());
			for(int i = 0; i < prop.size(); i++){
				String str;
				
				String[] str_arr = new String[7];
				
				str = prop.getProperty(String.valueOf(i).toString());
				if(str!=null){
					str_arr = str.split(", ");
					/*for(String s : str_arr){
						System.out.println(s);
					}*/
					
					rUserId = str_arr[0];
					rUserPw = str_arr[1];
					rUserName = str_arr[2];
					rUserGender = str_arr[3];
					rBirthday = str_arr[4];
					rEmail = str_arr[5];
					rPictureUrl = str_arr[6];	
					
					Member member = new Member(rUserId, rUserPw, rUserName, rUserGender, rBirthday, rEmail, rPictureUrl);

					memberArrayList.add(member);
				}
			}	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < memberArrayList.size(); i++){
			if(session.getUserId().equals(memberArrayList.get(i).getUserId())){
				return memberArrayList.get(i);
			}
		}
		return null;
	}
	public void memberUpdate(Member m) {
		Properties prop = new Properties();
		Map<Integer,Member> memberMap = new HashMap<>();
		ArrayList<Member> memberArrayList = new ArrayList<>(); 
		
		// registered ��ϵ�
		String rUserId;
		String rUserPw;
		String rUserName;
		String rUserGender;
		String rBirthday;
		String rEmail;
		String rPictureUrl;
		
		try {
			prop.loadFromXML(new FileInputStream("hey_bro_project_BROS\\src\\Model\\Data\\xml\\members.xml"));
			//System.out.println(prop.size());
			for(int i = 0; i < prop.size(); i++){
				String str;
				
				String[] str_arr = new String[7];
				
				str = prop.getProperty(String.valueOf(i).toString());
				if(str!=null){
					str_arr = str.split(", ");
					/*for(String s : str_arr){
						System.out.println(s);
					}*/
					
					rUserId = str_arr[0];
					rUserPw = str_arr[1];
					rUserName = str_arr[2];
					rUserGender = str_arr[3];
					rBirthday = str_arr[4];
					rEmail = str_arr[5];
					rPictureUrl = str_arr[6];	
					
					Member member = new Member(rUserId, rUserPw, rUserName, rUserGender, rBirthday, rEmail, rPictureUrl);
					System.out.println(member.toString());
					memberMap.put(memberMap.size(), member);
				}
			}	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Collection<Member> memberValues = memberMap.values();
		memberArrayList.addAll(memberValues);
		for(int i = 0; i < memberArrayList.size(); i++){
			if(memberArrayList.get(i).getUserId().equals(m.getUserId())){
				System.out.println(memberArrayList.get(i));
				memberArrayList.set(i, m);
				System.out.println(memberArrayList.get(i));
			}
			prop.setProperty(String.valueOf(i).toString(), memberArrayList.get(i).toString());
		}
		
		try {
			prop.storeToXML(new FileOutputStream("hey_bro_project_BROS\\src\\Model\\Data\\xml\\members.xml"),String.valueOf(new Date()).toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public String findIdMember(String userName, String birthday, String email) {
		Properties prop = new Properties();
		ArrayList<Member> memeberList = new ArrayList<>();
		// registered ��ϵ�
				String rUserId;
				String rUserPw;
				String rUserName;
				String rUserGender;
				String rBirthday;
				String rEmail;
				String rPictureUrl;
		try {
			prop.loadFromXML(new FileInputStream("hey_bro_project_BROS\\src\\Model\\Data\\xml\\members.xml"));
			//System.out.println(prop.size());
			for(int i = 0; i < prop.size(); i++){
				String str;
				
				String[] str_arr = new String[6];
				
				str = prop.getProperty(String.valueOf(i).toString());
				if(str!=null){

					str_arr = str.split(", ");
	
					rUserId = str_arr[0];
					rUserPw = str_arr[1];
					rUserName = str_arr[2];
					rUserGender = str_arr[3];
					rBirthday = str_arr[4];
					rEmail = str_arr[5];
					rPictureUrl = str_arr[6];	
					
					Member member = new Member(rUserId, rUserPw, rUserName, rUserGender, rBirthday, rEmail, rPictureUrl);
					memeberList.add(member);					
				}
			}	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < memeberList.size(); i++){
			if(memeberList.get(i).getUserName().equals(userName)&&
				memeberList.get(i).getBirthday().equals(birthday)&&
				memeberList.get(i).getEmail().equals(email)){
				return "ȸ���� ���̵�� " + memeberList.get(i).getUserId() + "�Դϴ�.";
			}
		}
		return "�������� �ʴ� ȸ�������Դϴ�.";	
	}
	public String findPwMember(String userId, String birthday, String email) {
		Properties prop = new Properties();
		ArrayList<Member> memeberList = new ArrayList<>();
		// registered ��ϵ�
				String rUserId;
				String rUserPw;
				String rUserName;
				String rUserGender;
				String rBirthday;
				String rEmail;
				String rPictureUrl;
		try {
			prop.loadFromXML(new FileInputStream("hey_bro_project_BROS\\src\\Model\\Data\\xml\\members.xml"));
			//System.out.println(prop.size());
			for(int i = 0; i < prop.size(); i++){
				String str;
				
				String[] str_arr = new String[6];
				
				str = prop.getProperty(String.valueOf(i).toString());
				if(str!=null){

					str_arr = str.split(", ");
	
					rUserId = str_arr[0];
					rUserPw = str_arr[1];
					rUserName = str_arr[2];
					rUserGender = str_arr[3];
					rBirthday = str_arr[4];
					rEmail = str_arr[5];
					rPictureUrl = str_arr[6];	
					
					Member member = new Member(rUserId, rUserPw, rUserName, rUserGender, rBirthday, rEmail, rPictureUrl);
					memeberList.add(member);					
				}
			}	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < memeberList.size(); i++){
			if(memeberList.get(i).getUserId().equals(userId)&&
				memeberList.get(i).getBirthday().equals(birthday)&&
				memeberList.get(i).getEmail().equals(email)){
				return "ȸ���� ��й�ȣ�� " + memeberList.get(i).getUserPw() + "�Դϴ�.";
			}
		}
		return "�������� �ʴ� ȸ�������Դϴ�.";	
	}
}
