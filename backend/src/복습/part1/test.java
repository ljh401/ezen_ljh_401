package 복습.part1;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {

		  int 콜라재고 = 10 ; int 환타재고 = 3; int 사이다재고 = 2;
		    int 콜라바구니 = 0 ; int 환타바구니 = 0 ; int 사이다바구니 = 0;
		    int 콜라가격 = 300 ; int 환타가격 = 200 ; int 사이다가격 = 100 ;
		    
		    Scanner scanner = new Scanner(System.in);
		    
		    
		    while(true) {
		    System.out.println("------------메뉴----------------");
		    System.out.println("1콜라300 2환타200 3사이다100 4결제");
		    System.out.print(">>>> 선택 : "	);
		    int ch = scanner.nextInt();
		    
		    if(ch == 1) {
		    	if(콜라재고>0) {
		    		콜라재고 --;
		    		콜라바구니 ++;
		    		System.out.println("콜라 담았습니다");
		    	} else {System.out.println("재고 부족");}
		    }
		    
		    if(ch == 2) {
		    	if(환타재고>0) {
		    		환타재고 --;
		    		환타바구니 ++;
		    		System.out.println("환타 담았습니다");
		    	} else {System.out.println("재고 부족");}
		    }
		    
		    if(ch == 3) {
		    	if(사이다재고>0) {
		    		사이다재고 --;
		    		사이다바구니 ++;
		    		System.out.println("사이다 담았습니다");
		    	} else {System.out.println("재고 부족");}
		    }
		    
		    if(ch == 4) {
		    	System.out.println("----현재 바구니 현황 표시 목록----");
		    	System.out.println("제품명\t수량\t가격");
		    	
		    if(콜라바구니 >0) {System.out.println("콜라 :" + "\t" + 콜라바구니 + "\t" + (콜라바구니*콜라가격));}
		    if(환타바구니 >0) {System.out.println("환타 :" + "\t" + 환타바구니 + "\t" + (환타바구니*환타가격));}
		    if(사이다바구니 >0) {System.out.println("사이다 :" + "\t" + 사이다바구니 + "\t" + (사이다바구니*사이다가격));}
		    int 총가격 = (콜라바구니*콜라가격)+ (환타바구니*환타가격)+ (사이다바구니*사이다가격);
		    System.out.println("총가격 :" + 총가격);
		    
		    System.out.println("1결제 2취소");
		    System.out.print(">>>> 선택 :");
		    ch = scanner.nextInt();
		    
		    if(ch == 1) {
		    	int 총금액 = scanner.nextInt();
		    	if(총금액 >= 총가격) {
		    		System.out.println("결제성공");
		    		System.out.println("잔돈 :" + (총금액-총가격) );
		    		콜라바구니 = 0;
		    		환타바구니 = 0;
		    		사이다바구니 = 0;
		    	} else {
		    		System.out.println("결제취소");
		    		콜라재고 += 콜라바구니;
		    		환타재고 += 환타바구니;
		    		사이다재고 += 사이다바구니;
		    		
		    		콜라바구니 = 0;
		    		환타바구니 = 0;
		    		사이다바구니 = 0;
		    	}
		    }
		    if(ch ==2) {
		    	System.out.println("결제 취소를 선택하셨습니다.");
		    	
		    	콜라재고 += 콜라바구니;
	    		환타재고 += 환타바구니;
	    		사이다재고 += 사이다바구니;
	    		
	    		콜라바구니 = 0;
	    		환타바구니 = 0;
	    		사이다바구니 = 0;
		    	}
		    }
		    }
	}
}
