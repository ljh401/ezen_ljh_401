
let 선택번호목록 =[]
function 로또구매(){
   console.log('로또구매() 실행 ');
  
   let buttonHTML = ``;
   for( let i = 1 ; i<=45 ; i++ ){ 
   
    
      buttonHTML += `<button 
                     onclick="숫자버튼( ${ i } )" > 
                     ${ i } 
                  </button>` 
                 
     
      if( i % 5 == 0 ) buttonHTML+= `<br/>`
   } 
    
   document.querySelector('.버튼목록구역').innerHTML = buttonHTML;
} 


function 숫자버튼( 선택된번호 ){
   console.log( 선택된번호 + ' 숫자버튼을 클릭했군요. ')
   
  
   
   if(선택번호목록.indexOf(선택된번호) != -1){ 
      
         alert('이미 선택된 번호 입니다.[해당 숫자는 취소 합니다.] '); 
         선택번호목록.splice(선택번호목록.indexOf(선택된번호) , 1) 
         선택번호출력();     
         return; 
   } 
   
   
    if(선택번호목록.length ==6){
       alert('이미 6개 번호 모두 선택하셨습니다.');
       return;
    }
   
   
   선택번호목록.push(선택된번호); console.log(선택번호목록)
   선택번호출력();
} 


function 선택번호출력(){
    document.querySelector('.선택번호출력구역').innerHTML = 선택번호목록;
    if(선택번호목록.length ==6){
       document.querySelector('.추첨결과버튼구역').innerHTML =
                                              `<button onclick="추첨결과()">추첨결과보기</button>`
    }
    else {
       document.querySelector('.추첨결과버튼구역').innerHTML =' '
    }
}
function 추첨결과(){
   alert('로또 추첨 진행 합니다. [잠시 대기]');
   

   console.log(Math.random())
   console.log(Math.random()+1) 
   console.log(Math.random()*45+1)
 									
  
   console.log(parseInt(Math.random()*45+1))
   
    
 	let 추첨번호목록 = []; 
   
   for(let i = 1; i<=6; i++) {
	  
	   let 추첨번호 = Math.random()*45+1; 
	   if(추첨번호목록.indexOf(추첨번호)== -1){ 
		   추첨번호목록.push(추첨번호);
	   } else { 
		   i--; 
	   }
   }
   console.log(추첨번호목록)
   

   		let 맞은개수 = 0;
   		for(let i =0 ; i<선택번호목록.length; i++) {
			   if(추첨번호목록.indexOf(선택번호목록[i]) != -1) {
				   맞은개수++;
			   }
		   }
		alert('맞은개수 :' + 맞은개수)   ;
		
		for( let 선택번호 in 선택번호목록) {
			console.log(선택번호)
			if(추첨번호목록.indexOf(선택번호목록[인덱스]) != -1){맞은개수++;}
		}
		alert('맞은개수 :' + 맞은개수)   ;

		for(let 데이터 of 선택번호목록) { 
			console.log(데이터)
			if(추첨번호목록.indexOf(데이터)!= -1) {맞은개수++;}
		}
		alert('맞은개수 :' + 맞은개수)   ;
		
		
		선택번호목록.forEach((데이터,인덱스)=>{ 
			console.log(데이터); console.log(인덱스);
			if(추첨번호목록.indexOf(데이터)!= -1) {맞은개수++;}
		 });		
} 




 