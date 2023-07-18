package java1.day04;

import java.util.Scanner;

public class Ex2_확인문제7 { // class s
	public static void main(String[] args) { // main s
		
		Scanner scanner = new Scanner(System.in);
		
			boolean run = true;
			int 예금액 = 0;

			
			
			while ( run ) { // while s
			 System.out.println("----------------------------------");
	         System.out.println(" 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료 ");
	         System.out.println("----------------------------------");
	         System.out.print("선택 >");
	         int 선택 = scanner.nextInt();

	        
	         if ( 선택==1 ) { 
	            System.out.print("예금액 > ");
	            예금액 += scanner.nextInt();
	         }else if ( 선택==2 ) { 
	        	 System.out.print("출금액 > ");
		            예금액 -= scanner.nextInt();
	         }else if ( 선택==3 ) { 
	        	 System.out.println("잔고 > " + 예금액);
		           
	         } else if ( 선택==4) {
	        	
	        	 System.out.println("\n 프로그램 종료");
	        	
	        	 run = false;
	        	 }
		} // while e
		
	} // main e
} // class e


/*

주제 : 키오스크(변수버전)
	- 실행예시 사진은 없습니다.
	조건 
	1. 제품 가격
		int 콜라가격 = 300 ;	int 환타가격 = 200 ;	int 사이다가격 = 100 ; 
	
	2. 제품 초기 재고
		콜라 10개	, 사이다 10개 , 환타 10개      * 판매시 재고 차감되고 다시 채우기 안됩니다.
		int 콜라재고 = 10 ; 	int 환타재고 = 10 ; 	int 사이다재고 = 10;
		
	3. 키오스크 메뉴 [ 무한루프 : 종료 없음(24시간) ] 
		1. 콜라 2.사이다 3.환타 4.결제
		[ 1~3 선택시 ]
			- 재고가 있을경우 장바구니 담기 / 없으면 '재고부족' 출력
			 
		[ 4 선택시 ] 
			- 현재 장바구니 현황 표시 목록 
			----------------------------------
			제품명	수량	가격
			사이다	1	400
			환타		2	1000
			총가격 : 1400
			- 결제메뉴 표시
				1. 결제 2.취소 
				[결제]
					- 금액 입력받아 총가격에 뺀 잔액 출력 -> 결제 성공시 장바구니 초기화 
					- 만약에 금액이 부족하면 결제 취소 -> 장바구니 초기화 / 재고 다시 되돌리기
				[취소]
					- [ 장바구니 초기화 / 재고 다시 되돌리기 ]

*/

