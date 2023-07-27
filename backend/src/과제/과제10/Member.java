package 과제.과제10;

public class Member {
	
	/*

		JVM : 자바 가상(논리적으로 만들어낸) 메모리
		
		Member.java----클래스로더---->Member.class---->메소드영역
		자바코드파일					바이트코드파일		클래스코드,메소드코드
													정적(static)멤버
													
		this : 인스턴스멤버 : new 힙생성시 할당 되고 힙 초기화될때(GC) [ 공용x, 각각 ]
			- 객체를 통해 사용
		static : 정적멤버 : 프로그램 시작 할당 되고 프로그램이 종료될때 [ 전역/ 공통 /공용 / 공유 ]
			- 클래스 통해 사용
		
		final : 수정불가 : 초기화할때 대입만 가능하고 수정 불가능
		static final : 상수 : 프로그램 내에서 1개만 저장(static) 수정불가능(final) 합친 키워드
		
	 */

	String id;
	private String password;
	private String name;
	private String phone;
	private int age;
	// 2. 생성자 : 객체의 초기화를 담당
		// 1. 빈 생성자
	public Member() {}
		// 2. 모든 필드를 저장하는 풀 생성자
	public Member(String id,String password,String name,String phone,int age) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.age = age;
		
	}
	
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone + ", age=" + age
				+ "]";
	}
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
