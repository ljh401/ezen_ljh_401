package 복습.Part5;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		Test생성자[] memberList = new Test생성자[100];
		
		while(true) {
			System.out.println("\n\n-------------회원 시스템------------");
			System.out.println("1회원가입2로그인");
			System.out.print("선택>");
			int ch = scanner.nextInt();
			
			if(ch == 1) {
				System.out.println("-------------회원가입------------");
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
			else if(ch == 2) {
				System.out.println("-------------로그인------------");
				System.out.print("아이디 :"); String id = scanner.next();
				System.out.print("비밀번호 :"); String pw = scanner.next();
				
				int login = -1;
				for(int i = 0; i<memberList.length; i++) {
					if(memberList[i] != null &&
							memberList[i].id.equals(id) &&
							memberList[i].pw.equals(pw)) {
						login = i;
						break;
					}
				}
				
				if(login >= 0) {System.out.println("로그인성공");}
				else {System.out.println("로그인실패");}
			}
		}
		
	}
}
