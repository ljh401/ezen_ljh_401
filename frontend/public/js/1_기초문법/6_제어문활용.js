/*

      조건 : 반복문X 입력:prompt 출력 : console 
       문제 1 : 2개의 정수 를 입력받아서 가장 큰수를 출력 
       문제 2 : 3개의 정수 를 입력받아서 가장 큰수를 출력     [ max 함수 x ]
       문제 3 : 4개의 정수 를 입력받아서 가장 큰수를 출력    [ max 함수 x ]
       
       문제 4 : 3개의 정수 를 입력받아서 오름차순 / 내림차순 출력 
       문제 5 : 4개의 정수 를 입력받아서 오름차순 / 내림차순 출력 
       
       문제 6 : 점수를 입력받아 점수 90점이상 합격 출력 아니면 탈락 출력 
       문제 7 : 점수를 입력받아 점수 90점이상 A등급 출력 
                            80점이상 B등급 출력 
                            70점이상 C등급 출력  
                            그외 재시험
       문제 8 : 아이디와 비밀번호 입력받기 
             회원아이디가 admin 이고 비밀번호가 1234 이면 로그인 성공 출력 
                                     아니면 로그인실패 출력

*/

// 문제1 : 2개의 정수를 입력받아서 가장 큰 수를 출력
	// 1. 2개 입력받아 각 변수에 저장
		// 1. 첫번째 값 입력받기
		// 2. 입력받은 값을 변수에 저장 정수1
		// 3. 두번째 값을 입력받기
		// 4. 입력 받은 값을 변수에 저장 정수2
		// 5. 가장큰수?? 비교/논리/조건/판단 => 연산자
		// 6. >= <= < > 연산자 선택
		// 7. if 이용한 출력
let 정수1 = Number(prompt('정수 입력 :'))
let 정수2 = Number(prompt('정수 입력 :'))

if(정수1 > 정수2) {console.log('가장 큰 수는 : '+정수1+'입니다.')
}  else {console.log('가장 큰 수는 : '+정수2+'입니다.')}

// 문제2
let num1 = Number(prompt('정수 입력 :'))
let num2 = Number(prompt('정수 입력 :'))
let num3 = Number(prompt('정수 입력 :'))

if(num1>num2 && num2>num3) {console.log('가장 큰 수는 :'+num1+'입니다.')}
else if(num2>num1 && num2>num3) {console.log('가장 큰 수는 :'+num2+'입니다.')}
else {console.log('가장 큰 수는 :'+num3+'입니다.')}

// 문제3
let value1 = Number(prompt('정수 입력 :'))
let value2 = Number(prompt('정수 입력 :'))
let value3 = Number(prompt('정수 입력 :'))
let value4 = Number(prompt('정수 입력 :'))

if(value1>value2 && value1> value3 && value1> value4) {console.log('가장 큰 수는 :'+value1+'입니다.')}
else if(value2>value1 && value2> value3 && value2> value4) {console.log('가장 큰 수는 :'+value2+'입니다.')}
else if(value3>value1 && value3> value2 && value3> value4) {console.log('가장 큰 수는 :'+value3+'입니다.')}
else {console.log('가장 큰 수는 :'+value4+'입니다.')}

// 문제4

let int1 = Number(prompt('정수 입력 :'))
let int2 = Number(prompt('정수 입력 :'))
let int3 = Number(prompt('정수 입력 :'))
// 정렬 = 하나씩 비교 해서 자리 교체
if(int1 > int2) {	// 현재 코드 기준 조건1 : > 오름차순  < 내림차순
	let temp = int1;
	int1 = int2;
	int2 =temp;
}
if(int1 > int3) {
	let temp = int1
	int1 = int3;
	int3 = temp;
}
if(int2 > int3) {
	let temp = int2;
	int2 = int3;
	int3 = temp;
}
console.log(int1 +' '+int2+' '+int3)

// 문제5
let in1 = Number(prompt('정수 입력 :'))
let in2 = Number(prompt('정수 입력 :'))
let in3 = Number(prompt('정수 입력 :'))
let in4 = Number(prompt('정수 입력 :'))

if(in1 > in2) {
	let temp = in1;
	in1 = in2
	in2 = temp;
}
if(in1 > in3) {
	let temp = in1;
	in1 = in3
	in3 = temp;
}
if(in1 > in4) {
	let temp = in1;
	in1 = in4
	in4 = temp;
}
if(in2 > in3) {
	let temp = in2;
	in2 = in3;
	in3 = temp;
}
if(in2 > in4) {
	let temp = in2;
	in2 = in4;
	in4 = temp;
}
if(in3 > in4) {
	let temp = in3;
	in3 = in4;
	in4 = temp;
}
console.log(in1 +' '+in2+' '+in3+' '+in4);

// 문제6
let score = prompt('점수 입력 :')
if(score >=90) {console.log('합격')}
else {console.log('탈락')}

// 문제7
let score1 =prompt('점수 입력 :')
if(score1 >=90){console.log('A등급')}
else if(score1 >= 80){console.log('B등급')}
else if(score1 >= 70){console.log('C등급')}
else {console.log('재시험')}

// 문제8
let 아이디 = prompt('아이디 입력 : ')
let 비밀번호 = prompt('비밀번호 입력 : ')

if(아이디 == 'admin') { // 아이디 일치하면
	if(비밀번호 == '1234'){
		console.log('로그인성공')
	}
	else{  //비밀번호가 일치하지 않으면
		console.log('로그인 실패:비밀번호가 일치하지 않습니다.')
	}
}
else { // 아이디가 다르면
	console.log('로그인 실패: 없는 아이디')
}