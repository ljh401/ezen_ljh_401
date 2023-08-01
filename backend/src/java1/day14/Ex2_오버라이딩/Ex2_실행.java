package java1.day14.Ex2_오버라이딩;

public class Ex2_실행 {
	
	public static void main(String[] args) {
		
		int r = 10;
		
		// 1. 부모 객체 생성
		Calculator calculator = new Calculator();
		// 2. 부모 객체가 부모클래스 멤버 메소드 호출
		System.out.println("원 면적 : " + calculator.areaCircle(r));
		
		// 3. 자식 객체 생성
		Computer computer = new Computer();
		// 4. 자식 객체가 부모클래스 멤버 메소드 호출
		System.out.println("원 면적 : " + computer.areaCircle(r));
	}
}
