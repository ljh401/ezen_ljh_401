<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href = "/jspweb/css/product/list.css" rel = "stylesheet">
</head>
<body>

	<%@include file ="../header.jsp" %>

	<div class = "mapcontent"> <!-- 지도, 사이드바 포함된 구역 -->
	
		<!-- 지도 구역 -->
		<div id="map" style=""></div>
		
		<!-- 사이드바 구역 -->
		<div class = "sidebar"></div>
	
	</div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=59b47c7057625f350189b1cb8369a874&libraries=clusterer"></script>
	
	<script src = "/jspweb/js/product/list.js"type="text/javascript"></script>
</body>
</html>