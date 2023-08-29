
// onchange : 포커스(커서) 변경될때 값이 다르면
// onkeyup : 키보드에서 키를 누르고 떼었을때
// onkeydown : 키보드에서 키를 눌렀을때

/*
	정규표현식 : 문자열에 특정 규칙/패턴 집합 표현할때 표현되는 언어
		문법
			/^ 				: 정규표현식 시작 알림.
			$/ 				: 정규표현식 끝 알림.
			[a-z] 			: 소문자 a~z 패턴 검색
			[A-Z]			: 대문자 A~Z 패턴 검색
			[0-9] 			: 숫자 0~9 패턴 검색
			[가-힣] 			: 한글 패턴
			{최소길이,최대길이} : 문자열 길이 패턴
			+ : 앞에 있는 패턴 1개 이상 반복
			? : 앞에 있는 패턴 0개 혹은 1개 이상 반복
			* : 앞에 있는 패턴 0개 반복
			
			예시]
				1. [a-z]			: 소문자A-Z검색
				2. [a-zA-Z]			: 영문(대,소) 검색
				3. [a-zA-Z0-9] 		: 영문 + 숫자 조합 검색
				4. [a-zA-Z0-9가-힣] 	: 영문 + 숫자 + 한글 조합 패턴
				5. [ac]				: a와 c 패턴
				6. (?=.*[패턴문자])	: 해당 패턴문자가 한개 이상 포함 패턴
					(?=.*[a-z])		: 소문자 한개 이상 필수
					(?=.*[A-Z])		: 대문자 한개 이상 필수
					(?=.*[0-9])		: 숫자 한개 이상 필수
					(?=.*[\d])		: 숫자 한개 이상 필수
					(?=.*[!@#$%^&*]): 패턴문자내 특수문자 한개 이상 필수
				
				/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*]{5,20}$/
				영대문자1개 + 영소문자1개 + 숫자 1개 + 특수문자 1개 이상 필수로 갖는 5~20글자 사이
				
			1. /^[a-z0-9]{5,30}$/ : 영문(소) + 숫자 조합 5~30글자 패턴
			
		패턴 검사
			"패턴".test( 검사할데이터 ) : 해당 데이터가 패턴에 일치하면 true 아니면 false
*/

// 1. 아이디 유효성검사
function idcheck(){ // 실행조건 : 아아디 입력창에 입력할때마다
	
	// 1. 값 호출
	let mid = document.querySelector('.mid').value; 
	let idcheckbox = document.querySelector('.idcheckbox');
	// 2. 유효성 검사
		// 제어문 이용한 검사 : if(mid.length <5 && mid.length >= 30) {}
		// 1. 아이디는  영문+숫자 조합의 5~ 30글자 사이이면
			// 1. 정규표현식 작성.
		let midj = /^[a-z0-9]{5,30}$/
			// 2. 정규표현식 검사.
		console.log(midj.test(mid) )
		console.log(mid)
	if(midj.test(mid)) { // 입력한 값이 패턴과 일치하면
		idcheckbox.innerHTML = '패턴 합격';
		
		// -- 입력한 아이디가 패턴과 일치하면 아이디 중복검사.
		$.ajax({
			url : "/jspweb/MemberFindController",
			method : "get",
			// type 사용하는 이유 : 서로 다른 ajax가 동일한 서블릿과 동일한 get메소드 사용할때.
			data : {type :"mid", data : mid }, // 아이디 중복 검사
			//data : {type :"memail", mid : mid }, // 이메일 중복 검사
			success : r => {
				if(r){idcheckbox.innerHTML='사용중인 아이디입니다.';  checkList[0] = false;}
				else {idcheckbox.innerHTML = '사용가능한 아이디입니다.'; checkList[0] = true;}
				},
			error : e => {}
		})
		
	} else { // 입력한 값이 패턴과 일치하지 않으면
		idcheckbox.innerHTML = '아이디는 영문(소문자)+숫자 조합의 5~30글자만 가능합니다.'; checkList[0] = false;
	}
	// 3. 결과 출력
}

