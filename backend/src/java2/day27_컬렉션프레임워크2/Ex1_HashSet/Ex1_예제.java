package java2.day27_컬렉션프레임워크2.Ex1_HashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex1_예제 {

	public static void main(String[] args) {
		
		// 1. Set 컬렉션의 HashSet 객체 선언
		Set<String> set = new HashSet<>();
			// set 객체(컬렉션프레임워크)에 <String> 객체를 여러개 저장 가능
		System.out.println("set의 상태" + set);
		// 2. set객체에 String 객체 저장
		set.add("java"); System.out.println("set의 상태" + set);
		set.add("JDBC"); System.out.println("set의 상태" + set);
		set.add("JSP"); System.out.println("set의 상태" + set);
		set.add("java"); // 중복발생 !! list는 가능하지만 , set 불가능
		System.out.println("set의 상태" + set);
		set.add("Spring"); System.out.println("set의 상태" + set);
		
		// 3. set 객체내 String 객체 수
		System.out.println("set객체내 객체수 :" + set.size());
		// 4. set/list와 for문 관계 [ * 배열 / 컬렉션 내 저장된 데이터들을 순회할려고 ]
			// 1. for문 [ list 인덱스 사용해서 가능하지만 set은 불가능 (인덱스 X)
		for(int i = 0; i<set.size(); i++) {}
			// 2. 향상된 for문 [ list, set 가능 , 원래 인덱스 쓰는 친구가 아님. ]
				// for(반복변수 : 컬렉션 객체 ){}
				// 1. 반복변수란 : 컬렉션객체에 저장된 타입 <String>
		for( String s : set) {System.out.println(s);}
		// 3. forEach() 함수를 이용한 람다식 표현 (화살표함수)
		set.forEach(s -> {System.out.println(s);}); // java -> / script =>
		
		//--------------------------------------------------------//
		
		// 1. set객체 선언 
		Set<Member> set2 = new HashSet<>();
		
		// 2. set 객체에 Member객체 저장
		set2.add(new Member("홍길동", 30));
		set2.add(new Member("홍길동", 30));
		set2.add(new Member("강호동", 30));
		set2.add(new Member("홍길동", 40));
		set2.add(new Member("신동엽", 50));
		
		// 3. set 객체 내 member 객체 수
		System.out.println("set 객체 내 member 객체 수 : " + set2); 
		
		// 4. iterator() 메소드 제공
        // 1. set 객체에서 iterator() 메소드 객체 얻기
     Iterator<Member> iterator = set2.iterator();
        
        // 2. iterator객체를 이용한 반복
     while(iterator.hasNext()) { // .hasNext() : 다음 객체가 없으면 true / 없으면 false
        Member element = iterator.next();  // .next() : set 객체내 객체 호출
        System.out.println(element);
        if(element.name.equals("강호동")) {
            iterator.remove(); // .remove() : set객체내 해당 객체 삭제
        }
     }
     System.out.println("set 객체내 member 객체수 : "+ set2);
     
     // 4. 향상된 for문(iterator 를 사용하는 배열/커렉션프레임워크의 객체 이면 사용 가능)
     for(Member m : set2) {
        

	}
	}
}
