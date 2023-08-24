console.log('accountbook.js 열림');

function awrite(){
	let acontentInput = document.querySelector('.acontent'); console.log('acontent' + acontentInput);
	let amoneyInput = document.querySelector('.amoney'); console.log('amoney' + amoneyInput);
	let adateInput = document.querySelector('.adate'); console.log('adate' + adateInput);
	
	let info = {
		acontent : acontentInput.value,
		amoney : amoneyInput.value,
		adate : adateInput.value
	};console.log(info);


	$.ajax({
		url : "/jspweb/Accountbook",
		method : "post",
		data : info,
		success : function f(r){console.log("통신성공"); console.log(r); 
		if(r == true){ alert('등록성공'); aread();
		acontentInput.value = ''; amoneyInput.value = ''; adateInput.value = '';}
		else {alert('등록실패');}
		},
		
		error : function f(r){}
	});
}

aread();
function aread(){ 
	$.ajax({
		url : "/jspweb/Accountbook",
		method : "get",
		data : "",
		success : function f(r){console.log(r); 
		
		let output = document.querySelector('.account_Bottom');
		let html = ``;
		
			for(let i = 0; i<r.length; i++) {
				html += `<div class = "accountbox"> <!-- 방문록 1개의 표시 구역 -->
               				<div class = "accountbox_top">
                  				<div>${r[i].amoney}원</div>
                  				<div class = "accountdate">${r[i].adate}</div>
               				</div>
               					<div class = "accountbox_center">${r[i].acontent}</div>
              			 	<div class = "accountbox_bottom">
			                  <button onclick="aupdate(${r[i].ano})" type = "button">수정</button>
			                  <button onclick="adelete(${r[i].ano})" type = "button">삭제</button>
               				</div>
            			</div>`
			}

		output.innerHTML = html;
		},		
		error : function f(r){}
	});
} // f e

function aupdate(ano) {
	let acontent = prompt('수정할 내용 입력 :');
	let amoney = prompt('수정할 금액 입력 :');
	let adate = prompt('수정할 날짜 입력 :');
	
	$.ajax({
		url : "/jspweb/Accountbook", // 통신할 백엔드(컨트롤러 주소)	
		method : "put",
		data : {ano : ano , acontent : acontent, amoney : amoney , adate : adate},
		success : function f(r){console.log("put");
			if(r == true) {alert('수정성공'); aread();}
			else {alert('수정 실패');}
		
		},
		error : function f(r){console.log(r);}
		
	});
}

function adelete(ano) {
	$.ajax({
		url : "/jspweb/Accountbook",
		method : "delete",
		data : {ano : ano},
		success : function f(r){console.log("delete");
			if(r == true) {alert('삭제성공'); aread();}
			else {alert('삭제 실패')}
		},
		error : function f(r){console.log(r);}
		
	});
}