package 과제.과제10;

import java.util.Arrays;
import java.util.Scanner;

public class d {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		// 냉장고 만들기
		냉장고 우리집냉장고 = new 냉장고();
		System.out.println( 우리집냉장고.식품리스트 );
		
		// 식품 2개 객체 생성 
		식품 제로콜라1 = new 식품("제로콜라");
		식품 사이다1 = new 식품("사이다");
		
		// 냉장고에 식품 넣기 
		우리집냉장고.식품넣기(제로콜라1);
		우리집냉장고.식품넣기(사이다1);
		
		// 냉장고에 식품 확인하기 
		System.out.println( 우리집냉장고.식품리스트 );

		
		System.out.println("식품번호 입력 : ");
		int 식품번호 = scanner.nextInt();
		
		// 냉장고에 식품 빼기 
		우리집냉장고.식품빼기( 식품번호 );
		
		// 냉장고에 식품 확인하기 
		System.out.println( 우리집냉장고.식품리스트  );
		
		
		
		
	}

}
