package java1.day11.Ex3;

public class Member {
	
		// 싱글톤 : 프로그램 내 1개 존재하는 객체
	
		// 1. 자신의 타입으로 객체를 생성한다. -> private으로 제한한다.
		private static Member member = new Member();
		
		// 2. 1번에서 생성한 싱글톤 객체를 반환하는 함수 생성
		public static Member getInstance() {return member;}
		
		// 3. 외부에서 사용 못하게 생성자 잠금
		private Member() {}
}
