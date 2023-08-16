package 과제.과제11.view;

import java.util.Scanner;

import 과제.과제11.controller.MemberController;



public class MainPage {
	// 0. 싱글톤
	private static MainPage mainPage = new MainPage();
	
	public static MainPage getInstance() {return mainPage;}
	
	private MainPage() {}
	
	// 0. 입력객체
	private Scanner scanner = new Scanner(System.in);
	
	// 1. 메인메뉴
	public void mainView() {
		while(true) {
			System.out.println("\n\n ===== 회원제 커뮤니티 ======");
			System.out.print("1. 회원가입 2. 로그인 선택 3. 아이디찾기 4. 비밀번호 찾기:");
			try {
			int ch = scanner.nextInt(); // 만약에 타입과 일치하지 않는 값을 입력하면 InputMismatchException
			if( ch == 1) {signupView();}
			if( ch == 2) {loginView();}
			if( ch == 3) {findById();}
			if( ch == 4) {findByPw();}
			} catch(Exception e) {
				System.out.print("경고] 잘못 입력했습니다.");
				scanner = new Scanner(System.in); // 입력 객체의 메모리를 새롭게 만들어주기 
			}
		}
	}
	public void MainView() {
		
	}
	
	// 2. 회원가입
	public void signupView() {
		System.out.println("-----------회원가입페이지-----------");
		System.out.print("아이디 입력 :");String id = scanner.next();
		System.out.print("비밀번호 입력 :");String pw = scanner.next(); 
		System.out.print("이름 입력 :");String name = scanner.next(); 
		System.out.print("전화번호 입력 :");String phone = scanner.next();
		
		int result = MemberController.getInstance().signupLogic(id,pw,name,phone);
		
		if(result == 1) {System.out.println("안내] 회원가입 성공했습니다. 감사합니다.");}
		else if(result == 2) {System.out.println("안내] 회원가입 실패했습니다. 관리자에게 문의하세요.");}
		else if(result == 3) {System.out.println("안내] 회원가입 실패했습니다. 아이디 중복.");}
		else if(result == 4) {System.out.println("안내] 회원가입 실패했습니다. 전화번호 중복.");}
	}
	// 3. 로그인
	public void loginView() {
		System.out.println("-----------로그인페이지-----------");
		System.out.print("아이디 입력 :");String id = scanner.next();
		System.out.print("비밀번호 입력 :");String pw = scanner.next(); 
		boolean result = MemberController.getInstance().loginLogic(id,pw);
		
		if(result) {System.out.println("로그인성공");
			LoginPage.getInstance().loginMenu();
		}
		else {System.out.println("로그인실패");}
	}
	
	// 4. 
	public void findById() {
		System.out.println("-----------아이디찾기 페이지-----------");
		System.out.print("이름 입력 :");String name = scanner.next();
		System.out.print("전화번호 입력 :");String phone = scanner.next(); 
		
		String result = MemberController.getInstance().findById(name, phone);
		
		if( result != null) {System.out.println("회원 아이디" + result);}
		else {System.out.println("정보 일치하는 아이디 없음");}
	}
	
	// 5. 
	public void findByPw() {
		System.out.println("-----------비밀번호찾기 페이지-----------");
		System.out.print("아이디 입력 :");String id = scanner.next();
		System.out.print("전화번호 입력 :");String phone = scanner.next(); 
		
		String result = MemberController.getInstance().findByPw(id,phone);
		
		if( result != null) {System.out.println("회원 비밀번호" + result);}
		else {System.out.println("정보 일치하는 비밀번호 없음");}
	}
	
}
