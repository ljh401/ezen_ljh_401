console.log('library.js');

let lno = ""; // 사용자가 선택한 좌석 번호를 저장할 변수

function getValue(button) {
    lno = button.textContent;
    alert("눌린 버튼의 값: " + lno);
}
function inroom(){ // 입실
   
   document.querySelector('.getValue')
   let lnameInput = document.querySelector('.lname')
   let lphoneInput = document.querySelector('.lphone')
   console.log(lphoneInput)
   console.log(lnameInput)
   console.log(lno)
   let info ={ 
      lno : lno ,
      lname : lnameInput.value , 
      lphone : lphoneInput.value, 
   }
   console.log(info)
   $.ajax({
      url : "/jspweb/library" ,
      method : "post",
      data : info ,
      success : r => {
         alert('입실 성공');
      } ,
      error : e => {}
   })
}
function outroom() {
	
    if (!lno) {
        alert('좌석을 선택하세요.');
        return;
    }

    let lphone = prompt("퇴실을 위한 전화번호 입력:");
    if (!lphone) return; // 사용자가 프롬프트를 취소한 경우

    $.ajax({
        url: "/jspweb/library",
        data: { lno: lno, lphone: lphone },
        method: "delete",
        success: function (result) {
            if (result) {
                alert('퇴실완료');
            } else {
                alert('없는 전화번호이거나 선택한 좌석이 아닙니다.');
            }
        },
        error: function (error) {
            console.error(error);
        },
    });
}

