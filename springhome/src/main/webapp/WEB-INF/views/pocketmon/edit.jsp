<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form action="edit" method="post" enctype="multipart/form-data">
	<input type="hidden" name="no" value="${pocketmonDto.no}">
	
	이름 : <input type="text" name="name" value="${pocketmonDto.name}"><br><br>
	속성 : <input type="text" name="type" value="${pocketmonDto.type}"><br><br>
	
	<!-- input[type=file]은 절.대.로. value를 설정할 수 없다(보안상의 이유) -->
	<input type="file" name="attach">
	<c:if test="${pocketmonDto.image}">
		<img src="image?no=${pocketmonDto.no}" width="50" height="50">
	</c:if>
	
	<br><br>
	
	<button type="submit">수정하기</button>
	
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>


