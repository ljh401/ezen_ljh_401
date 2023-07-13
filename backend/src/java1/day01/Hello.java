// 한줄 주석
/* 여러 줄 주석 */

package java1.day01; // 패키지/폴더 경로

public class Hello { // clss start // 클래스 선언 // 'Hello' 클래스명 = 숫자시작X, 공백X, 첫글자 대문자
	// 1. JAVA 코드 가장 작은 단위 = 클래스 = 모든 코드는 클래스 안에서 작성
	// 2. 모든 실행코드는 main함수 안에서 작성 [ 스레드=코드를 읽는 흐름 포함]
	
	// {} 마다 tab 1번 적용
	public static void main(String[] args) { // m start / 메소드=함수 선언
		// console.log() vs System.out.println()
		// syso + 컨트롤 + 스페이스바 엔터!
		System.out.println("Hello Java");
		// 실행 : ctrl + F11 , 해당 오른쪽 클릭 -> RUN, 상단메뉴 RUN

	} // m end
	
	// 실행 코드는 main함수 밖에서 작성 X
	// System.out.println("Hello Java");
	
} // class end

// 클래스 밖에서 코드 작성 x
// System.out.println("Hello Java");