/*
	변수
		지역변수 : 지역{}에서 태어났으면 지역 밖으로 못나감
			{안산}에서 태어났으면 안산{} 밖으로 못나감
			-{} 안에서 선언된 변수는 {}밖에서 사용 불가능
		전역변수 : 지역{}밖에서 태어났으면 자유롭게 이동 가능
			대한민국에서 태어났으면 안산{} 성남{} 등등 이동 가능
			-{} 밖에서 선언된 변수는 {}안으로 이동 가능
			
	문자열내 변수/배열/객체 포함하는방법 [JS 안에서 HTML 작성시 문자처리]
		1. 작은 따옴표(연결연산자) = '<td>'+변수명/배열명+'</td>'
		2. 백틱(`${}`)			  = `<td>${변수명/배열명}</td>`			
*/
console.log('JS실행')

// 4. 배열 선언
let 방문록배열 = []; //  1. 여럿 함수{}에서 사용하기 때문에 함수 밖에서 선언.
		// 인덱스 = 배열내 저장된 순서 번호
let 방문록배열2 = []; 
// 1. 이벤트 함수 만들기
function 등록() { // s end
	
	// 1. 함수 잘 작동하는지 체크~
	console.log('등록함수 실행');
	
	// 2. <input 태그 호출>
	let contentInput = document.querySelector('.content')
	console.log(contentInput); // 체크~
	
	// 3. 입력받은 값 호출
	let value = contentInput.value;
	console.log(value);
	
	// 4. 배열 등록
	방문록배열.push(value);
	console.log(방문록배열);
	방문록배열2.push(document.querySelector('.writer').value)
	
	// 5. HTML 출력
		// 1. <table> 호출
	let contentTable = document.querySelector('.contentTable') // contentTable은 table태그 가져오는거
	// table 속성은 value 속성이 없음.
		// 2. <table> 안에 있는 HTML 호출
	//let tableHTML = contentTable.innerHTML // contentTable 안에 있는 애들 table 안에 tr같은 애들 데려옴
	let tableHTML = `<tr><th> 내용 </th> <th> 작성자 </th></tr>`
	console.log(tableHTML)
		// 3. innerHTML 내용 !!추가!!(+=를 사용하여)
		// * 배열내 존재하는 인덱스(length = 배열길이) 까지만 출력
		// * 반복문 이용한 0번 인덱스 부터 마지막 인덱스 까지 출력
		// 반복문 0번 부터 마지막 인덱스까지 1개씩 출력
		// 0번부터(초기값) ; 마지막 인덱스까지(조건); 1개씩 (증감식)
	// 1. 반복문을 이용한 출력
	for(let i = 0; i < 방문록배열.length ; i ++){
		/* tableHTML+= '<tr><td>'+방문록배열[0]+'</td><td></td></tr>' */
	tableHTML += `<tr><td>${방문록배열[i]}</td><td>${방문록배열2[i]}</td></tr>`
	}
	
	// 2. 마지막인덱스[최근 등록된 요소] = 배열.length-1
	/*let tableHTML = contentTable.innerHTML*/
	/*tableHTML += `<tr><td>${방문록배열[방문록배열.length-1]}</td><td></td></tr>`*/
	console.log(tableHTML)
		// 4. 추가된 HTML 내용 대입 (=)
		contentTable.innerHTML = tableHTML
} // f end

// 배열은 함수 밖에 만들어야함 . 함수안에 만들면 매번 다시 깡통으로 초기화될수 밖에 없음.
// 함수 위에도 아래도 상관없음(함수는 사용자가 클릭해야 실행되기때문.)