// 2. 비밀번호 유효성 검사 [ 1. 정규표현식 검사 2.비밀번호와 비밀번호 확인 일치 여부]
function pwcheck(){
	console.log('패스워드 입력중');
	
	let pwcheckbox = document.querySelector('.pwcheckbox');
	
	// 1. 입력 값 호출
	let mpwd = document.querySelector('.mpwd').value; console.log('mpwd : ' + mpwd);
	let mpwdconfirm = document.querySelector('.mpwdconfirm').value;
	
	// 2. 유효성 검사
		// 1. 정규표현식 만들기 [ 영대소문자(필수) + 숫자 조합 5~20 글자 사이 ]
		//let mpwdj = /^(?=.*[A-Za-z])[A-Za-z0-9]{5,20}&/
		let mpwdj = /^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{5,20}$/
		
		if(mpwdj.test(mpwd)) { // 비밀번호 정규표현식 검사
		
			// 비밀번호 확인 정규표현식 검사
			if(mpwdj.test(mpwdconfirm)) {
				
				// 3. 비밀번호와 비밀번호 확인 일치여부
				if(mpwd == mpwdconfirm) {
					pwcheckbox.innerHTML  = `사용가능한 비밀번호`; checkList[1] = true;
				} else {
					pwcheckbox.innerHTML = `비밀번호가 일치하지 않습니다`; checkList[1] = false;
				}
				
			} else {
				pwcheckbox.innerHTML = `영대소문자1개이상 + 숫자1개이상 조합 5~20글자 사이로 입력해주세요`; checkList[1] = false;
			}
			
		} else {
			pwcheckbox.innerHTML = `영대소문자1개이상 + 숫자1개이상 조합 5~20글자 사이로 입력해주세요`; checkList[1] = false;
		}
		
}

// 3. 이메일 유효성 검사 [ 1. 정규표현식 2. 중복검사] 
function emailcheck() {
	let authReqBtn = document.querySelector('.authReqBtn');
	let emailcheckbox = document.querySelector('.emailcheckbox');
	// 1. 입력된 값 호출
	let memail = document.querySelector('.memail').value;
	
	// 2. 이메일 정규표현식 [  영대소문자+숫자+_-@ ]
		// ljhljs401@naver.com
		// 1. ljhljs401 : 이메일 아이디부분은 영대소문자 , 숫자 , _- 패턴
		// 2. @			: +@ @앞에 패턴이 1개이상 필수
		// 3. 도메인
			// 회사명		: @ 뒤에 그리고 . 앞에 패턴은 a-zA-Z0-9_-
			// .		: +\. : .앞에 패턴이 1개이상 필수
			// 도메인		: . 뒤에 패턴은 a-zA-Z
	let memailj = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+\.[a-zA-Z]+$/
	
	if(memailj.test(memail)) {
		 $.ajax({
         url : "/jspweb/MemberFindController",      
         data : {type :"memail", data : memail },     
         method : "get",   
         success : r => {
			 if(r) {
				 emailcheckbox.innerHTML = `사용중인 이메일 입니다.`; checkList[2] = false;
				 authReqBtn.disabled = true;// 해당 버튼의 disabled 속성 적용
			 } else {
				 emailcheckbox.innerHTML = `사용 가능한 이메일 입니다.`;
				authReqBtn.disabled = false;// 해당 버튼의 disabled 속성 해제
			 }
		 },
         error : r => {console.log(r);}        
      })
	} else {
		emailcheckbox.innerHTML = `이메일 형식에 맞게 입력해주세요`;
		authReqBtn.disabled = true;// 해당 버튼의 disabled 속성 적용
		checkList[2] = false;
	}
}

