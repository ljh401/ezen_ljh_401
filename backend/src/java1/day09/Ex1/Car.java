package java1.day09.Ex1;

public class Car {
	// 1. 필드 : *객체의 데이터 저장하는 곳
	
	// 2. 생성자 : *객체를 생성시 초기화 역할 담당
		// * 생성자명 : 클래스명과 동일
		// * 메소드와 비슷하지만 리턴return 없다. *인수/매개값 있음
		// * 생성자명( 타입 매개변수 , 타입 매개변수 , 타입 매개변수 )
		// * { 실행 코드 } 
		// 실행조건 : 1. 매개변수로 전달된 값을 필드에 저장 2. (안전상) 필드에 저장하기전에 가공/ 유효성검사
			// 필드는 실제 데이터 저장되는곳으로 직접 접근 권장하지 않음 --> 객체.필드(권장X)
	
	// 1. 기본생성자
	Car() {}
	// 2. 매개변수 3개인 생성자
	Car(String model, String color , int maxSpeed) {
		
		
	}
	// 3. 메소드
}
