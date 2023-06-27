/*
- 과제3 : 가계부 만들기 ( 과제3.HTML , 과제3.JS , 과제3.CSS )
요구사항
   - 1.배열 3개 사용 ( 날짜배열 , 항목배열 , 금액배열 ) / 객체X { }
   - 2.함수 3개 이상 정의해서 구현 
   - 3.총합계는 계산해서 테이블 가장 하단에 출력하시오.
   - 4. 해당 삭제 버튼 클릭시 해당 항목 제거 
   - 5. 출력시 숫자를 천단위 쉼표로 출력하시오. [ toLocaleString() 함수( 천단위쉼표가 있는 문자열로 변환)  ]
      - let 금액 = 1200000
      - 금액.toLocaleString( ) => '1,200,000'
   - 6. css 적절하게 적당히 꾸며서 제출해주세요.

ex) 입력 예시 [ input 3개 사용 ]
   날짜 : <input type="date" />
   항목 : <input type="text" />
   금액 : <input type="text" />

ex) 출력 예시 [ table 사용 ]
   날짜         항목      금액         비고
   2023-06-06   콜라      300         삭제버튼
   2023-06-05   노트북   1,200,000   삭제버튼
   2023-06-03   교통비   1,750      삭제버튼
      -총합계-         1,202,050      
 
 */
/*

	< 주요기능1 등록>
	1. HTML 작성 : input 3개 button 1개 작성
	2. button 클릭했을때 입력받은 input 3개 저장하는 이벤트
		<button>등록</button>
	3. 함수 정의
		무슨 이벤트 = 정의 = 구체적인 이벤트 내용물	
		-등록 버튼 클릭했을때 함수 실행
		1. input 입력된 3개의 데이터를 모두 가져오기??
			1. 마크업의 선택자 정의
				1. 호출할 마크업의 선택자 필수!!
					선택자 : 마크업 식별하는 방법
						1. class, id, 마크업
			2. DOM객체 함수를 이용한 선택자의 마크업 객체로 호출			
				document.getElementsByClassName
				document.querySelector
			3. DOM객체의 입력된 값 호출
				input, textarea, select => value 속성 가능
				div, span, table 등등 => value 속성 불가능
		2. 배열에 저장 ??
			* 배열은 여러개 데이터 저장할 수 있다.
			* 함수는 종료되는 순간 = {} 에서 사용되었던 메모리 모두 초기화/사라짐	
			
			날씨, 항목, 금액
			1. 인덱스 순으로 데이터 형태 구분
					0 3 6 9 12 = 날짜 인덱스
					1 4 7 10 13 = 항목 인덱스
					2 5 8 11 14 = 금액 인덱스
				let 가계부 = ['2023-06-27', '콜라', '10000', '2023-06-27', '사이다', '3000']	
			2. 
				각 배열당 0번 인덱스가 날짜,항목,금액
				
				let 가계부_날짜 = ['2023-06-27' , '2023-06-27'	]
				let 가계부_항목 = ['콜라','사이다'				   	]
				let 가계부_금액 = ['10000', '3000'				]
	< 주요기능2 출력>
	
	< 주요기능3 삭제>

*/

/* 입력받은 데이터 여러개를 저장하기 위한 배열 3개 선언 */
let 날짜배열 = []
let 항목배열 = []
let 금액배열 = []

console.log('js');

// 1. 등록 버튼 클릭했을때 이벤트
function 등록(){
	console.log('등록함수 클릭');
	
	
	// 1. HTML 특정태그를 가져오기
	// document.getElementsByClassName("클래스명")
	let dateInput = document.querySelector(".date")
	let nameInput = document.querySelector(".name")
	let moneyInput = document.querySelector(".money")
	
	console.log(dateInput)
	console.log(nameInput)
	console.log(moneyInput)
	
	// 2. 태그의 입력된 값 호출
	let date = dateInput.value
	let name = nameInput.value
	let money = moneyInput.value
	
	console.log(date)
	console.log(name)
	console.log(money)
	
	// 3. 배열 저장
	날짜배열.push( date ); console.log(날짜배열)
	항목배열.push( name ); console.log(항목배열)
	금액배열.push( money ); console.log(금액배열)
	
	// * 저장 성공시 input 상자 입력값 초기화
	alert('항목 등록이 성공 되었습니다.')
	dateInput.value = ``
	nameInput.value = ``
	moneyInput.value = ``
}









