package Controller;

import java.util.ArrayList;

import Model.dao.GroupDAO;
import Model.dao.MemberDAO;
import Model.vo.Group;
import Model.vo.Member;
import Model.vo.Session;

public class Controller {
	//Member
	MemberDAO mDao = new MemberDAO();
	
	Member member;
	public void process(String key, String userId, String userPw, String userName
			, String userGender, String birthday, String email, String pictureUrl){
		switch (key) {
		case "MemberRegister.do" :
			mDao.memberRegister(userId, userPw, userName, userGender, birthday, email, pictureUrl);
			break;
			
		default:
			break;
		}
	}
	//Group
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
	public Boolean process(String key, String userId){
		Boolean result = true;
		switch (key) {
		case "MemberIdOverlap.do" :
			result = mDao.MemberIdOverlap(userId);
			break;
		default:
			break;
		}
		return result;
	}
	
	//메소드 중첩(오버로딩)
	public Boolean process(String key, String type1, String type2){
		//String key, String Pw, String session
		Boolean result = false;
		switch (key) {
		case "Login.do":
			result = mDao.Login(type1, type2);
			break;
		case "rLogin.do":
			result = gDao.rLogin(type1, type2);
			break;
		case "groupJoin.do":
			result = gDao.groupJoin(type1, type2);
			break;
		default:
			break;
		}
		return result;
	}
	//메소드 중첩(오버로딩)
		public Member process(String key, Session session){
			Member member = new Member();
			switch (key) {
			case "MemberSatting.do":
				member = mDao.memberSetting(session);
				break;
			case "MemberDelete.do":
				mDao.memberDelete(session);
				break;
			default:
				break;
			}
			return member;
		}
	//메소드 중첩(오버로딩)
		public void process(String key, Member member){
			switch (key) {
			case "MemberUpdate.do":
				mDao.memberUpdate(member);
				break;
			default:
				break;
			}
		}
		public String process(String key, String type, String birthday, String email){
			String result = null;
			switch (key) {
			case "FindIdMember.do":
				result = mDao.findIdMember(type, birthday, email);
				break;
			case "FindPwMember.do":
				result = mDao.findPwMember(type, birthday, email);
				break;
			default:
				break;
			}
			return result;
		}
		public ArrayList<String> process(String key, String userId, int type){
			ArrayList<String> groupList = new ArrayList();
			switch (key) {
			case "GroupListSearch.do" :
				groupList = gDao.groupListSearch(userId,type);
				break;
			default:
				break;
			}
			return groupList;
		}
		
		
}