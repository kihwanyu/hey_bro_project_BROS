package Model.dao;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import Model.vo.Member;

public class MemberRegisterDao {
	public MemberRegisterDao(){
		Map<String,Member> memberMap = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		Properties prop = new Properties();
		
		String userId;
		String userPw;
		String userName;
		String birthday;
		String phone;
		String email;
	
		
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
					/*for(String s : str_arr){
						System.out.println(s);
					}*/
					
					userId = str_arr[0];
					userPw = str_arr[1];
					userName = str_arr[2];
					birthday = str_arr[3];
					phone = str_arr[4];
					email = str_arr[5];	
					
					Member member = new Member(userId, userPw, userName, birthday, phone, email);
					memberMap.put(userId, member);					
				}
			}	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("ȸ������");
		System.out.print("ȸ���� ���̵� �Է����ּ���. = ");
		userId = sc.nextLine();
		System.out.print("ȸ���� ��й�ȣ�� �Է����ּ���. = ");
		userPw = sc.nextLine();
		System.out.print("ȸ���� �̸��� �Է����ּ���. = ");
		userName = sc.nextLine();
		System.out.print("ȸ���� ��������� �Է����ּ���. = ");
		birthday = sc.nextLine();
		System.out.print("ȸ���� �ڵ����� �Է����ּ���. = ");
		phone = sc.nextLine();
		System.out.print("ȸ���� �̸����� �Է����ּ���. = ");
		email = sc.nextLine();
		
		memberMap.put(userId,new Member(userId, userPw, userName, birthday, phone, email));
		
		Set<String> keys = memberMap.keySet();
		Iterator<String> memIter = keys.iterator();
		
		try {
			while(memIter.hasNext()){
				String key = memIter.next();
				prop.setProperty(key, memberMap.get(key).toString());
				//System.out.println(memberMap.get(key).toString());
			}
			
			prop.storeToXML(new FileOutputStream("hey_bro_project_BROS\\src\\Model\\Data\\members.xml"),String.valueOf(new Date()).toString());
			System.out.println("���������� ȸ�������� �Ϸ�Ǿ����ϴ�.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
