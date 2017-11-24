package Controller;

import Model.dao.MemberDAO;
import Model.vo.Member;
import Model.vo.Session;

public class Controller {
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
		case "MemberSetting.do" :
			
			break;
		default:
			break;
		}
		return result;
	}
	
	//메소드 중첩(오버로딩)
	public Boolean process(String key, String userId, String userPw){
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
			default:
				break;
			}
			return member;
		}
	//메소드 중첩(오버로딩)
		public Boolean process(String key, Member member){
			Boolean result = false;
			switch (key) {
			case "MemberUpdate.do":
				result = mDao.memberUpdate(member);
				break;
			default:
				break;
			}
			return result;
		}
	
}