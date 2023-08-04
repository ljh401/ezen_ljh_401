package 과제.과제11.controller;

import 과제.과제11.model.dao.MemberDao;
import 과제.과제11.model.dto.MemberDto;

public class MemberController {

private static MemberController memberController = new MemberController();
	
	public static MemberController getInstance() {return memberController;}
	
	private MemberController() {}
	
		// 2. 회원가입 처리
		public boolean signupLogic(String id, String pw, String name, String phone) {
			System.out.println("signupLogic 컨트롤 도착");
			System.out.println(id + pw + name + phone);
			// 유효성 검사 했다고 하고
			// 1. 객체화 : 5개 매개변수들이 이동할때마다 매개변수의 코드가 길어지니까.. 패키지화!
			MemberDto memberDto = new MemberDto(0,id,pw,name,phone);
				// 1. 회원가입시 회원번호는 자동이므로 필요x 기본값 0
			// 2. Dao에게 전달하고 SQL결과 받기
			boolean result = MemberDao.getInstance().signupSQL(memberDto);
			
			// 3. 결과를 View에게 전달
			return result;
			
		}
		// 3. 로그인 처리
		public boolean loginLogic(String id, String pw) {
			System.out.println("loginLogic 컨트롤 도착");
			System.out.println(id + pw);
			// 유호성 검사 했다 하고
			// 1. 매개 변수가 2개라서 객체화 해도 되고 안해도 됌 [선택]
			boolean result = MemberDao.getInstance().loginSQL(id,pw);
			
			return result;
		}
}
