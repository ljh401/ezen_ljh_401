<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- css import -->
	<link href ="accountbook.css" rel = "stylesheet" />
</head>
<body>
	<div class = "accountwrap"> <!-- 전체 구역 -->
	
			<div class = "account_Top"> <!-- 쓰기 구역 -->
				<h3>가계부</h3>
				<div class = "account_Inputs">
					<textarea class= "acontent" placeholder="내용"></textarea>
					<input class= "amoney" type = "number" placeholder = "금액">
					<input class= "adate" type = "date" placeholder = "날짜">
					<button onclick= "awrite()" type="button">저장</button>
				</div>

					
			</div>	
				<div class = "account_Bottom"> <!-- 출력 구역 -->
				
					<!-- JS가 출력해주는 구역 -->
				</div>
				
		
		
		</div>



<!-- 최신 JQUERY import ( ajax() 사용할 js파일 위에서 호출) -->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- js import -->
<script src ="accountbook.js" type="text/javascript"></script>
</body>
</html>