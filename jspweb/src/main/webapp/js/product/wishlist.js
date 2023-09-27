// 만약에 ajax가 비동기이면 [ async : true ] 해당 함수를 실행하고 ajax결과가 오기 전에 아래코드들이 실행됨
// 만약에 ajax가 동기 [ false ] 이면 해당 함수를 실행하고 ajax를 결과가 오기전까지 대기상태.


getWishlist();
let checkIndex = [] ; // 현재 체크된 인덱스
/*
	1. document.querySelector(선택자); 	: 해당 선택자의 dom객체로 1개 가져오기 	[ 객체 ]
	2. document.querySelectorAll(선택자);	: 해당 선택자의 dom객체를 여러개 가져오기 	[ 배열 ]

*/
/* 0. 제품목록에서의 선택상자에서 모두 체크기능 */
	// 1. 모든 checkbox를 가져오기
	let checkList = document.querySelectorAll('.checkbox');
		console.log(checkList);
	// 2. 첫번째 체크박스를 클릭 이벤트
		// dom 객체명.addEventListener('이벤트명' , (이벤트결과매개변수) => {})
	checkList[0].addEventListener('click' , (e) =>{
		console.log('첫번째 체크박스'); console.log(e)
		console.log(checkList[0].checked); 
		// type = "checkbox"인 input태그는  checked 속성 이용한 체크여부 확인하기 true : 체크상태 / false 반대
		// 3. 만약에 첫번째 체크박스가 체크 되면 모든 체크박스는 체크 활성화
		if(checkList[0].checked == true) {
			checkList.forEach((check) => {check.checked = true;})
		} else {
			checkList.forEach((check) => {check.checked = false;})
		}
	})
	

// 0. 로그인제 페이지
if(loginState == false) {location.href="/jspweb/member/login.jsp"}


// 1. 찜한 제품 목록 출력하기

function getWishlist(){
	
	$.ajax({
		url : "/jspweb/PwishListController",
		async : false,
		method : "get",
		data : { type : "findByAll"},
		success : jsonArray => { console.log(jsonArray);
		
			let table = document.querySelector('.table')
			
			let html = `<tr>
                 <th width="5%"><input class="checkbox" type="checkbox"></th>
                 <th width="5%"> 이미지 </th>
                 <th width="40%"> 제품 정보 </th>
                 <th width="10%"> 가격 </th>
                 <th width="10%"> 비고 </th>
              </tr>`;
				//
				jsonArray.forEach((p) => {
					html +=`
					<tr>
		                 <td><input  class="checkbox"  type="checkbox"></td>
		                 <td><img src = "/jspweb/product/img/${Object.values(p.imgList)[0]}" width="100%"> </td>
		                 <td style = "text-align : left; padding-left : 20px;"> ${p.pname}</td>
		                 <td> ${p.pprice.toLocaleString()}원</td>
		                 <td> <button onclick = "deleteWish()" type="button">X</button></td>
              		</tr>`;
					
				})
				table.innerHTML = html;
		
		}
	});
}
	
// 2. x버튼을 눌렀을때 개별 찜 제품 취소/제거
function deleteWish(pno){
	$.ajax({
		url : "/jspweb/PwishListController",
		async : false,
		method : "delete",
		data : { pno : pno },
		success : jsonArray => { console.log(jsonArray); }
		})
}