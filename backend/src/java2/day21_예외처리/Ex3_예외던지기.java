package java2.day21_예외처리;

public class Ex3_예외던지기 {

	
	public static void main(String[] args) {
		
		// p.478 : 예외 던지기 : 메소드 안에서 예외가 발생하면 해당 메소드를 호출했던 곳으로 예외 이동
		try {
		findClass(); // 해당 클래스가 예외던지기 하기전에는 예외 X
		} catch (Exception e) {System.out.println(e);}
	}
	
	//
	public static void findClass() throws ClassNotFoundException{
		Class.forName("java.lang.String2");
		// 예외 발생 처리 방법 2가지
			// 1. try{} catch(){} 	: 해당 메소드에서 직접 처리 하는 방법
			// 2. throws			: 해당 메소드에서 직접 처리하지 않고 해당 메소드를 호출했던 곳으로 예외 이동
				// 웹에서는 자동 예외처리 가능 [ 서블릿 클래스 ]
	}
}
