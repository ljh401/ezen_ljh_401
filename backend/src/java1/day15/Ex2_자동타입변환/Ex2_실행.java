package java1.day15.Ex2_자동타입변환;

public class Ex2_실행 {

	public static void main(String[] args) {
		// 1. 부모객체 생성
		Parent parent = new Parent();	// --> 힙 : Parent객체1개
		
		// 2. 자식객체 생성 [ 자식 객체는 힙생성시 부모객체 힙도 생성 ]
		Child child = new Child();		// --> 힙 : Parent, Child 객체 2개
		
		// 3. 자식 객체를 부모 객체에 대입 ??
		Parent parent2 = child; // 가능 : 자식객체는 부모객체가 될 수 있다.
		// !! : 자식객체가 부모객체로 대입후에 부모객체는 자식객체의 멤버 사용할 수 없다.
		// 단 오버라이딩 된 자식 메소드는 사용 가능하다.
		parent2.method1();
		parent2.method2();
		//parent2.method3(); // 부모객체가 자식객체의 오버라이딩 아닌 메소드는 사용 불가능.
		
		// 4. 부모 객체를 자식 객체에 대입 ???
		//Child child2 = parent;	// 불가능 : 부모객체는 자식객체가 될 수 없다.
		
		// !! : (강제타입변환) : 캐스팅
		Child child2 = (Child)parent; // 단 강제 캐스팅을 이용한 형변환 가능.
		// !! : 부모객체가 자식객체로 대입후에 변환된 자식객체는 부모객체의 멤버 사용할 수 있다.
		child2.method1();
		child2.method2();
		child2.method3();
	}
}
