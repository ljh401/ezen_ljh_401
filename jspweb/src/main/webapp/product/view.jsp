<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href = "/jspweb/css/product/view.css" rel = "stylesheet">
	<!-- 부트스트랩 css 호출 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>

	<%@include file ="../header.jsp" %>

	<div class = "webcontent"> 
		<div class = "productBox">
		<!-- 캐러셀 -->
			<div id="carouselExample" class="carousel slide"> <!-- 캐러셀 : 이미지 슬라이드 -->
				<div class="imgbox carousel-inner"> 
					<!-- carousel-inner : 캐러셀 안에 넣을 이미지 목록 구역 -->
					<!-- carousel-item : 이미지 1개당 / active : 현재 보고 있는 이미지 -->
				</div>
					<!-- 왼쪽 이동 버튼 -->
					<button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
					</button>
					<!-- 오른쪽 이동 버튼 -->
					<button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
					</button>
			</div>
			<!-- 캐러셀 end -->
			
			<div class = "mid">판매자 : 강호동 </div>
			<div class = "categorydate">
				<div class = "pcname">카테고리 : 노트북</div>
				<div class = "pdate">등록일 : 2023-09-19 11:47 </div>
			</div>
			<div class = "pname"> 노트북 팝니다. </div>
			<div class = "pprice"> 555,000원 </div>
			<div class = "pcontent"> 노트북 팝니다.노트북 팝니다.<br>노트북 팝니다.노트북 팝니다.노트북 팝니다. </div>
			<div class = "etcbtnbox">
				<button onclick = "setWish()" type = "button">찜하기<span class = "wish" style="color : red"></span></button>
				<button type = "button">바로구매</button>
			</div>
			
			<!-- 탭스 start -->
			
			
			
		</div>
					
	</div>


	
	
	<!-- 부트스트랩 js 호출 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=59b47c7057625f350189b1cb8369a874&libraries=clusterer"></script>
	<script src = "/jspweb/js/product/view.js"type="text/javascript"></script>
</body>
</html>
