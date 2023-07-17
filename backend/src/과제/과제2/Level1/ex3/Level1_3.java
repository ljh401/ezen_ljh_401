package 과제.과제2.Level1.ex3;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level1_3 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level1_3 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
		/* 문제풀이 위치 */
		System.out.print("input boolean : ");
		boolean 논리 = scanner.nextBoolean();
		
		System.out.print("input byte : ");
		byte 바이트 = scanner.nextByte();
		
		System.out.print("input char : ");
		char 문자 = scanner.next().charAt(0);
		
		System.out.print("input short : ");
		short 쇼트 = scanner.nextShort();
		
		System.out.print("input int : ");
		int 인트 = scanner.nextInt();
	
		System.out.print("input long : ");
		long 롱 = scanner.nextLong();
		
		System.out.print("input float : ");
		float 플롯 = scanner.nextFloat();
		
		System.out.print("input double : ");
		double 더블 = scanner.nextDouble();
		
		System.out.print("output boolean : "+논리+"\n");
		System.out.print("output byte : "+바이트+"\n");
		System.out.print("output char :"+문자+"\n");
		System.out.print("output short : "+쇼트+"\n");
		System.out.print("output int : "+인트+"\n");
		System.out.print("output long : "+롱+"\n");
		System.out.print("output float : "+플롯+"\n");
		System.out.print("output double : "+더블);
		/* ----------- */
	}
}
/* 
	[문제] 그림과 같이 기본자료형을 이용하여 변수 8개를 출력하시오.
	[조건] 
		1. 모든 기본자료형 8개 사용
		2. print() 메소드 사용
		3. scanner 객체 사용하여 입력받기
*/