// 4. 인증요청 버튼을 눌렀을때.
function authReq() {

	// --------------------테스트용 -----------------------//
	let authbox = document.querySelector('.authbox')
   
   // 2. auth html 구성 
   let html = `<span class="timebox">02:00</span>
            <input class="ecode" type="text" /> 
            <button onclick="auth()" type="button">인증</button> `
   // 3. auth html 대입 
   authbox.innerHTML = html;
   // 4. 타이머 실행
   authcode = "1234" ;        // [ 테스트용 ] 임의로 인증 코드를 '1234'
   timer = 120;       // [ 테스트용 ] 인증 제한시간 10초 
   settimer();         // 타이머 실행 
	//-------------------------이메일-----------------------------//
	// --- 인증요청시 서블릿통신 [ 인증코드 생성 , 이메일 전송 ]
	/* $.ajax({
         url : "/jspweb/AuthSendEmailController",      
         data : {memail : document.querySelector('.memail').value},      
         method : "get",   
         success : r => { console.log(r);
			 // 1. 'authbox' div 호출
			let authbox = document.querySelector('.authbox');
		
			// 2. auth html 구성
			let html = `<span class = "timebox">02:00</span>
						<input class = "ecode" type = "text" /> 
						<button onclick = "auth()" type = "button">인증</button><br/>`
			// 3. auth html 대입
			authbox.innerHTML = html;		
				
			// 4. 타이머 실행
			authcode = r;	// [Controller에게 전달받은 값이 인증코드]
			timer = 120;
			settimer();
		 },
         error : e => {console.log(e);}        
      });
*/
		}
		
// 4번, 5번 ,6번 함수에서 공통적으로 사용할 변수 [전역변수]		
let authcode = ''; // 인증코드
let timer = 0; // 인증 시간(초) 변수
let timerInter; // setInterval() 함수를 가지고 잇는 변수 [setInterval 종료시 필요]
// 5 타이머 함수
function settimer(){
	timeInter = setInterval(()=>{
		// 시간 형식 만들기
			// 1. 분 만들기 [ 초 / 60 ] => 분 / [ 초 % 60 ] => 나머지 초
			let m = parseInt(timer/60); // 분 계산 [몫]
			let s = parseInt(timer%60); // 초 계산 [나머지]
				// 2. 두자리수 맞춤 3 -> 03
			m = m<10 ? "0"+m : m; // 만약에 분이 한자리수 이면 0붙이고 아니면 그냥
		    s = s<10 ? "0"+s : s; 
		document.querySelector('.timebox').innerHTML = `${m}:${s}`; // 현재 인증 시간(초) HTML 대입
		timer--; // 1씩 차감
		
		// 만약에 타이머가 0보다 작으면 [ 시간 끝 ]
		if(timer < 0) {
			// 1. setInterval 종료 [ 누구를 종료할건지 식별자 필요 , 변수선언해야됌 = timeInter]
			clearInterval(timeInter)
			// 2. 인증실패 알림
			document.querySelector('.emailcheckbox').innerHTML = `인증실패`;
			// 3. authbox 구역 HTML 초기화
			document.querySelector('.authbox').innerHTML = ``;
			checkList[2] = false;
		}
	},1000);
}

// 6. 인증요청후 인증코드를 입력하고 인증하는 함수
function auth() {
	console.log('auth');
	
	// 1. 입력받은 인증코드
	let ecode = document.querySelector('.ecode').value;
	
	// 2. 비교 [ 인증코드와 입력받은 인증코드 ]
	if( authcode == ecode) {
		// 1. setInterval 종료
		clearInterval(timeInter);
		// 2. 인증 성공 알림
		document.querySelector('.emailcheckbox').innerHTML =`인증성공`; 
		// 3. authbox 구역 HTML 초기화
		document.querySelector('.authbox').innerHTML =``;
		checkList[2] = true;
		
	} else {
		// 1. 인증 코드 불일치 알림
		document.querySelector('.emailcheckbox').innerHTML =`인증 코드 불일치`; checkList[2] = false;
	}
}

// 7. 첨부파일에 사진 등록시 등록 사진을 HTML 표시하기 < 등록 사진을 미리보기 기능 >
function preimg(object){ console.log('사진 선택 변경');
	console.log(object); // 이벤트 발생시킨 태그의 DOM객체를 인수로 받음
	console.log(document.querySelector('.mimg'));
	// 1. input태그의 속성 [type , class , onchange , name 등등]
	// 1. input태그 이명서 type = "file" 이면 추가적인 속성
		// .files : input type = "file" 에 선택한 파일 정보를 리스트로 받음
	console.log(object.files);
	console.log(object.files[0]); // 리스트중에서 하나의 파일만 가져오기
	
	// ------ 해당 파일을 바이트코드 변환
	// 2. JS 파일클래스 선언
	let file = new FileReader(); // 파일 읽기 클래스 이용한 파일 읽기 객체 선언
	// 3. 파일 읽어오기 함수 제공
	file.readAsDataURL(object.files[0]); // input에 등록된 파일리스트중(object.files) 1개를 파일객체로 읽어오기
		console.log(file);
	// 4. 읽어온 파일을 해당 html img 태그에 load
	file.onload = e => { // onload() : 읽어온 파일의 바이트코드를 불러오기
		console.log(e); // e : 이벤트 정보
		console.log(e.target); 	// onload() 실행한 FileReader 객체
		console.log(e.target.result); // 읽어온 파일의 바이트 코드
		document.querySelector('.preimg').src = e.target.result; // img src 속성에 대입
	}
	
	
} // f end

