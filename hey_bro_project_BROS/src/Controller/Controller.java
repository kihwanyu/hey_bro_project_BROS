package Controller;

import java.util.ArrayList;

import Model.dao.LoginDao;
import Model.dao.MemberAddDao;
import Model.vo.Member;

public class Controller {
	MemberAddDao mad = new MemberAddDao();
	public Controller(String key){
		switch (key) {
		case "MemberAdd.dao" :
		
		mad.MemberAdd();
		break;
		case "Login.dao":
			new LoginDao();
			break;

		default:
			break;
		}
	}
}
