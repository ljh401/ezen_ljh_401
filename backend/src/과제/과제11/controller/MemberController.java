package 과제.과제11.controller;

import 과제.과제11.model.dao.MemberDao;
import 과제.과제11.model.dto.MemberDto;

public class MemberController {

private static MemberController memberController = new MemberController();
	
	public static MemberController getInstance() {return memberController;}
	
	private MemberController() {}
	
		// 2. 회원가입 처리 [ 반환 : 1. 성공 2. 실패[db오류] 3. 아이디중복실패 4. 전화번호중복실패 ]
		public int signupLogic(String id, String pw, String name, String phone) {
			
			
			// 1. 객체화 : 5개 매개변수들이 이동할때마다 매개변수의 코드가 길어지니까.. 패키지화!
			MemberDto memberDto = new MemberDto(0,id,pw,name,phone);
			
			// 1. 아이디 중복체크
			if(MemberDao.getInstance().infoCheck("mid", id)) return 3;		
			// 2. 전화번호 중복체크
			if(MemberDao.getInstance().infoCheck("mphone", phone))return 4;			
			
				// 1. 회원가입시 회원번호는 자동이므로 필요x 기본값 0
			// 2. Dao에게 전달하고 SQL결과 받기
			boolean result = MemberDao.getInstance().signupSQL(memberDto);
			
			// 3. 결과를 View에게 전달
			if(result) return 1;
			else return 2;
			
		}
		// 0. 로그인된 회원의 번호(pk식별용)를 저장하는 필드 = 웹세션
		private int loginSession = 0; // 0: 로그인 안한 상태 1이상 : 로그인된 회원의 번호
		public int getLoginSession () { return loginSession; }
		
		// 3-1. 로그인 처리
		public boolean loginLogic(String id, String pw) {
			
			
			// 1. 매개 변수가 2개라서 객체화 해도 되고 안해도 됌 [선택]
			int result = MemberDao.getInstance().loginSQL(id,pw);
			// 로그인 성공했을때 기록하기[ - 로그인 이후 로그인된 정보로 활동 ]
			if(result >= 1) {this.loginSession = result; return true;}
			else { return false;}
		}
		
		// 3-2. 로그아웃 처리
		public void logOut() {this.loginSession = 0;}
		
		// 4. 아이디 찾기
		public String findById(String name , String phone) {
			// - view 전달받은 매개변수 확인
			System.out.println("view value :" + name + phone);
			
			// Dao에게 매개변수 전달하고 찾은 아이디 반환 받기
			String result = 
					MemberDao.getInstance().findById(name, phone);
			return result;
		}
		
		// 5. 비밀번호 찾기
		public String findByPw(String id, String phone) {
			// - view 전달받은 매개변수 확인
			System.out.println("view value :" + id + phone);
			// Dao에게 매개변수 전달하고 찾은 비밀번호 반환 받기
			String result = 
					MemberDao.getInstance().findByPw(id, phone);
			return result;
		}
		
		// 6. 회원정보 보기
		   public MemberDto info() {
			   // 현재 로그인된 회원번호[loginSession] 는 view에서 전달 받지 않고 컨트롤 안에 저장
			   // 현재 로그인된 회원번호로 회원번호 요청하기
			   return MemberDao.getInstance().info(this.loginSession);
		   }
		   
		   
		// 7. 비밀번호 수정
		   public boolean infoUpdate(String newPw) {
			   return MemberDao.getInstance().infoUpdate(newPw, loginSession);
		   }
		   
		// 8. 회원 탈퇴
		   public boolean infoDelete() {
			   return MemberDao.getInstance().infoDelete(loginSession);
		   }
		
}
