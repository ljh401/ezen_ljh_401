package 복습.part1;

import java.util.Scanner;

public class 키오스크 {
   public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);

      String 재고관리 = "";

      // 1. 9개 변수가 가지고 있떤 상태/값/데이터 한 변수에 저장
      재고관리 = "10,10,10/0,0,0/300,200,100"; // 재고~ 바구니~ 가격~
      System.out.println(재고관리);
      /* ----------- */
      while(true) {
         System.out.println("--------메뉴-----------");
         System.out.println("1. 콜라300 2. 환타200 3.사이다100 4. 결제");
         System.out.print(">>>>선택 :");
         int ch = scanner.nextInt();
         
         int 콜라재고 = Integer.parseInt(재고관리.split("/")[0].split(",")[0]);
         int 환타재고 = Integer.parseInt(재고관리.split("/")[0].split(",")[1]);
         int 사이다재고 = Integer.parseInt(재고관리.split("/")[0].split(",")[2]);
         
         int 콜라바구니 = Integer.parseInt(재고관리.split("/")[1].split(",")[0]);
         int 환타바구니 = Integer.parseInt(재고관리.split("/")[1].split(",")[1]);
         int 사이다바구니 = Integer.parseInt(재고관리.split("/")[1].split(",")[2]);
         
         int 콜라가격 = Integer.parseInt(재고관리.split("/")[2].split(",")[0]);
         int 환타가격 = Integer.parseInt(재고관리.split("/")[2].split(",")[1]);
         int 사이다가격 = Integer.parseInt(재고관리.split("/")[2].split(",")[2]);
         
         if(ch == 1) {
            if(콜라재고>0) {
               콜라재고 -= 1;
               콜라바구니 += 1;
               System.out.println("콜라 담았습니다.");
            } else { System.out.println("재고 부족"); }
         }
         
         if(ch == 2) {
            if(환타재고>0) {
               환타재고 -= 1;
               환타바구니 += 1;
               System.out.println("환타 담았습니다.");
            } else { System.out.println("재고 부족"); }
         }
         
         if(ch == 3) {
            if(사이다재고>0) {
               사이다재고 -= 1;
               사이다바구니 += 1;
               System.out.println("사이다 담았습니다.");
            } else { System.out.println("재고 부족"); }
         }
         
         if( ch == 4) {
            System.out.println("-----제품 선택 현황-----");
            System.out.println("제품명\t수량\t가격");
         if(콜라바구니>0) {System.out.println("콜라 : " +"\t"+콜라바구니+"\t"+(콜라바구니*콜라가격));}
         if(환타바구니>0) {System.out.println("환타 : " +"\t"+환타바구니+"\t"+(환타바구니*환타가격));}
         if(사이다바구니>0) {System.out.println("사이다 : " +"\t"+사이다바구니+"\t"+(사이다바구니*사이다가격));}
         int 총가격 = ((콜라바구니*콜라가격)+(환타바구니*환타가격)+(사이다바구니*사이다가격));
         System.out.println("총가격 : " + 총가격); 
         
         System.out.println("1. 결제 2. 취소");
         ch = scanner.nextInt();
         
         if(ch == 1) {
            
            if(콜라바구니>0 || 환타바구니 > 0 || 사이다바구니 > 0) {
            System.out.println("금액 넣어주세요");
            int 총금액 = scanner.nextInt();
            
            if(총금액 >= 총가격) {
               System.out.println("결제 성공");
               
               System.out.println("잔돈 : " + (총금액-총가격));
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
            } else {
               System.out.println("제품 선택하세요"); 
            }
         }
         
         if(ch == 2) {
            System.out.println("취소를 선택하셨습니다.");
            
            콜라재고 += 콜라바구니;
            환타재고 += 환타바구니;
            사이다재고 += 사이다바구니;
            콜라바구니 = 0;
            환타바구니 = 0;
            사이다바구니 = 0;
         }
         
      }
         
         재고관리 = 콜라재고+","+환타재고+","+사이다재고+"/"+콜라바구니+","+환타바구니+","+사이다바구니
               +"/"+콜라가격+","+환타가격+","+사이다가격;
   }

}

}