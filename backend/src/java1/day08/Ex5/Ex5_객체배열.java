package java1.day08.Ex5;

import java.util.Scanner;

public class Ex5_객체배열 { // class s
	public static void main(String[] args) { // main s
		
		Member[] memberList = new Member[100];// 100개 문자열 저장할수 있는 배열 선언
		
		while(true) { // w s
			
			System.out.println("1.회원가입 :");
			Scanner sc = new Scanner(System.in);
			int ch = sc.nextInt();
			if(ch == 1) {
				System.out.print("아이디 : ");		String id = sc.next();
				System.out.print("비밀번호 : ");		String pw = sc.next();
				System.out.println("이름 : ");       	String name = sc.next();
				// 1. 객체화 = 클래스명 객체변수명 = new 생성자명();
				Member m = new Member(); // 1. 객체 생성
				m.id = id;				 // 2. 생성된 객체로부터 .접근연산자를 이용한 필드 수정
				m.pw = pw;
				m.name = name;
				// 2. 배열에 저장
				for(int i = 0; i<memberList.length; i++) {
					if(memberList[i] == null) {
						memberList[i] = m;
						break;
					}
				}
			} // if end
			
			
		} // w e
		
		
	} // main e
} // class e
