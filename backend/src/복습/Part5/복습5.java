package 복습.Part5;

import java.util.Arrays;
import java.util.Scanner;

// 목적 : 실행
public class 복습5 {

	public static void main(String[] args) {
		
		
		복습5생성자[] memberList = new 복습5생성자[100];
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println(Arrays.toString(memberList));
			System.out.println("\n\n-----------회원시스템----------");
			System.out.print("1. 회원가입 2. 로그인 선택 >");
			
			int ch = sc.nextInt();
			
			if(ch == 1) {
				System.out.println("-----------회원가입----------");
				
				System.out.println("아이디 :"); String inputId = sc.next();
				System.out.println("비밀번호 :"); String inputPw = sc.next();
				System.out.println("이름 :"); String inputName = sc.next();
				System.out.println("전화번호 :"); String inputPhone = sc.next();
				System.out.println("나이 :"); int inputAge = sc.nextInt();
				
				복습5생성자 member = new 복습5생성자(inputId,inputPw,inputName,inputPhone,inputAge);	
				
				for(int i = 0; i<memberList.length; i++	 ) {
					if(memberList[i] == null) {
						memberList[i] = member; break;
					}
				} 
			}
			else if(ch == 2) {
				System.out.println("-----------로그인----------");
				System.out.println("아이디 :"); String inputId = sc.next();
				System.out.println("비밀번호 :"); String inputPw = sc.next();
				
				int login = -1; 
				for(int i = 0; i<memberList.length; i++) {
					if(memberList[i] != null && 
							memberList[i].id.equals(inputId) && 
							memberList[i].password.equals(inputPw)) {
						login = i;
						break;
					} 
				}
				
				if(login >= 0) {System.out.println("로그인성공");} // 추후 로그인시 새로운 메뉴 메소드 호출
				else {System.out.println("안내) 로그인 실패"); }				
			} 		
		} 		
	}
}
