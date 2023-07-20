package java1.day06;

import java.util.Arrays;
import java.util.Scanner;

public class Ex2_확인문제9 { // class s
	
	public static void main(String[] args) { // main s

		Scanner scanner = new Scanner(System.in);
		int 학생수 = 0;
		int[] scores = new int[학생수];
		while (true) {

			System.out.println("--------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("--------------------------------------------");
			System.out.println();
			System.out.print("선택>");
			String 선택 = scanner.nextLine();

			if (선택.equals("1")) {
				System.out.print("학생수>");
				학생수 = Integer.parseInt(scanner.nextLine());
				System.out.println("입력한 학생수 :" + 학생수);

				scores = new int[학생수];
				System.out.println(Arrays.toString(scores));
			}

			if (선택.equals("2")) {

				for (int i = 0; i < 학생수; i++) {

					System.out.print("scores[" + i + "]>");
					scores[i] = Integer.parseInt(scanner.nextLine());
					System.out.println(Arrays.toString(scores));
				}

			}
			
			if(선택.equals("3")) {
				for (int i = 0; i < 학생수; i++) {

					System.out.println("scores[" + i + "]> " + scores[i]);
					
					
				}
			}
			
			if(선택.equals("4")) {
				int max = 0;
				double 점수 = 0;
				for (int i = 0; i < scores.length; i++) {
						점수 += scores[i];
						
					if( max < scores[i]) max = scores[i];	// 선생님 최고
					System.out.println("최고 점수 : " + max);
					System.out.println("평균 점수 : " + 점수/학생수);
					
					
				}
			}
			
			if(선택.equals("5")) {
				 
					System.out.println("프로그램 종료");
					break;
			
			}


		}

	} // main e
	
} // class e

// .nextLine() 사용시 주의할점
	// * nextLine 사용시 다른 next~~() 앞뒤로 존재했을때 하나로 인식 [ 오류 처럼 보일 수 있다.]
		// 1. 해결 방안1
			// Integer.parseInt( scanner.nextLine()	);
		// 2. 해결 방안2

	/*
	 * String 문자 = scanner.nextLine();
	 *  int 정수 = scanner.nextInt();
	 * scanner.nextLine(); : 의미 없는 nextLine() 추가해서
	 *  String 문자 = scanner.nextLine();
	 */
		 