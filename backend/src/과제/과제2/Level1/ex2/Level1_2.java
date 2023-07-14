package 과제.과제2.Level1.ex2;

import java.time.LocalDateTime;

public class Level1_2 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level1_2 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		System.out.printf("%-10s   %15s   %30s\n" , "type" , "value" , "range" );
		System.out.println("-------------------------------------------------------------");
		/* 문제풀이 위치 */
		
		boolean 논리 = true;
		byte 바이트 = 100;
		char 문자 = 'A';
		short 쇼트 = 30000;
		int 인트 = 2000000000;
		long 롱 = 40000000000L;
		float 플롯 = 3.1231232f;
		double 더블 = 3.123123123d;
		
		System.out.printf("%-10s   %15s   %30s\n" , "boolean" , 논리 , "true or false");
		System.out.printf("%-10s   %15s   %30s\n" , "byte" , 바이트 , "-128 ~ 127");
		System.out.printf("%-10s   %15s   %30s\n" , "char" , 문자 , "0~65535[ character 1]");
		System.out.printf("%-10s   %15s   %30s\n" , "short" , 쇼트 , "-32768 ~ 32767");
		System.out.printf("%-10s   %15s   %30s\n" , "int" , 인트 , "+-2000 million");
		System.out.printf("%-10s   %15s   %30s\n" , "long" , 롱 , "+-2000 million Excess");
		System.out.printf("%-10s   %15s   %30s\n" , "float" , 플롯 , "8 decimal places");
		System.out.printf("%-10s   %15s   %30s\n" , "double" , 더블 , "17 decimal places");
		/* ----------- */
	}
}
/* 
	[문제] 그림과 같이 기본자료형을 이용하여 변수 8개 선언하고 임의값을 대입하여 출력하시오.
	[조건] 
		1. 모든 기본자료형 8개 사용
		2. printf() 메소드 사용
*/
