<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<c:forEach var="pocketmonDto" items="${list}">
	<div>
		${pocketmonDto.no} / ${pocketmonDto.name} / ${pocketmonDto.type}
		<c:choose>
			<c:when test="${pocketmonDto.image}">
				<img src="image?no=${pocketmonDto.no}" width="50" height="50">
			</c:when>
			<c:otherwise>
				<img src="https://dummyimage.com/50x50/000/fff">
			</c:otherwise>
		</c:choose>
		
		
		
		
		<a href="edit?no=${pocketmonDto.no}"> 수정 </a>
		<a href="delete?no=${pocketmonDto.no}"> 삭제 </a>
	</div>
</c:forEach>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>