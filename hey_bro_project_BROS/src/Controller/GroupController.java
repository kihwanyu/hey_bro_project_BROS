package Controller;

import java.util.ArrayList;

import Model.dao.GroupDAO;
import Model.vo.Group;
import Model.vo.Session;

public class GroupController {
	GroupDAO gDao = new GroupDAO();
	Group group;


	public void process(String key, String gName, String interests, String pw, String content, String news, String leader){
		switch (key) {
		case "GroupRegister.do" :
			gDao.groupRegister(gName, interests, pw, content, news, leader);
			break;

		default:
			break;
		}
	}
	//메소드 중첩(오버로딩)
	public Boolean process(String key, String groupPw, String session){
		//
		Boolean result = false;
		switch (key) {

		case "rLogin.do":
			System.out.println("rLogin.do");
			result = gDao.rLogin(groupPw, session);
			break;
		case "groupJoin.do":
			result = gDao.groupJoin(groupPw, session);
			break;
		default:
			break;
		}
		return result;
	}
	public ArrayList<String> process(String key, String userId){
		ArrayList<String> groupList = new ArrayList<>();
		switch (key) {
		case "GroupListSearch.do" :
			groupList = gDao.groupListSearch(userId);
			break;
		case "groupCombo.do" :
			groupList = gDao.groupCombo(userId);
		default:
			break;
		}
		return groupList;
	}
	public void process(String key, Group group){
		switch (key){
		case "GroupUpdate.do" :
			gDao.groupUpdate(group);
			break;

		default : 
			break;
		}
	}

	public Group process(String key, String gName, boolean type){
		Group group = new Group();
		switch(key){
		case "GroupSetting.do" :
			group = gDao.groupSetting(gName);//
			break;

		default :
			break;
		}

		return group;
	}
}