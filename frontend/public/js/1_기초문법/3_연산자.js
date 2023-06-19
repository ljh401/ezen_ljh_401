/*

		1. 산술연산자 : 결과값으로 출력
			+더하기	-빼기	*곱하기	/나누기	%나머지
		
		2. 연결연산자 : +연결연산자
				숫자+숫자 [ + 더하기 ] 변수1 + 변수2 [ 만약에 두 변수 모두 숫자가 저장되어 있으면 더하기]
				숫자+'문자' [ + 연결연산자]
				'문자'+'문자' [ + 연결연산자]
		3. 비교연산자 : true 혹은 false 출력
				> 초과/크다	< 미만/작다
				>=이상/크거나같다	<=이하/작거나같다
				==같다[데이터비교]	===같다[데이터형/데이터 비교]
				!=같지않다/아니다	!==같지않다/아니다
				
		4. 관계연산자 : 주로 비교연산자 2개 이상일때 사용 , true or false
				&& 이면서 면서 이고 모두 그리고 and조건
				|| 이거나 거나 또는 하나라도 or조건
				!  반대 부정 not조건
				
		5. 대입연산자 
				= 대입 [ 오른쪽 데이터를 왼쪽 대입]
				+= [ 오른쪽 데이터를 왼쪽에 더한 후에 왼쪽에 대입]
					1. 변수 = 10
					2. 변수 += 30 [+= 1. 더하기를한다(30+10) 2.대입한다]
					3. console.log(변수)
				-= *= /= %=
				
		6. 증감연산자 
				++ 1증가 [ 선위 증가 : ++변수 / 후위 증가 : 변수++]
				-- 1감소 [ 선위 감소 : --변수 /후위 감소 : 변수--]
				
		7. 삼항연산자 : 항 3개 존재하는 연산자 , 참 or 거짓 출력
				조건 ? 참true : 거짓false
				-만약에 조건이 true이면 참 실행
				-만약에 조건이 false이면 거짓 실행
				--중첩 가능
				조건1 ? 참1 : 조건2 ? 참2 : 거짓	
				
*/

// 1. 산술연산자
console.log('더하기 : ' + 10+3) 		// 103
console.log('더하기 : ' + (10+3)) 	// 13
console.log('빼기 : ' + (10-3))		// 7
console.log('곱하기 : '+(10*3))		// 30
console.log('나누기 : '+(10/3))		// 3.3333333
console.log('나머지 : '+(10%3))		// 1

/*문제

   -문제1 : prompt 함수 로 국어 , 영어 , 수학 점수를 입력받아 각 변수에 저장하고 총점 출력 , 평균 출력
   -문제2 : prompt 함수 로 반지름 입력받아서 원넓이[ 반지름*반지름*3.14 ] 출력
   -문제3 : prompt 함수 로 두 실수를 입력받아서 앞실수의 값이 뒤실수의 값의 몇%인지 출력
   
*/   

// 문제 1:
let 국어 = Number(prompt('국어 점수 : ')) // 입력후에 변수에 저장 안하면 사라짐
let 영어 = Number(prompt('영어 점수 : ')) // Number('300') => 300
let 수학 = Number(prompt('수학 점수 : ')) // Number('숫자') => 숫자
	//2. 세 과목 총점 연산
let 총점  = 국어 + 영어 + 수학
let 평균  = 총점 / 3
	//3. 연산 결과 출력
console.log ('총점 :' + 총점)
console.log ('평균 :' + 평균)

//문제2
	// 1. 반지름 입력받기
let 반지름 = prompt('반지름 :')
	// 2. 연산
let 원넓이 = 반지름 * 반지름 * 3.14
	// 3. 연산 결과 출력
console.log('원넓이 : ' + 원넓이)

// 문자 연산 제시
console.log(10*3)
console.log('10'*3) // ????