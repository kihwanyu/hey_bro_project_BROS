package Controller;

import Model.dao.MemberDAO;
import Model.vo.Member;
import Model.vo.Session;

public class MemberController {
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
	public Boolean process(String key, String userId, String userPw){
		//String key, String Pw, String session
		Boolean result = false;
		switch (key) {
		case "Login.do":
			result = mDao.Login(userId, userPw);
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
}