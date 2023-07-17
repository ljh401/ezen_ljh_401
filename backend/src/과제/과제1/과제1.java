package 과제.과제1;

import java.util.Scanner;

public class 과제1 {

	public static void main(String[] args) {

		/*
		 * //캡처2 확인문제 // 1. 4 // 1 : 변수는 하나의 값만 저장o vs 배열은 여러개 값 저장 // 2 : int 타입으로
		 * 선언했으면 int 허용범위 내 데이터만 저장 // 3 : {} 안에서 선언된 변수는 밖으로 나올 수 없다. // 4 : x // int
		 * 문제1; System.out.println( 문제 1); // 4번 오류
		 * 
		 * // 2. 2,3,6,7 //int modelName; int class; int 6hour; int $value; //int _age;
		 * int #name; int int; // 미리 정해진 단어 : 문법적으로 사용되는 단어 불가능 [ 키워드 ]
		 * 
		 * // 3.
		 * 
		 * 정수타입 byte short int long char 실수타입 float double 논리타입 boolean
		 * 
		 * 
		 * // 4. // 타입 : int, double // 변수명 : age , price // 리터럴 : 10, 3.14
		 * 
		 * // 5. 3 short : +- 3만 / char : 6만 byte bytevalue = 10; int intvalue =
		 * bytevalue; char charvalue = 10; intvalue = charvalue; short shortvalue =
		 * charvalue; // 3 : char에는 음수가 없기때문 double doublevalue = bytevalue;
		 * 
		 * // 6. 4 int intValue = 10; double var1 = (double)intValue; // 자동 char
		 * charValue = 'A'; byte var2 = (byte)intValue; // 강제 double doubleValue
		 * =5.7;int var3 = (int)doubleValue; // 강제 String strValue = "A"; char var4 =
		 * (char)strValue; // 4 : 오류 객체는 기본타입으로 캐스팅 불가 //해결 방안 char var5 =
		 * strValue.charAt(0); // 문자열.charAt(인덱스) : 문자열 내 인덱스 번째 문자 1개 추출
		 * 
		 * // 7. 3 '' 문자로 표현 불가능 ' ' 공백 가능 int value1 = 10; long value2 =
		 * 10000000000000L; char value3 = ''; float value4 = 10; String value5 =
		 * "abc\ndef"; String value6 = ; // [ p.51] JDK13버전 이상만 가능
		 * 
		 * // 8. 3 출력한다 System.out.print(); System.out.println(); System.out.printf();
		 * nextline() 메소드;
		 * 
		 * // 9. 1 피연산자 중에 더 큰 허용범위 내로 결과 반환 byte bvalue = 10; float fvalue = 2.5f;
		 * double dvalue = 2.5;
		 * 
		 * byte result1 = bvalue + bvalue; int result2 = 5 + bvalue; float result3 = 5 +
		 * fvalue; double result4 = 5 + dvalue;
		 * 
		 * // 10. 2 int.parseint() [x] Integer.parseInt() [o]
		 * 
		 * // 11. 변수의 허용범위 : {} 안에서 선언된 변수는 밖으로 호출/사용 불가
		 * 
		 */
		
		
		
		
		//정수 하나를 입력 받아서 /2했을때 그 값을 반올림하여 출력하시오. 단,라이브러리 금지
        Scanner sc = new Scanner(System.in);
        float a =sc.nextFloat();
        
        //여기서부터//
        float b = a/2;
        int d = (int)b;
        float c = (10*b)%10 >= 5 ? d+1 : d;
        //여기까지 수정 가능
        
        System.out.println(c);
        
	}
}

/*
 * 
 * 1. 4 2. 2,3,6,7 3. 정수 타입 순서대로 : byte , short/char , int , long 실수 타입 순서대로 :
 * float, double 논리 타입 : boolean
 * 
 * 4. 타입 : int, double 변수 이름 : age, price 리터럴 : 10, 3.14 5. 3 (short는 +-32000 이고
 * char는 0~65000 이므로 형변환X) 6. 4 7. 3 8. 3 9. 1 10. 2 11. 13,16
 * 
 * 
 */
