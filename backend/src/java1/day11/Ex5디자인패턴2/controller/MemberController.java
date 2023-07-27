package java1.day11.Ex5디자인패턴2.controller;

import java1.day11.Ex5디자인패턴2.model.dao.MemberDao;
import java1.day11.Ex5디자인패턴2.model.dto.MemberDto;

public class MemberController { // 기능처리(로직) 담당하는 클래스 // controller -> java
	
	// 1. 싱글톤 생성 [ private static ]
	private static MemberController memberController = new MemberController();
	// 2. 외부로부터 싱글톤 호출할수 있도록 get~
	public static MemberController getInstance() {return memberController;}
	// 3. 외부에서 객체 생성 차단 위한 생성자 잠금
	private MemberController() {}
	
	public boolean signupLogic(String id , String password , String name , String phone, int age) {
		MemberDto m = new MemberDto(id,password,name,phone,age);
		for(int i = 0; i<MemberDao.memberList.length; i++) {
			if(MemberDao.memberList[i] == null) {
				MemberDao.memberList[i] = m; return true;
			
			}
		} // for end
		return false;
	}
	public boolean loginLogic(String id , String password) {
		
		for(int i = 0; i<MemberDao.memberList.length; i++) {
			if(MemberDao.memberList[i] !=null 
					&& MemberDao.memberList[i].getId().equals(id)
					&& MemberDao.memberList[i].getPassword().equals(password)) {
			
			
				return true;
			}
		}
		return false;
	}
	public String findIdLogic(String name , String phone) {
		for(int i = 0; i<MemberDao.memberList.length; i++) {
			if(MemberDao.memberList[i] !=null &&
					MemberDao.memberList[i].getName().equals(name) 
					&& MemberDao.memberList[i].getPhone().equals(phone)) {
				
				
				return MemberDao.memberList[i].getId();
			}
		}
			return null;
	}
	public String findPwLogic(String id, String phone) {
		for(int i = 0; i<MemberDao.memberList.length; i++) {
			if(MemberDao.memberList[i] !=null &&
					MemberDao.memberList[i].getId().equals(id) 
					&& MemberDao.memberList[i].getPhone().equals(phone)) {
						
				String password = "";
				
				for(int j = 0; j<4; j++ ) {
					password += (char)((int)(Math.random()*26)+65);
				};
				MemberDao.memberList[i].setPassword(password);
				return password;
			}
		}
		
		 return null;
	}
}
