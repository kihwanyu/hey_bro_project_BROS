package Controller;

import java.util.ArrayList;

import Model.dao.GroupDAO;
import Model.vo.Group;

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
}