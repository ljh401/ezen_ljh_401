

// 1. 회원가입 메소드
function signup() {
	
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
         success : r => {console.log('통신성공');} ,       
         error : e => {console.log('통신실패');}       
      });



	// 5. Servlet의 응답에 따른 제어

}