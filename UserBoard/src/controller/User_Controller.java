package controller;

import java.util.ArrayList;

import model.UserDTO;

public class User_Controller {
	
	private static ArrayList<UserDTO> userList = new ArrayList<>();
	
	public String idPsCheck(String id, String ps) {
		
	}
	
	public void adminAccount() {
		UserDTO ud = new UserDTO();
		
		ud.setUserId(userList.size());
		ud.setUserAccountName("admin");
		ud.setUserPassword("admin");
		ud.setUserNickname("어드민");
		
		userList.add(ud);
	}
	
	public void intoList(UserDTO ud) {
		
		ud.setUserId(userList.size());
		System.out.println("# " + (userList.size() + 1) + "번째 계정 ");
		userList.add(ud);
		
		System.out.println("# 계정 넘버 " + userList.size() +"의 AccountName : " + userList.get((userList.size() - 1)).getUserAccountName());
	}

}
