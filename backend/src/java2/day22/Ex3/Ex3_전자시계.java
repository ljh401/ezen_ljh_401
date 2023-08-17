package java2.day22.Ex3;

import java.util.Scanner;

public class Ex3_전자시계 {

	public static void main(String[] args) {
		
		// 자동으로 현재시간 실행
		현재시간기능 현재시간 = new 현재시간기능();
		Thread thread = new Thread(현재시간);
		thread.start();
		
		// 타이머 사용여부는 입력 받아 실행
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("1. 타이머 시작 2. 타이머 중지 :");
			int ch = scanner.nextInt();
			if(ch == 1	 ) {System.out.println("타이머시작");
			타이머기능 타이머 = new 타이머기능();
			Thread thread2 = new Thread(타이머);
			thread2.start();
			}
			else if(ch == 2	 ) {System.out.println("타이머 중지");}
		}
	}
}
