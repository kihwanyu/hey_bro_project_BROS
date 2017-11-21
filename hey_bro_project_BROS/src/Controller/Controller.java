package Controller;

import Model.dao.LoginDao;
import Model.dao.MemberRegisterDao;


public class Controller {
	MemberRegisterDao mad = new MemberRegisterDao();
	public Controller(String key){
		switch (key) {
		case "MemberRegister.do" :
		new MemberRegisterDao();
		break;
		case "Login.do":
			new LoginDao();
			break;

		default:
			break;
		}
	}
}
