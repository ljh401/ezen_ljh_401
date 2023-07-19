package 과제.과제4.Level3.ex6;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class Level3_6 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level3_6 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
		
		/* 문제풀이 위치 */
		
		String 좌석1 = " ";
		String 좌석2 = " ";
		String 좌석3 = " ";
		String 좌석4 = " ";
		String 좌석5 = " ";
		String 좌석6 = " ";
		
		while (true) {
			
			System.out.println(" 메뉴 : 1.예약하기 2.예약취소 3.예약현황 ");
			int 메뉴 = scanner.nextInt();
			
			if( 메뉴 == 1) {
				System.out.println("예약좌석 선택");
				System.out.println("[1][2][3]\n[4][5][6]");
				int 예약 = scanner.nextInt();
				
				if( 예약 == 1) {
					if(좌석1.equals(" ")) {System.out.println("예약성공");
					좌석1 = "예약";}  else {System.out.println("예약실패");}
				}
				if( 예약 == 2) {
					if(좌석2.equals(" ")) {System.out.println("예약성공");
					좌석2 = "예약";}  else {System.out.println("예약실패");}
				}
				if( 예약 == 3) {
					if(좌석3.equals(" ")) {System.out.println("예약성공");
					좌석3 = "예약";}  else {System.out.println("예약실패");}
				}
				if( 예약 == 4) {
					if(좌석4.equals(" ")) {System.out.println("예약성공");
					좌석4 = "예약";}  else {System.out.println("예약실패");}
				}
				if( 예약 == 5) {
					if(좌석5.equals(" ")) {System.out.println("예약성공");
					좌석5 = "예약";}  else {System.out.println("예약실패");}
				}
				if( 예약 == 6) {
					if(좌석6.equals(" ")) {System.out.println("예약성공");
					좌석6 = "예약";}  else {System.out.println("예약실패");}
				}
				
				
				
			}
			
			if (메뉴 == 2) {
				
			}
			
			if (메뉴 == 3) {
				
			}
		}
		
		
		
		

		
		
		/* ----------- */

	}
}
/* 
	주제 : 예약 좌석 시스템
	실행결과는 제공하지 않습니다.
	
	- 변수 조건 
		1. 변수 : 6개의 좌석 은 변수를 이용합니다. [ 배열X ]
		2. 그외 자유롭게 사용. 배열/리스트 사용 금지 [ day1~day4 문법 이용 ]
	- 메뉴 조건
		0. 메뉴 : 1.예약하기 2.예약취소 3.예약현황 
	- 기능 조건 
	 	예약하기 출력예시 )
	 		1. 예약할 좌석을 선택한다.
	 		2. 만약에 비어 있으면 예약성공 아니면 예약 실패 
	 	예약취소 출력예시 )
	 		1.  취소할 좌석을 선택한다.
	 	예약현황 출력예시 )
	 		* 3개씩 2줄로 출력합니다.
			[ 예약 ]	[ ]	[ ]
			[ ] [예약] [ ]  
			- 예약이 되어 있는 좌석은 [예약] 예약이 없으면 [ ] 공란으로 출력합니다.
			
*/
