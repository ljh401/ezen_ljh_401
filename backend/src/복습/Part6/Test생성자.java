package 복습.Part6;

public class Test생성자 {
	
	String id;
	String pw;
	String name;
	String phone;
	int age;
	
	Test생성자() {}

	public Test생성자(String id, String pw, String name, String phone, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Test생성자 [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", age=" + age + "]";
	}
	
	
}
