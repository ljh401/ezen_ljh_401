
// 제품 등록은 회원제이므로 비로그인시 접근 제한
if( loginState == false) {
	alert('로그인후 사용가능한 페이지');
	location.href = "/jspweb/member/login.jsp";
}

/*------------------------------카카오 지도 표시 --------------------------------------*/

	// 1. 현재 접속한 클라이언트 [브라우저]의 위치 좌표 구하기
navigator.geolocation.getCurrentPosition( e=> {
	
	console.log(e);
	console.log(e.coords);
	console.log(e.coords.latitude);
	console.log(e.coords.longitude);
	let currentlat = e.coords.latitude;
	let currentlng = e.coords.longitude;
	
	
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(currentlat, currentlng), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 지도를 클릭한 위치에 표출할 마커입니다
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);

// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 
    
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);
    
    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
    message += '경도는 ' + latlng.getLng() + ' 입니다';
    
    var resultDiv = document.getElementById('clickLatlng'); 
    resultDiv.innerHTML = message;
    
    plat = latlng.getLat(); // 위도와 경도를 전역변수로 이동후 제품등록시 사용.
    plng = latlng.getLng();
    
	});
}); // getCurrentPosition end

let plat = 0; // 현재 카카오에서 선택한 좌표.
let plng = 0;


// 1. 제품 등록
function onRegister(e){
	
	// 1. form dom객체 호출
	let registerForm = document.querySelectorAll('.registerForm')[0]; console.log(registerForm);
	// 2. formData 객체 생성
	let formData = new FormData(registerForm);
	console.log(formData);
	
		// *** 카카오지도에서 선택된 좌표 사용했을때.
		if(plat == 0 || plng == 0) { alert('제품위치를 선택해주세요.'); return ;}
		
		formData.set('plat' , plat);
		formData.set('plng' , plng);
		
		// *** 드랍앤 드랍을 사용했을때.
			// 현재 드랍된 파일들을 form 같이 추가하기 [ 왜? 드랍된 파일은 inputㅐ그 드랍된 파일이 아니므로]
			if(fileList.length >= 1) { // 드랍된 파일이 존재하면
				fileList.forEach( f => {
					formData.append('fileList', f);
					// 폼데이터객체.set('키',값)
					
					formData.delete("");
				})
				
			}
	// 3. 
	$.ajax({
		url : "/jspweb/ProductInfoController",
		method : "post",
		data : formData,
		contentType : false,
		processData : false,
		success : result => {
			if(result ==  true) {
			
			alert('제품등록');
			location.href = "/jspweb/index.jsp";
			} else {
				alert('제품등록실패')
			}
			
			}
	})
	
}

// 2. 드래그 앤 드랍 
   // 1. 드래그 앤 드랍 할 구역 dom객체 호출 
let fileDropBox = document.querySelector('.fileDropBox');

   // 2. 해당 dom객체에 구역내 드래그가 들어왔을때.
fileDropBox.addEventListener( "dragenter" , (e)=>{
   e.preventDefault(); // 상위 이벤트 무시하고 현 이벤트 우선 점유
   console.log( '드래그가 들어왔어.' );
});
   // 3. 해당 dom객체에 구역내 드래그가 올라왔을때.
fileDropBox.addEventListener( "dragover" , (e) => {
   e.preventDefault(); // 상위 이벤트 무시하고 현 이벤트 우선 점유
   console.log( '현재구역에 드래그가 위치중.');
   fileDropBox.style.backgroundColor = '#e8e8e8';
});
   // 4. 해당 dom객체에 구역내 드래그가 나갔을때
fileDropBox.addEventListener( "dragleave" , (e)=>{ 
   e.preventDefault(); // 상위 이벤트 무시하고 현 이벤트 우선 점유
   console.log( '드래그가 나갔을때.')
   fileDropBox.style.backgroundColor = '#ffffff';
});
   // 5.해당 dom객체에 구역내 드래그가 드랍(마우스를 놓았을때)했을때.
fileDropBox.addEventListener( 'drop' , (e)=>{
   console.log( '해당 드래그가 드랍했어.' );
   console.log( e );
   
   // * 브라우저 자체적으로 'drop' 이벤트 우선적으로 실행되므로 해당 이벤트실행 불가능 
   // - 해결방안 : 기존 상위(브라우저) 이벤트 무시 
   e.preventDefault(); // 상위 이벤트 무시하고 현 이벤트 우선 점유
   
   // -------- 드랍된 파일의 정보??? ------------- //
      // 1. 드랍된 데이터 정보를 이벤트 결과에서 찾기 
      console.log( e.dataTransfer ) 
      console.log( e.dataTransfer.files )
      console.log( e.dataTransfer.files[0] )
      console.log( e.dataTransfer.files[0].name )
      // 2. 드랍된 파일들을 특정 리스트에 저장 
      let files = e.dataTransfer.files;
      for( let i = 0 ; i<files.length ; i++ ){
         if( files[i] != null && files[i] != undefined ){
            // 드랍된 파일의 정보가 존재하면 [ null 그리고 undefined 아닌 상태 ] 
            fileList.push( files[i] ); 
         }
      }
      // 3. 배경색 초기화 
      fileDropBox.style.backgroundColor = '#ffffff';
      // 4. 현재 드랍된 파일의 정보를 드래그앤드랍 구역에 표시 
      fileListPrint()
}); // f end
 
let fileList = [] ; // 현재 드래그앤드랍으로 등록된 파일들 

// 3. 현재 드랍된 파일들의 정보를 구역에 표시하는 함수 
function fileListPrint(){
   // 1. [어디에]fileDropBox 에  [ fileDropBox dom객체가 함수밖에 존재하므로 재호출 X ]
   // 2. [무엇을] HTML 구성 
   let html = ``;
      fileList.forEach( ( f , i ) => { 
         let fname = f.name; // 파일의 이름 
         let fsize = ( f.size/1024 ).toFixed(1) // 파일의 용량 [ 바이트 단위 ] kb 변환 
                  // .toFixed(소수점단위) : 소수점 자르기 
         html += `<div>
                  <span> ${fname} </span>
                  <span> ${fsize} </span>
                  <span> <button onclick="fileDelete(${ i })" type="button">삭제</button> </span>
               </div>`;
      })
   // 3. [ 대입 ]
   fileDropBox.innerHTML = html;
} // f end 
// 4. 현재 드랍된 파일들 중에 삭제버튼 클릭시 해당 파일 제거 
function fileDelete( i ){  fileList.splice( i , 1 ); fileListPrint(); }
