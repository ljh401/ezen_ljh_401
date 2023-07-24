package 복습.part1;

import java.util.Scanner;

public class Part1 {

	public static void main(String[] args) {
		
		int 콜라재고 = 10; int 환타재고 = 3; int 사이다재고 = 2;
		int 콜라바구니 = 0; int 환타바구니 = 0; int 사이다바구니 = 0;
		int 콜라가격 = 300; int 환타가격 = 200; int 사이다가격 = 100;
		
		Scanner scanner = new Scanner(System.in);
		
	    while(true) {
	    	System.out.println("----------------------------------");
	    	System.out.println("1. 콜라 | 2. 사이다 | 3. 환타 | 4. 결제");
	    	System.out.println("----------------------------------");
	    	
	    	int ch = scanner.nextInt();

			if (ch == 1) {
				
				if (콜라재고 > 0) {
					System.out.println("안내) 콜라담았습니다");
					콜라바구니 += 1;
					콜라재고 -= 1;
				} else {System.out.println("콜라 재고부족 [관리자에게 문의]");}
			}
			if (ch == 2) {
				
				if (사이다재고 > 0) {
					System.out.println("안내) 사이다담았습니다");
					사이다바구니 += 1;
					사이다재고 -= 1;
				} else {System.out.println("사이다 재고부족 [관리자에게 문의]");}
			}
			if (ch == 3) {
				
				if (환타재고 > 0) {
					System.out.println("안내) 환타담았습니다");
					환타바구니 += 1;
					환타재고 -= 1;
				} else {System.out.println("환타 재고부족 [관리자에게 문의]");}
			}
			
			if(ch == 4) {
				
				
				
				System.out.println("- 현재 바구니 표시 목록");
				System.out.println("제품명 수량 가격");
				
				
				if(콜라바구니>0) {System.out.println("콜라 :" + "\t" +콜라바구니  + "\t" + (콜라바구니*콜라가격));}
				
				if(사이다바구니>0) {System.out.println("사이다 :" + "\t" + 사이다바구니  + "\t" + (사이다바구니*사이다가격));}
				
				if(환타바구니>0) {System.out.println("환타 :" + "\t" + 환타바구니  + "\t" + (환타바구니*환타가격));}
				
			
				
				System.out.println("1. 결제 2. 취소");
				ch = scanner.nextInt();
				
				if(ch == 1) {
					
					if(콜라바구니 <= 0 || 사이다바구니 <= 0 || 환타바구니 <= 0) {
						System.out.println("제품을 골라주세요.");
					} else {
					
					System.out.println("금액을 입력하세요");
					int 총금액 = scanner.nextInt();
					
					if(총금액>=((콜라바구니*콜라가격)+(사이다바구니*사이다가격)+(환타바구니*환타가격))
							) {
						System.out.println("결제성공 ");
						System.out.println("잔액 : " + (총금액-((콜라바구니*콜라가격)+(사이다바구니*사이다가격)+(환타바구니*환타가격))));
						콜라바구니 = 0;
						사이다바구니 = 0;
						환타바구니 = 0;
						
					} else {
						System.out.println("결제취소");
						
						콜라재고 += 콜라바구니;
						사이다재고 += 사이다바구니;
						환타재고 += 환타바구니;
						
						콜라바구니 = 0;
						사이다바구니 = 0;
						환타바구니 = 0;
						
						
					}
					
				}
				
				if( ch == 2) {
					콜라재고 += 콜라바구니;
					사이다재고 += 사이다바구니;
					환타재고 += 환타바구니;
					
					콜라바구니 = 0;
					사이다바구니 = 0;
					환타바구니 = 0;
				}
				
				
				
				
			}
			
			}

		}
		
	}
	
}
