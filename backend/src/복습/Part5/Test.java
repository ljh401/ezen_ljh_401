package 복습.Part5;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		
		Test생성자[] memberList = new Test생성자[100];
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("\n\n------회원시스템-------");
			System.out.print("1회원가입2로그인");
			int ch = scanner.nextInt();
			
			
			if(ch == 1) {
			System.out.println("---------회원가입---------");
			System.out.print("아이디 :"); String inputId = scanner.next();
			System.out.print("비밀번호 :"); String inputPw = scanner.next();
			System.out.print("이름 :"); String inputName = scanner.next();
			System.out.print("전화번호 :"); String inputPhone = scanner.next();
			System.out.print("나이 :"); int inputAge = scanner.nextInt();
			
			Test생성자 member = new Test생성자(inputId,inputPw,inputName,inputPhone,inputAge);
			
			for(int i =0; i<memberList.length; i++) {
				if(memberList[i] == null) {
					memberList[i] = member; break;
				}
			}

		}
			
			else if(ch == 2) {
				System.out.println("---------로그인---------");
				System.out.print("아이디 :"); String inputId = scanner.next();
				System.out.print("비밀번호 :"); String inputPw = scanner.next();
				
				int login = -1;
				for(int i =0; i<memberList.length; i++) {
					if(memberList[i] != null && memberList[i].id.equals(inputId) && memberList[i].pw.equals(inputPw)) {
						login = i; break;
					}
				}
				
				if(login >= 0) {System.out.println("로그인성공");}
				else {System.out.println("로그인실패");}
			}
	}

}
}
