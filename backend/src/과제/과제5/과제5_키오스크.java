package 과제.과제5;

import java.util.Scanner;

public class 과제5_키오스크 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String 재고관리 = "";
		
		
		// 1. 9개 변수가 가지고 있떤 상태/값/데이터 한 변수에 저장
		재고관리 = "10,10,10/0,0,0/300,200,100"; // 재고~ 바구니~ 가격~
		System.out.println(재고관리);
		/* ----------- */
		
		
		
		
		
		
		while(true) {
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			System.out.print(">>>>>> 선택 : "); int ch = scanner.nextInt();
			
/* 문제풀이 위치 */
			
			String 콜라정보 = 재고관리.split("/")[0];
			String 환타정보 = 재고관리.split("/")[1];
			String 사이다정보 = 재고관리.split("/")[2];
			
			int 콜라재고 = Integer.parseInt(콜라정보.split(",")[0]);
			int 환타재고 = Integer.parseInt(환타정보.split(",")[1]);
			int 사이다재고 = Integer.parseInt(사이다정보.split(",")[2]);
			
			int 콜라바구니 = Integer.parseInt(콜라정보.split(",")[0]);
			int 환타바구니 = Integer.parseInt(환타정보.split(",")[1]);
			int 사이다바구니 = Integer.parseInt(사이다정보.split(",")[2]);
			
			int 콜라가격 = Integer.parseInt(콜라정보.split(",")[0]);
			int 환타가격 = Integer.parseInt(환타정보.split(",")[1]);
			int 사이다가격 = Integer.parseInt(사이다정보.split(",")[2]);
			
			
			if(ch == 1) {
				if( 콜라재고 > 0) {
					콜라바구니 += 1;
					콜라재고 -= 1;

					
				} else {System.out.println("재고부족");}
			} else if( ch == 2) {
				if( 환타재고 > 0) {
					환타바구니 += 1;
					환타재고 -= 1;

				} else {System.out.println("재고부족");}
			} else if ( ch == 3) {
				if( 사이다재고 > 0) {
					사이다바구니 += 1;
					사이다재고 -= 1;

				} else {System.out.println("재고부족");}
			} else if ( ch == 4) {
				
				
				System.out.println("- 현재 장바구니 현황 표시 목록");
				System.out.println("---------------------------");
				System.out.println("제품명 수량 가격");
				if( 콜라바구니 > 0) {
					System.out.println("콜라  " + 콜라바구니 +"\t" + (콜라바구니*콜라가격));
				} if( 환타바구니 > 0) { 
					System.out.println("환타  " + 환타바구니 + "\t" + (환타바구니*환타가격));
				} if ( 사이다바구니 > 0) {
					System.out.println("사이다  " + 사이다바구니 + "\t" + (사이다바구니*사이다가격));
				}
				System.out.println("총가격 :   " + ((콜라바구니*콜라가격) +  (환타바구니*환타가격)+ (사이다바구니*사이다가격)));
				System.out.println("- 결제 메뉴 -");
				System.out.println("1. 결제" + "2. 취소"); 
				ch = scanner.nextInt();
				//---------------------------------안된다
				
				if(ch == 1) {
					System.out.print("결제금액 : ");
					int 결제금액 = scanner.nextInt();

					
					if(결제금액 <((콜라바구니*콜라가격) +  (환타바구니*환타가격)+ (사이다바구니*사이다가격))) {
						System.out.println("결제취소");
						
						
						콜라재고 += 콜라바구니 ;
						환타재고 += 환타바구니 ;
						사이다재고 += 사이다바구니 ;
						
						콜라바구니 = 0;
						환타바구니 = 0;
						사이다바구니 = 0;
					} else if(결제금액 >= ((콜라바구니*콜라가격) +  (환타바구니*환타가격)+ (사이다바구니*사이다가격))) {
						
						System.out.println( "결제성공");
						System.out.println("잔액 :" + (결제금액 - ((콜라바구니*콜라가격) +  (환타바구니*환타가격)+ (사이다바구니*사이다가격))) );
					
					콜라바구니 = 0;
					환타바구니 = 0;
					사이다바구니 = 0;
					}
				}
				
				if (ch == 2) {
					
					콜라재고 += 콜라바구니 ;
					환타재고 += 환타바구니 ;
					사이다재고 += 사이다바구니 ;
					
					콜라바구니 = 0;
					환타바구니 = 0;
					사이다바구니 = 0;
					
				} 
			}
			재고관리 = 콜라재고+","+환타재고+","+사이다재고+"/"+콜라바구니+","+환타바구니+","+사이다바구니+"/"+콜라가격+","+환타가격+","+사이다가격;
			/* ----------- */
			
		} // while end 
	} // main end 
	
} // class end 

/*

	 주제 : 키오스크(변수버전)
	 	- 실행예시 사진은 없습니다.
		조건 
		1. 제품 가격/재고/바구니 상태를 하나의 문자열 변수에서 관리 
			// 샘플 : 
					이름 : 콜라 , 환타 , 사이다
					가격 : 300 , 200 , 100
					바구니 : 0 , 0 , 0
			
		2. 키오스크 메뉴 [ 무한루프 : 종료 없음(24시간) ] 
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







