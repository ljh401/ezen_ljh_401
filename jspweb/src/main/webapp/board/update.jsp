<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- ��ӳ�Ʈ ���� ��Ʈ��Ʈ�� css ,  ��ӳ�Ʈ css -->
	<!-- ��Ʈ��Ʈ������ ���� CSS ���� -->
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
   <!-- ��ӳ�Ʈ css ���� - ��Ʈ��Ʈ��v5 -->
   <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-lite.min.css" rel="stylesheet">
</head>
<body>
<%@include file="../header.jsp" %>
      <div class="webcontainer">
      <h3> �� ���� ������ </h3>
      <form class="writeForm"> <!-- ���� �Է� ���� -->
         ī�װ� : <select name="bcno" class="bcno"> 
                  <!-- �Խù��� ����Ǵ� ī�װ������� ī�װ��̸�X ī�װ���ȣ [FK] -->
                  <option value="1"> �������� </option> 
                  <option value="2"> �����Խ��� </option> 
                  <option value="3"> ���Ͽ� </option> 
               </select>   <br/>
         ���� : <input type="text" name="btitle" class="btitle" > <br/>
         ���� : <textarea id ="summernote" name="bcontent" class="bcontent"></textarea> <br/>
         <div class = "oldfile"></div>
         ÷������ : <input type="file" name="bfile" class="bfile"> <br/>
         <button onclick="onUpdate()"type="button">�ۼ���</button> 
         <a href="list.jsp"> ��Ϻ��� </a>
 
      </form>
   </div>
	
	<!-- ��Ʈ��Ʈ������ ���� JS ���� -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<!-- ��ӳ�Ʈ js ���� -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-lite.min.js"></script>
<!-- ��ӳ�Ʈ �ѱ�����  -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/lang/summernote-ko-KR.min.js"></script>
	
	<script src ="../js/board/update.js" type="text/javascript"></script>
</body>
</html>