<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form action="insert" method="post"
			 enctype="multipart/form-data">

	이름 : <input type="text" name="name"><br><br>
	속성 : <input type="text" name="type"><br><br>

	<!-- 이미지 : <input type="file" name="attach" accept=".png, .jpg, .gif"><br><br> -->
	이미지 : <input type="file" name="attach" accept="image/*"> <br><br>

	<button type="submit">등록</button>

</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>