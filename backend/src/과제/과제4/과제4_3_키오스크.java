package 과제.과제4;

import java.util.Scanner;

public class 과제4_3_키오스크 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int 콜라재고 = 10 ; 	int 환타재고 = 10 ; 	int 사이다재고 = 10;
		
		int 콜라바구니 = 0 ; 	int 환타바구니 = 0 ; 	int 사이다바구니 = 0;
		
		int 콜라가격 = 300 ;	int 환타가격 = 200 ;	int 사이다가격 = 100 ; 
		
		while(true) {
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			System.out.print(">>>>>> 선택 : "); int ch = scanner.nextInt();
			
			/* 문제풀이 위치 */
			
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
				if( 콜라바구니 > 0) {System.out.println("콜라  " + 콜라바구니 +"\t" + (콜라바구니*콜라가격));} 
				if( 환타바구니 > 0) { System.out.println("환타  " + 환타바구니 + "\t" + (환타바구니*환타가격));} 
				if( 사이다바구니 > 0) {System.out.println("사이다  " + 사이다바구니 + "\t" + (사이다바구니*사이다가격));}
				int 총가격 = ((콜라바구니*콜라가격) +  (환타바구니*환타가격)+ (사이다바구니*사이다가격));
				System.out.println("총가격 :   " + 총가격);
				System.out.println("- 결제 메뉴 -");
				System.out.println("1. 결제" + "2. 취소"); 
				ch = scanner.nextInt();
				
				if(ch == 1) {
					System.out.print("결제금액 : ");
					int 결제금액 = scanner.nextInt();

					
					if(결제금액 >= 총가격) {
						System.out.println("결제성공");
						
						콜라바구니 = 0;
						환타바구니 = 0;
						사이다바구니 = 0;
					} else {System.out.println("결제취소");
					콜라재고 += 콜라바구니 ;
					환타재고 += 환타바구니 ;
					사이다재고 += 사이다바구니 ;
					
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
			
			/* ----------- */
			
			
		} // while end 
	} // main end 
	
} // class end 

