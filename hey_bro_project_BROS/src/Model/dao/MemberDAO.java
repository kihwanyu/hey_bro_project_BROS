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

import Model.vo.Member;
import Model.vo.Session;

public class MemberDAO {
	Properties prop = new Properties();
	ArrayList<String> userIdList = new ArrayList<>();
	//회원가입
	public void memberRegister(String userId, String userPw, 
			String userName, String birthday, String email, String pictureUrl){
		Map<Integer,Member> memberMap = new HashMap<>();
		
		// registered 등록된
		String rUserId;
		String rUserPw;
		String rUserName;
		String rBirthday;
		String rEmail;
		String rPictureUrl;
		
		try {
			prop.loadFromXML(new FileInputStream("hey_bro_project_BROS\\src\\Model\\Data\\xml\\members.xml"));
			System.out.println(prop.size());
			for(int i = 0; i < prop.size(); i++){
				String str;
				
				String[] str_arr = new String[6];
				
				//System.out.println(prop.getProperty(String.valueOf(i).toString()));
				str = prop.getProperty(String.valueOf(i).toString());
				if(str!=null){
					//System.out.println(str);
					str_arr = str.split(", ");
					for(String s : str_arr){
						System.out.println(s);
					}
					
					rUserId = str_arr[0];
					rUserPw = str_arr[1];
					rUserName = str_arr[2];
					rBirthday = str_arr[3];
					rEmail = str_arr[4];
					rPictureUrl = str_arr[5];	
					
					Member member = new Member(rUserId, rUserPw, rUserName, rBirthday, rEmail, rPictureUrl);
					memberMap.put(memberMap.size(), member);					
				}
			}	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		memberMap.put(memberMap.size(),new Member(userId, userPw, userName, birthday, email, pictureUrl));
	
		Set<Integer> keys = memberMap.keySet();
		Iterator<Integer> memIter = keys.iterator();
		
		try {
			while(memIter.hasNext()){
				int key = memIter.next();
				prop.setProperty(String.valueOf(key).toString(), memberMap.get(key).toString());
			}
			
			prop.storeToXML(new FileOutputStream("hey_bro_project_BROS\\src\\Model\\Data\\xml\\members.xml"),String.valueOf(new Date()).toString());
			//System.out.println("성공적으로 회원가입이 완료되었습니다.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	//회원가입 - 중복검사
	public boolean MemberIdOverlap(String userId){
		String rUserId;
		try {
			prop.loadFromXML(new FileInputStream("hey_bro_project_BROS\\src\\Model\\Data\\xml\\members.xml"));
			System.out.println(prop.size());
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
				//System.out.println("중복되었습니다.");
				return false;
			}
		}
		return true;
	}
	//로그인 중복 검사
	public boolean Login(String userId, String userPw){
		ArrayList<Session> sessionList = new ArrayList<>();
		
		String rUserId;
		String rUserPw;
		try {
			prop.loadFromXML(new FileInputStream("hey_bro_project_BROS\\src\\Model\\Data\\xml\\members.xml"));
			System.out.println(prop.size());
			for(int i = 0; i < prop.size(); i++){
				String str;
				
				String[] str_arr = new String[6];
				
				str = prop.getProperty(String.valueOf(i).toString());
				if(str!=null){

					str_arr = str.split(", ");
	
					
					rUserId = str_arr[0];
					rUserPw = str_arr[1];
					//용도는 다르지만 아이디와 비밀번호를 묶어 놓을 수 있어서 세션 클래스를 사용한다.
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
				//System.out.println("로그인성공.");
				return true;
			}
		}
		return false;
	}
}
