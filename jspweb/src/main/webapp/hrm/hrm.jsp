<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href = "./hrm.css" rel = "stylesheet">
</head>
<body>
	
	<%@include file = "../header.jsp" %>
	<div class = "webcontainer">
		<form class = "hrmForm">
			<div class = "intitle">프로필</div>
			<input onchange = "preimg(this)"class = "hfile" name = "himg" type = "file"/>
			<img class = "preimg" alt = "" src = "img/default.webp">
			
			<div class = "intitle">직원명</div>
			<input maxlength = "20"  name = "hname" class = "hname" type = "text" />
		
			<div class = "intitle">직원 전화번호</div>
			<input maxlength = "20"  name = "hphone" class = "hphone" type = "text" />
			
			<div class = "intitle">직급 선택</div>
			<select class = "hposition" name = "hposition">
				<option value="사장">사장</option>
				<option value="부장">부장</option>
				<option value="팀장">팀장</option>
				<option value="대리">대리</option>
				<option value="주임">주임</option>
				<option value="사원">사원</option>
			</select>
			
			<button class = "hsavebtn" onclick= "hsave()" type = "button">저장</button>
		</form>
		
				<div class = "hrm_Bottom"> <!-- 출력 구역 -->
				
					<!-- JS가 출력해주는 구역 -->
				</div>
		
	</div>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<script src = "../hrm/hrm.js" type="text/javascript"></script>
</body>
</html>