package 과제.과제10;

import java.util.ArrayList;
import java.util.Arrays;

public class 냉장고 {
	
	// 가변길이 의 식품 여러개를 담을수 있는 배열처럼 사용되는 리스트 라이브러리
	ArrayList< 식품 > 식품리스트 = new ArrayList<>();
	
	
	void 식품넣기( 식품 들어가는식품 ) {
		식품리스트.add(들어가는식품);
	}
	
	void 식품빼기( int 식품번호 ) {
		식품리스트.remove(식품번호-1);
	}
}
