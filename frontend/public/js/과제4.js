console.log('js실행')

let 작성리스트 = [];

function 글등록() {console.log('등록()함수실행')
	let writer = document.querySelector('#writer').value;		console.log( writer );
	let pwd = document.querySelector('#pwd').value;		console.log( pwd );
	let title = document.querySelector('#title').value;		console.log( title );
	let content = document.querySelector('#content').value;		console.log( content );
	
	if( writer == '' || pwd == '' ) { alert('빈칸이 있으면 안됨.'); return;}
	if( title == '' || content == '' ) { alert('빈칸이 있으면 안됨.'); return;}
	
	let write = {작성자 : writer , 비밀번호 : pwd , 제목 : title , 내용 : content}; console.log(write);
	작성리스트.push(write); console.log( 작성리스트 );
	alert('작성 성공');
	
	document.querySelector('#writer').value = ``
	document.querySelector('#pwd').value = ``
	document.querySelector('#title').value = ``
	document.querySelector('#content').value = ``
	
//	
}

function 글목록() {
	let outTable = document.querySelector('.outTable'); console.log( outTable);
	
	let html = `<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th></tr>`
		for(i=0; i <= 작성리스트.length; i++ ){
			let 작성 = 작성리스트[i];
			
			html += `<tr>
               <td> ${ 날짜배열[인덱스] } </td>
               <td> ${ 항목배열[인덱스] } </td>
               <td> ${ 금액배열[인덱스].toLocaleString() }원 </td>
               <td> <button onclick="삭제(${인덱스})"> 삭제 </button> </td>
            </tr>` // 삭제할 인덱스번호를 삭제() 함수에 인수로 전달
		}
	
}


function 삭제(index) {
	if(작성리스트.indexOf(pwd) != -1) {
		작성리스트.splice(index , 1)
	alert('삭제 성공')
	} else {
		alert('삭제 실패')
	}
	
	
}