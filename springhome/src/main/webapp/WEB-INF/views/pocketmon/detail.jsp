<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>no = ${pocketmonDto.no}</h1>
<h1>name = ${pocketmonDto.name}</h1>
<h1>type = ${pocketmonDto.type}</h1>

<c:choose>
	<c:when test="${pocketmonDto.image}">
		<img src="image?no=${pocketmonDto.no}" width="200" height="200">
	</c:when>
	<c:otherwise>
		<img src="https://dummyimage.com/200x200/000/fff" width="200" height="200">
	</c:otherwise>
</c:choose>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>

