package java1.day05;

public class Ex1_참조타입 {

	public static void main(String[] args) {
		
	}
	
}

/*
 
  	자바 데이터 타입 : 변수 선언할때 사용되는 타입
  		- 기본 타입 : boolean byte short char int long float double 
  			- 변수에  값 자체 저장
  			- 8가지 존재/ 소문자 시작
  			int age =25;
  			
  		- 참조 타입 : 배열, 열거 , 클래스[ String, Scanner, Random , System 등 ] , 인터페이스
			- 변수에 힙메모리 생성된 메모리를 주소/번지 참조
			- 첫글자가 대문자로
			String name = "신용권"
  
  JVM 메모리
  
  	스택 영역							힙영역
  	- 함수(프레임)마다 별도구역				 - 객체가 생성되는 영역
  		- 지역 변수						- 스택/메소드 영역에 참조 할수 있다.
  		- 함수 호출시 프레임 생성
  		- 함수(프레임) 종료되면 제거
  	-------------------------------------------------------------------
  	
  	int age = 25;
  	
  	String name = 100번지				"신용권" : String 클래스 기반으로 만들어진 객체
  									100번지
 */
