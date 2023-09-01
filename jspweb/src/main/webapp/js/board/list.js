
function onWrite(){
   
   if(loginState){ // - 만약에 비 로그인이면 로그인 페이지로 이동
      location.href="/jspweb/board/write.jsp"; // - 로그인이면 쓰기 페이지로 이동
   }else{
      alert('로그인후 글쓰기 가능합니다.');
      location.href="/jspweb/member/login.jsp"; // - 로그인이면 쓰기 페이지로 이동
   }
   
}
getList();
function getList(){
	$.ajax({
		url : "/jspweb/BoardInfoController",
		method : "get",
		data : {},
		success : r=> {console.log(r);
		
		// 1. 출력할 위치
		let boardTable = document.querySelector('.boardTable');
		
		// 2. 출력할 내용 구성
		let html = `<tr>
         		<th>번호</th><th>카테고리</th>
         		<th>제목</th><th>작성자</th><th>조회수</th>
         		<th>작성일</th>
         	</tr>`
         	// * 서블릿으로부터 전달받은 내용[배열] 반복해서 html 구성
         	// 배열명.forEach(반복변수명)  // java -> , js =>
         	r.forEach(b => {
				 html += `<tr>
         		<th>${b.bno}</th>
         		<th>${b.bcname}</th>
         		<th>${b.btitle}</th>
         		<th>${b.mid}</th>
         		<th>${b.bview}</th>
         		<th>${b.bdate}</th>
         	</tr>`
			 }); // f end
			 // 3. 구성된 html  내용을 출력
			 boardTable.innerHTML = html;		
		},
		error : e => {}
	})
}