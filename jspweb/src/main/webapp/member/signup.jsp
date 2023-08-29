<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href = "../css/member.css" rel = "stylesheet">
</head>
<body>

	<%@include file = "../header.jsp" %>
	
	<div> <!-- 회원가입 전체 구역 -->
		<form class = "signupForm"> <!-- 폼 전송시 각 input에 name -->
			아이디 : <input onkeyup = "idcheck()" name = "mid" class = "mid" type = "text" />
			<span class = "idcheckbox"></span>
			 <br/>
			비밀번호 : <input onkeyup = "pwcheck()" name = "mpwd" class = "mpwd" type = "password" /> <br/>
			비밀번호 확인 : <input onkeyup = "pwcheck()" class = "mpwdconfirm" type = "password" /> <br/>
			
			<span class = "pwcheckbox"></span>
			
			
			이메일 :	<input onkeyup ="emailcheck()" name = "memail" class = "memail" type = "text" /> <button class = "authReqBtn" onclick = "authReq()" disabled type = "button">인증요청</button><br/>
			<div class = "authbox">
				<!-- 인증 요청 버튼 클릭시 보이는 구역 -->
			</div>
			
			
			<span class = "emailcheckbox"></span>
			
			프로필 : <input onchange = "preimg(this)" name = "mimg" class = "mimg" type = "file" /> <br/>
				<!-- <태그명 이벤트명="함수명(this)" /> -->
			<img class = "preimg" alt = "" src = "" width = "300px"><!-- 등록 사진을 미리보기 할 사진 태그 -->
			<button onclick = "signup()" type = "button">회원가입</button>
		</form>
	</div> 
	
	<script src = "../js/signup.js" type="text/javascript"></script>
</body>
</html>