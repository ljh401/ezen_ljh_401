/*

요구사항1 : 아이디와 비밀번호를 입력받아 회원가입을 진행하고 싶어요.
   [조건1] 
      입력 <input> 사용 해서 아이디 입력받기 
      입력 <input> 사용 해서 비밀번호 입력받기 
   [조건2]
      * 1차원배열만 사용 [ 배열 변수 여러개 사용 가능 ]
   [조건3]
      <input type="button"> 사용해서 회원가입 이벤트 실행 [ 회원가입함수 구현하기 ]

-------------------------------------------------------------------
요구사항2 : 아이디와 비밀번호를 입력받아 로그인 을 진행하고 싶어요.
   [조건1]
      입력 <input> 사용 해서 아이디 입력받기 
      입력 <input> 사용 해서 비밀번호 입력받기 
   [조건2] 
      만약에 배열에 존재하는 아이디,비밀번호가 일치한 데이터가 있을경우
      [ 로그인 성공 ] 아니면  [ 로그인 실패 ] alert 로 출력해주세요.
   [조건3]
      <input type="button"> 사용해서 로그인 이벤트 실행    [ 로그인함수 구현하기 ]
------------------------------------------------------------------------
요구사항3 : 유효성검사 진행해주세요.  
   1. 만약에 입력상자[input] 에 공백 이면 학번을 입력해주세요~       [ if( sno2Value == '' ) ]
   2. 회원가입 이나 로그인시 성공시에 입력상자[input] 의 value 다시 공백으로 초기화 해주세요.   [ sno2.value = '' ]
   3. 입력상자[input]에 입력한 아이디 와 비밀번호 가 8자리가 이상일경우에만 회원가입하도록 해주세요.   [ sno2Value.length !=8  ]


 */
let 로그인리스트 = []
let 회원리스트 = []

 function login(){
	 
	 let loginInput2 = document.querySelector(".login_input2")
	 
	 let login2 = loginInput2.value
	 let loginInput1 = document.querySelector(".login_input1")
	 
	 let login1 = loginInput1.value
	 let loginlistUl = document.querySelector(".loginlist")
	 let login2listUl = document.querySelector(".loginlist")
	 
	 if(signup1.length < 8 || signup2.length < 8) {
		  alert('글자수는 8 이상이어야합니다.')
	  } else {
		 if (회원리스트.indexOf(signup1) != -1) {
		  alert('이미 존재하는 아이디입니다.')  } 
	  	else{ 
			   alert(' 회원가입 성공! ');
			  회원리스트.push(signup1);  }
	  		 }
	 
	 
	 
	 loginlistUl.innerHTML = '<li>'+로그인리스트+'</li>'
	 
	 loginInput1.value=''
	 
	 login2listUl.innerHTML = '<li>'+로그인리스트+'</li>'
	 
	 loginInput2.value=''
	 
 }
 
 function signup(){
	
	 
	 let signupInput1 = document.querySelector(".signup_input1")
	 let signupInput2 = document.querySelector(".signup_input2")
	 let signup1 = signupInput1.value
	 let signup2 = signupInput2.value
	 
	 
	 let signup2listUl = document.querySelector(".signuplist")
	 
	 signup2listUl.innerHTML = '<li>'+회원리스트+'</li>'
	 
	 signupInput2.value=''
	 
	 if(signup1.length < 8 || signup2.length < 8) {
		  alert('글자수는 8 이상이어야합니다.')
	  } else {
		 if (회원리스트.indexOf(signup1) != -1) {
		  alert('이미 존재하는 아이디입니다.')  } 
	  	else{ 
			   alert(' 회원가입 성공! ');
			  회원리스트.push(signup1);  }
	  		 }
	  
	 let signuplistUl = document.querySelector(".signuplist")
	 
	 signuplistUl.innerHTML = '<li>'+ 회원리스트 +'</li>'
	 
	 signupInput1.value=''
	 
	 
	 
	  
	 
	
	 
	 
	
	  
 }
 
  
 