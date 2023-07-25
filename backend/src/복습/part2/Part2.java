package 복습.part2;

import java.util.Scanner;

public class Part2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		
		String 재고관리 = "10,0,300\n3,0,200\n2,0,100\n"; // 재고~ 바구니~ 가격~
		
		while(true) {
			
			System.out.println("----------메뉴-------------");
			System.out.println("1. 콜라300 2.환타200 3.사이다 100 4. 결제");
			System.out.print("선택 "); 
			int ch = scanner.nextInt();
			
			int 콜라재고 = Integer.parseInt(재고관리.split("\n")[0].split(",")[0]);
			int 환타재고 = Integer.parseInt(재고관리.split("\n")[1].split(",")[0]);
			int 사이다재고 = Integer.parseInt(재고관리.split("\n")[2].split(",")[0]);
			
			int 콜라바구니 = Integer.parseInt(재고관리.split("\n")[0].split(",")[1]);
			int 환타바구니 = Integer.parseInt(재고관리.split("\n")[1].split(",")[1]);
			int 사이다바구니 = Integer.parseInt(재고관리.split("\n")[2].split(",")[1]);
			
			int 콜라가격 = Integer.parseInt(재고관리.split("\n")[0].split(",")[2]);
			int 환타가격 = Integer.parseInt(재고관리.split("\n")[1].split(",")[2]);
			int 사이다가격 = Integer.parseInt(재고관리.split("\n")[2].split(",")[2]);
			
			if( ch == 1) {
				if(콜라재고 > 0) {
					콜라재고 -= 1;
					콜라바구니 += 1;
					System.out.println("콜라 담았습니다.");
				} else {System.out.println("재고 부족");}
			}
			
			if( ch == 2) {
				if(환타재고 > 0) {
					환타재고 -= 1;
					환타바구니 += 1;
					System.out.println("환타 담았습니다.");
				} else {System.out.println("재고 부족");}
			}
			
			if( ch == 3) {
				if(사이다재고 > 0) {
					사이다재고 -= 1;
					사이다바구니 += 1;
					System.out.println("사이다 담았습니다.");
				} else {System.out.println("재고 부족");}
			}
			
			if( ch == 4) {
				
				System.out.println("-----------------------");
				System.out.println("제품명\t수량\t가격");
				if(콜라바구니 >0) { System.out.println("콜라 :" + "\t" + 콜라바구니 + "\t" + (콜라바구니*콜라가격) );}
				if(환타바구니 >0) { System.out.println("환타 :" + "\t" + 환타바구니 + "\t" + (환타바구니*환타가격) );}
				if(사이다바구니 >0) { System.out.println("사이다 :" + "\t" + 사이다바구니+ "\t" +(사이다바구니*사이다가격) );}
				int 총가격 = ((콜라바구니*콜라가격)+ (환타바구니*환타가격)+(사이다바구니*사이다가격));
				
				System.out.println("총가격 :" + 총가격);
				
				System.out.println("1 결제 2 취소");
				ch = scanner.nextInt();
				
				if(ch == 1) {
					System.out.println("결제 금액을 넣어주세요.");
					int 금액 = scanner.nextInt();
					
					if(금액 >= 총가격) {
						System.out.println("결제 성공");
						콜라바구니 = 0;
						환타바구니 = 0;
						사이다바구니 = 0;
					} else {
						System.out.println("결제 취소");
						콜라재고 += 콜라바구니;
						환타재고 += 환타바구니;
						사이다재고 += 사이다바구니;
						콜라바구니 = 0;
						환타바구니 = 0;
						사이다바구니 = 0;
						
					}
				
				}
				if (ch == 2) {
					System.out.println("결제 취소를 선택하셨습니다.");
					
					콜라재고 += 콜라바구니;
					환타재고 += 환타바구니;
					사이다재고 += 사이다바구니;
					콜라바구니 = 0;
					환타바구니 = 0;
					사이다바구니 = 0;
				}
				
			}
			재고관리 = 콜라재고+","+콜라바구니+","+콜라가격+"\n"+환타재고+","+환타바구니+","+환타가격+"\n"+
			사이다재고+","+사이다바구니+","+사이다가격;
		}
	}
}


