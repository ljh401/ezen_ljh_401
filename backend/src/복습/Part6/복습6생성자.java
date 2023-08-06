package 복습.Part6;

public class 복습6생성자 {

	String id;
	String password;
	String name;
	String phone;
	int age;
	
	public 복습6생성자() {}
		
	public 복습6생성자(String id,String password,String name,String phone,int age) {
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
	
}
