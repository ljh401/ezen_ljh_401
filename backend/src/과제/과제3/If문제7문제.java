package 과제.과제3;

import java.util.Scanner;

public class If문제7문제 {

	public static void main(String[] args) {

		/* -------문제1----- */
				
				Scanner scanner = new Scanner(System.in);
				
				System.out.print("1번 정수 입력1 : ");
				int 정수1 = scanner.nextInt();
				System.out.print("1번 정수 입력2 : ");
				int 정수2 = scanner.nextInt();
				
				if(정수1 > 정수2) {
					System.out.println(정수1);
					} else if (정수1 < 정수2) {
						System.out.println(정수2);
					
					} else {
						System.out.println("같다");
						}
				
		/* -------문제2----- */
				
				System.out.print("2번 정수 입력1 : ");
				int 정수3 = scanner.nextInt();
				System.out.print("2번 정수 입력2 : ");
				int 정수4 = scanner.nextInt();
				System.out.print("2번 정수 입력3 : ");
				int 정수5 = scanner.nextInt();
				
				if(정수3 > 정수4 && 정수3 > 정수5) { System.out.println(정수3 + "가장 큽니다!"); }
				else if(정수4 >정수3 && 정수4 > 정수5) { System.out.println(정수4 + "가장 큽니다!"); }
				else { System.out.println(정수5 + "가장 큽니다!"); }
				
		
		/* -------문제3----- */
		/*
		 * 문제3 : 3개의 정수를 입력받아서 오름차순[>] / 내림차순[<] [ 경우의수 : 3 7 5 : 3>7 , 3>5 , 7>5 총 : 3개
		 * ]
		 */
				System.out.print("3번 정수 입력1 : ");
				int 정수6 = scanner.nextInt();
				System.out.print("3번 정수 입력2 : ");
				int 정수7 = scanner.nextInt();
				System.out.print("3번 정수 입력3 : ");
				int 정수8 = scanner.nextInt();	
				
				
				int temp;
				
				if( 정수6 > 정수7) { 
					temp = 정수6; 
					정수6 = 정수7; 
					정수7 = temp;
				}
				
				
				if ( 정수7 > 정수8) {
					temp = 정수7; 
					정수7 = 정수8; 
					정수8 = temp;
				}
				
				if ( 정수6 > 정수8) {
					temp = 정수6;
					정수6 = 정수8;
					정수8 = temp;
				}
				
				System.out.printf("문제3 : %3d %3d %3d \n" , 정수6, 정수7,정수8);
				
				
		
		/* -------문제4----- */
				
				int 점수 = scanner.nextInt();
				
				if( 점수 >= 90) { System.out.println("합격");}
				else if( 점수 < 90) { System.out.println("불합격");}
				
		/* -------문제5----- */
		
				
				int 점수2 = scanner.nextInt();
				
				if( 점수 >= 90) { System.out.println("A");}
				else if( 점수 >= 80) { System.out.println("B");}
				else if( 점수 >= 70) { System.out.println("C");}
				else { System.out.println("재시험");}
				
		/* -------문제6----- */
	
				int 국어 = scanner.nextInt();
				int 영어 = scanner.nextInt();
				int 수학 = scanner.nextInt();
				int 평균 = (국어 + 영어 + 수학) /3;
				
				 if(평균>=90) {
			         if(국어==100) {
			        	 System.out.println("국어 우수");
			        	 } else if(영어==100) {
			        	 System.out.println("영어 우수");
			        	 } else if(수학==100) {
			        	 System.out.println("수학 우수");
			        	 }
				 } else if (평균>=80) {
			         if(국어==90) {
			        	 System.out.println("국어 장려");
			        	 } else if(영어==90) {
			        	 System.out.println("영어 장려");
			        	 } else if(수학==90) {
			        	 System.out.println("수학 장려");
			        	 }
			      } else {
			         System.out.println("재시험");
			      }

		/* -------문제7----- */
				 System.out.println("아이디 : ");
				 String 아이디 = scanner.next();
				 System.out.println("비밀번호 : ");
				 String 비밀번호 = scanner.next();
				 
	
				 
				 if( 아이디.equals("admin") && 비밀번호.equals("1234")) {
					 System.out.println("로그인 성공!");
				 } else { System.out.println(" 로그인 실패!"); }
	}
	
}

/*
 	 문제1 : 2개의 정수를 입력받아서 더 큰수 출력 [ 경우의수 : 3개(크다,작다,같다=그외) ]
 	 문제2 : 3개의 정수를 입력받아서 가장 큰수 출력 
 	 문제3 : 3개의 정수를 입력받아서 오름차순[>] / 내림차순[<] [ 경우의수 :  3 7 5 : 3>7 , 3>5 , 7>5     총 : 3개  ] 
 	 문제4 : 점수를 입력받아 점수가 90점 이상이면 합격 아니면 불합격 출력 [ 경우의수 : 2개 ]
 	
 	 문제5 : 
			// 점수를 입력받아 점수가 90점 이상이면 A등급
			//				점수가 80점 이상이면 B등급
			//				점수가 70점 이상이면 C등급
			//				그외 재시험
	
	
 	 문제6	[ 경우의수 3개 , 첫번째 경우의수 : 3개 , 두번째 경우의수 : 3개 ] 총 9개  
			[ 입력 ] : 국어,영어,수학 입력받기
			[ 조건 ]
				평균이 90점 이상이면서 
					국어점수 100점 이면 '국어우수' 출력
					영어점수 100점 이면 '영어우수' 출력
					수학점수 100점 이면 '수학우수' 출력
				평균이 80점 이상이면서 
					국어점수 90점이상 이면 '국어장려' 출력
					영어점수 90점이상 이면 '영어정려' 출력
					수학점수 90점이상 이면 '수학장려' 출력
				그외 재시험 
		 
	문제7 로그인페이지
	 		[ 입력 ] : 아이디와 비밀번호를 입력받기
	 		[ 조건 ] : 회원아이디가 admin 이고 
	           			비밀번호가 1234 일 경우에는 
	          			로그인 성공 아니면 로그인 실패 출력
 */
