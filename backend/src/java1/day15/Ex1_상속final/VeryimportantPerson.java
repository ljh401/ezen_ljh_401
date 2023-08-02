package java1.day15.Ex1_상속final;

public class VeryimportantPerson extends Member{

			// 자식 클래스 extends 부모클래스	public class Member()		: 상속 가능
			//							public final class Member() : 상속 불가능
	
	@Override
	public void stop1() { // stop1메소드는 final 키워드가 없으므로 오버라이딩 가능
		super.stop1();
	}
	
	/*
	 * @Override public void stop2() { // stop2메소드는 final 키워드가 있으므로 오버라이딩 불그낭 [ 오류
	 * 발생 ] super.stop2(); }
	 */
}				
