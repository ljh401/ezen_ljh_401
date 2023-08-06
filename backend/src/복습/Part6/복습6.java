package 복습.Part6;

import java.util.Scanner;

public class 복습6 {
	
	static Test생성자[] memberList = new Test생성자[100];
	static Scanner scanner = new Scanner(System.in);
	static int login = -1;
	public static void main(String[] args) {
		
		
		while(true)	{
			System.out.println("\n\n------- 회원 시스템---------");
			System.out.print("1회원가입2로그인3아이디찾기4비밀번호찾기 선택>");
			int ch = scanner.nextInt();
			
			if(ch==1) {회원가입();}
			else if(ch==2) {로그인();}
			else if(ch==3) {아이디찾기();}
			else if(ch==4) {비밀번호찾기();}
		}
	}
	
	static void 회원가입() {
		System.out.println("---------회원가입------------");
		System.out.print("아이디 :"); String id = scanner.next();
		System.out.print("비밀번호 :"); String pw = scanner.next();
		System.out.print("이름 :"); String name = scanner.next();
		System.out.print("전화번호 :"); String phone = scanner.next();
		System.out.print("나이 :"); int age = scanner.nextInt();
		
		Test생성자 member = new Test생성자(id,pw,name,phone,age);
		
		for(int i = 0; i<memberList.length; i++) {
			if(memberList[i] == null) {
				memberList[i] = member;
				break;
			}
		}
	}
	static void 로그인() {
		System.out.println("---------로그인------------");
		System.out.print("아이디 :"); String id = scanner.next();
		System.out.print("비밀번호 :"); String pw = scanner.next();
		
		for(int i = 0; i<memberList.length; i++) {
			if(memberList[i] != null && memberList[i].id.equals(id) && memberList[i].pw.equals(pw)) {
				login = i;
				break;
			}
		}
		if(login >=0) {System.out.println("로그인성공");}
		else {System.out.println("로그인실패");}
	}
	static void 아이디찾기() {
		System.out.println("---------아이디찾기------------");
		System.out.print("이름 :"); String name = scanner.next();
		System.out.print("전화번호 :"); String phone = scanner.next();
		
		for(int i = 0; i<memberList.length; i++) {
			if(memberList[i] != null && memberList[i].name.equals(name) && memberList[i].phone.equals(phone)) {
					System.out.println("아이디 찾았습니다" + memberList[i].id);
					return;
			}
		}
		System.out.println("아이디 찾기 실패");
	}
	static void 비밀번호찾기() {
		System.out.println("---------비밀번호 찾기------------");
		System.out.print("아이디 :"); String id = scanner.next();
		System.out.print("전화번호 :"); String phone = scanner.next();
		
		for(int i = 0; i<memberList.length; i++) {
			if(memberList[i] != null && memberList[i].id.equals(id) && memberList[i].phone.equals(phone)) {
					System.out.println("비밀번호 찾았습니다" + memberList[i].pw);
					return;
			}
		}
		System.out.println("비밀번호 찾기 실패");
	}
	
	
}
