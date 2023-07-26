package 과제.과제9;

// 목적 : 설계도 , 객체의 모델
public class Member {
	// 1. 필드 : 객체의 데이터를 저장하는 곳
	String id;	// 초기값/처음에대입이 없을때 기본값[ 정수0 실수0.0 불false 참조 null ]
	String password;
	String name;
	String phone;
	int age;
	
	
	// 클래스의 빈 공간 클릭
		// 오른쪽 클릭
			// Source
			// Constructor using fields
	
	
	// 2. 생성자
	
	public Member( String id, String password, String name, String phone, int age) { 	// 1. 매개변수 5개 정의한 생성자
	this.id = id;
	this.password = password;
	this.name = name;
	this.phone = phone;
	this.age = age;
	}
	/*
	public Member() {}	// 0. 빈 [ 매개변수 없는 ] 생성자
	public Member( String id, String password, String name, String phone) {} 			// 2. 매개변수 4개 정의한 생성자
	public Member( String id, String password, String name) {} 							// 3. 매개변수 3개 정의한 생성자
	public Member( String id, String password) {} 										// 4. 매개변수 2개 정의한 생성자
	public Member( String id) {} 														// 5. 매개변수 1개 정의한 생성자
	// public Member(String password){}
	public Member(int age) {}
	*/
	
	// 3. 메소드
}