let checkList = [false , false , false]; // [0] : 아이디 통과여부 , [1] : 패스워드통과여부 [2] : 이메일통과여부
	// true 통과 , false 통과x
// 8.회원가입 메소드 
function signup() {
	
	// 1. 아이디/비밀번호/이메일 유효성 검사 통과 여부 체크
		console.log(checkList)
		if(checkList[0] && checkList[1] && checkList[2]) { // checkList에 저장된 논리가 모두 true이면
			console.log('회원가입 진행 가능');
			
			// 2. 입력받은 데이터를 한번에 가져오기 form태그 이용
				// <form> 각종 input/button </form>
				// 1. form객체 호출 document.querySelectorAll(폼태그식별자)
				let signupForm = document.querySelectorAll('.signupForm')[0];
					console.log(signupForm);
				// 2. form 데이터 객체화
					// 일반객체로 첨부파일 전송X -> FormData객체 이용시 첨부파일 전송 가능
				let signupData = new FormData(signupForm); // 첨부파일[ 대용량 데이터 ]시 필수..
					console.log(signupData);
				
				// 3. AJAX에게 첨부파일[대용량] 전송 하기
				// 첨부파일 있을때 다름 (기존 json 형식의 전송x , form객체 전송 타입으로 변환)
				$.ajax({
					url : "/jspweb/MemberInfoController",
					method : "post",			// 첨부파일 form전송은 무조건 post 방식
					data : signupData ,			// formData 객체
					contentType : false,		// form 객체 전송 타입
					processData : false,
					success : r => { console.log(r)},
					error : e => { console.log(e)},
					
				})
				// 2. 첨부파일 있을때 [ 기존 json형식의 전송x form객체 타입 변환 ]
			
		} else {
			console.log('회원가입 진행 불가능');
		}
	
}

// 0. 유효성 검사가 없는 회원가입 메소드

/*function signup() {
	
	// 1. HTML에 가져올 데이터의 tag객체 호출 [ DOM객체 : html태그를 객체화 ]
	let midInput = document.querySelector('.mid'); 
	let mpwdInput = document.querySelector('.mpwd'); 
	let mpwdconfirmInput = document.querySelector('.mpwdconfirm'); 
	let memailInput = document.querySelector('.memail'); 
	let mimgInput = document.querySelector('.mimg'); 
	
	// 2. (객체화)
	let info = {
		mid : midInput.value,
		mpwd : mpwdInput.value,
		memail : memailInput.value,
		mimg : mimgInput.value
	}
	// 3. 유효성 검사
	
	// 4. AJAX메소드를 이요한 Servlet와 통신
	 $.ajax({
         url : "/jspweb/MemberInfoController",      
         data : info,      
         method : "post",   
         success : r => {console.log('통신성공');
         
         if(r == true) {
			 console.log('회원가입성공');
		 }else {console.log('회원가입실패');}
         
         } ,       
         error : e => {console.log('통신실패');}       
      });



	// 5. Servlet의 응답에 따른 제어

}
*/




/*
	setInterval() : 특정시간마다 함수를 실행 함수
		1. 정의
			let 변수명 = setInterval(function 함수명(){} , 밀리초)
			let 변수명 = setInterval(function(){} , 밀리초)
			let 변수명 = setInterval(함수명(), 밀리초)
			let 변수명 = setInterval(() => {} , 밀리초)
		2. 종료
			clearInterval(setInterval변수명)



*/

	// setInterval( 함수명 , 실행간격[밀리초]) : 특정시간마다 함수를 실행 함수
	// setInterval(() => {console.log('안녕')}, 1000);