console.log();

function 예제1() { console.log('예제1() Open')
   // ajax 메소드 이용한 서블릿과 통신
   $.ajax({
      url : "/jspweb/Test02", 
      method : "get", 
      success : function 함수명(result) {console.log(result)}
   });
}

function 예제2() { console.log('예제2() Open')
   // ajax 메소드 이용한 서블릿과 통신
   $.ajax({
      url : "/jspweb/Test03", 
      method : "get", 
      success : function 함수명(result) {console.log(result)}
   });
}

function 예제3() { console.log('예제3() Open')
   // ajax 메소드 이용한 서블릿과 통신
   $.ajax({
      url : "/jspweb/Test04", 
      method : "get", 
      success : function 함수명(result) {
		  console.log(result);
      	  console.log(result.title);
      	  console.log(result.content);
      }
   });
}

function 예제4() { console.log('예제4() Open')
   // ajax 메소드 이용한 서블릿과 통신
   $.ajax({
      url : "/jspweb/Test05", 
      method : "get", 
      success : function 함수명(result) {
		  console.log(result);
      	  console.log(result.title);
      	  console.log(result.content);
      }
      
   });
}


/*
   $.ajax({
      url : "통신할경로/서블릿주소",
      method : "통신방법:get,post,put,delete 선택",
      succes : function 함수명(통신반환함수) {통신성공했을때 실행코드}   
      error : function 함수명(반환한함수) {통신실패했을때 실행코드}
   });
   
   - sucess/error 속성에서 통신 결과의 반환값 받는 함수 작성시 
      1. success : function 함수명(통신반환함수) {통신성공했을때 실행코드}
      2. success : function (통신반환함수) {통신성공했을때 실행코드}
      3. success : (통신반환함수) => {통신성공했을때 실행코드}
   
   -------------------------------------------------------------
      
   서블릿
      - request : 요청 객체
      - response : 응답 객체
         - response.getWriter().print(데이터) : 웹 출력 
         - response.setContentType()   
*/ 
   