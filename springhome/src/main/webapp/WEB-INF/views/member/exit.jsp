<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form action="exit" method="post">
<div class="container w-400">
	<div class="row">
		<h1>회원 탈퇴</h1>
	</div>
	<div class="row">
		정말 탈퇴하시겠습니까? 
		탈퇴 후 정보는 사라집니다
	</div>
	
	<c:if test="${param.error != null}">
	<div class="row important">
		<h3>비밀번호가 일치하지 않습니다</h3>
	</div>
	</c:if>
	
	<div class="row">
		<input class="form-input w-100" type="password" name="memberPw" required placeholder="비밀번호 입력">
	</div>
	
	<div class="row">
		<button class="btn btn-negative w-100">네, 탈퇴하겠습니다</button>	
	</div>
</div>

</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>




