<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href = "/jspweb/css/product/list.css" rel = "stylesheet">
	<!-- 부트스트랩 css 호출 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>

	<%@include file ="../header.jsp" %>

	<div class = "mapcontent"> <!-- 지도, 사이드바 포함된 구역 -->
	
		<!-- 지도 구역 -->
		<div id="map" style=""></div>
		
		<!-- 사이드바 구역 -->
		<div class = "sidebar">

		<!-- 카드 start -->
		
		
		</div>


	</div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=59b47c7057625f350189b1cb8369a874&libraries=clusterer"></script>
	<!-- 부트스트랩 js 호출 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
	<script src = "/jspweb/js/product/list.js"type="text/javascript"></script>
</body>
</html>


<!-- 
<div class="card mb-3" style="max-width: 540px;">
			<div class="row g-0">
				<div class="col-md-4">
					<img src="..." class="img-fluid rounded-start" alt="...">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<h5 class="card-title">Card title</h5>
						<p class="card-text">This is a wider card with supporting text
							below as a natural lead-in to additional content. This content is
							a little bit longer.</p>
						<p class="card-text">
							<small class="text-body-secondary">Last updated 3 mins
								ago</small>
						</p>
					</div>
				</div>
			</div>
		</div>


 -->