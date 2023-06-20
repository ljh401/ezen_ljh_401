/*
	
	[ JS 연산자 과제1 ]
   문제11 : 정수 3개를 입력받아 오름차순 으로 출력    [ 7 5 9 -> 5 7 9]
   문제12 : [ 가위바위보 게임 ] 
   - 가위가 '0' 이고 바위가 '1' 이고 보가 '2' 일때 플레이어1와 플레이어2 가 있습니다. 
   - 승리자 판단과 무승부 경우의수를 출력하시오.
   [입력]
      플레이어1가 0 혹은 1 혹은 2 입력받아 변수에 저장합니다.
      플레이어2가 0 혹은 1 혹은 2 입력받아 변수에 저장합니다.
   [경우의수 판단]
      플레이어1 이겼을때 경우의수 ' 플레이어1 승리 ' 출력
      플레이어2 이겼을때 경우의수 ' 플레이어2 승리 ' 출력
      비겼을경우 '무승부' 출력
*/

//문제 11

/*
let 정수1 = prompt('정수 입력1 :')
let 정수2 = prompt('정수 입력2 :')
let 정수3 = prompt('정수 입력3 :')

let max = 정수1
let min = 정수2
let mid = 정수3

min = max > min ? min : mid> max ? max : min> mid ? mid : '거짓'
console.log('min :' + min)
mid = min < mid < max

max = max < 정수2 ? 정수2 : max 
max = max < 정수3 ? 정수3 : max 
console.log('세 정수중 가장 큰수 : ' +max)
*/
let 정수1 = parseInt(prompt('첫 번째 정수:'));
let 정수2 = parseInt(prompt('두 번째 정수:'));
let 정수3 = parseInt(prompt('세 번째 정수:'));

let min, mid, max;


min = 정수1 < 정수2 ? 정수1 : 정수2;
max = 정수1 > 정수2 ? 정수1 : 정수2;


min = 정수3 < min ? 정수3 : min;
max = 정수3 > max ? 정수3 : max;
mid = (정수1 + 정수2 + 정수3) - (min + max);

console.log('오름차순: ' + min + ', ' + mid + ', ' + max)

//문제 12

let player1 = parseInt(prompt('0가위, 1바위, 2보 정수 입력 :'))
let player2 = parseInt(prompt('0가위, 1바위, 2보 정수 입력 :'))

win = player1 === player2 ? '무승부' : player1 === 0 && player2 === 2 ? 'player1'
: player1 === 1 && player2 === 0 ? 'player1' : player1 ===2 && player2 === 1 ?
'player1' : 'player2'

console.log('승리자 :' + win)	  


