package 과제.과제2.Level1.ex7;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level1_7 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level1_7 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
		
		String output = "";
		
		/* 문제풀이 위치 */
		System.out.print("회원명 String : ");
		String 회원명 = scanner.next();
		
		System.out.print("상태 boolean : ");
		boolean 상태 = scanner.nextBoolean();
		
		System.out.print("회원번호 byte : ");
		byte 회원번호 = scanner.nextByte();
		
		System.out.print("성별 char : ");
		char 성별 = scanner.next().charAt(0);
		
		System.out.print("나이 short : ");
		short 나이 = scanner.nextShort();
	
		System.out.print("포인트 int : ");
		int 포인트 = scanner.nextInt();
		
		System.out.print("예금액 long : ");
		long 예금액 = scanner.nextInt();
		
		System.out.print("키 float : ");
		float 키 = scanner.nextFloat();
		
		System.out.print("몸무게 double : ");
		double 몸무게 = scanner.nextDouble();
		
		System.out.println("==========회원 개인정보==========");
		System.out.printf("%-5s   %10s   %7s\n" , "|" ,"회원명 : " + 회원명, "|");
		System.out.printf("%-5s   %10s   %9s\n" , "|" ,"상태 : " + 상태, "|");
		System.out.printf("%-5s   %10s   %8s\n" , "|" ,"회원번호 : " + 회원번호, "|");
		System.out.printf("%-5s   %7s   %12s\n" , "|" ,"성별 : " + 성별, "|");
		System.out.printf("%-5s   %8s   %11s\n" , "|" ,"나이 : " + 나이, "|");
		System.out.printf("%-5s   %11s   %8s\n" , "|" ,"포인트 : " + 포인트, "|");
		System.out.printf("%-5s   %11s   %6s\n" , "|" ,"예금액 : " + 예금액, "|");
		System.out.printf("%-5s   %9s   %11s\n" , "|" ,"키 : " + 키, "|");
		System.out.printf("%-5s   %11s   %8s\n" , "|" ,"몸무게 : " + 몸무게, "|");
		System.out.println("=============================");

		/* ----------- */
	}
}
/* 
	[문제조건] 
		1. 문제풀이 위치 외 코드는 수정 불가 합니다.
		2. 기본 자료형8개 + 문자열클래스 변수 1개 를 이용한 9개변수를 입력 받습니다.
		3. 입력받은 9개 변수를 그림과 같이 출력합니다.
		4. 기존에 미리 작성된 변수를 최대한 활용합니다.
		
*/
