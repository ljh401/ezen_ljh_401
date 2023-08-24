package java2.day25_제네릭2.Ex2;

public class Ex2_와일드카드제네릭타입 {

	public static void main(String[] args) {
		
		
		// 1. 사람 객체
		Person person = new Person();
		
		// 2. 지원자 객체
		Applicant<Person> applicant = new Applicant<Person>(person);
		
		// 3. 모든 지원 가능한 코스 등록 함수
		Course.registerCourse1(applicant);
		
		
		// 1. 모든 사람이 신청 가능
		Course.registerCourse1(new Applicant<Person>(new Person()));
		Course.registerCourse1(new Applicant<Worker>(new Worker()));
		Course.registerCourse1(new Applicant<Student>(new Student()));
		Course.registerCourse1(new Applicant<HighStudent>(new HighStudent()));
		Course.registerCourse1(new Applicant<MiddleStudent>(new MiddleStudent()));
		System.out.println();
	
		// 2. 학생만 신청 가능
		//Course.registerCourse2(new Applicant<Person>(new Person()));
		//Course.registerCourse2(new Applicant<Worker>(new Worker()));
		Course.registerCourse2(new Applicant<Student>(new Student()));
		Course.registerCourse2(new Applicant<HighStudent>(new HighStudent()));
		Course.registerCourse2(new Applicant<MiddleStudent>(new MiddleStudent()));
		System.out.println();
		
		// 직장인 및 일반인만 신청 가능
		Course.registerCourse3(new Applicant<Person>(new Person()));
		Course.registerCourse3(new Applicant<Worker>(new Worker()));
		//Course.registerCourse3(new Applicant<Student>(new Student())); x
		//Course.registerCourse3(new Applicant<HighStudent>(new HighStudent())); x
		//Course.registerCourse3(new Applicant<MiddleStudent>(new MiddleStudent())); x
		
	}
}
