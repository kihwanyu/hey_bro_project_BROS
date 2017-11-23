package Controller;

import Model.dao.MemberDAO;


public class Controller {
	MemberDAO mDao = new MemberDAO();
	public void process(String key, String userId, String userPw, 
			String userName, String birthday, String email, String pictureUrl){
		switch (key) {
		case "MemberRegister.do" :
			mDao.memberRegister(userId, userPw, userName, birthday, email, pictureUrl);
			break;
			
		default:
			break;
		}
	}
	//�Լ� ��ø(�����ε�)
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
	//�Լ� ��ø(�����ε�)
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
}