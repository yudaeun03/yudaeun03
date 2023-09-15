<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- 아이디는 세션에 있으므로 입력하거나 전송할 필요가 없다 -->
<form action="password" method="post">
<div class="container w-400">
	<div class="row">
		<h1>비밀번호 변경</h1>
	</div>
	<div class="row left">
		<label>기존 비밀번호</label>
		<input class="form-input w-100" type="password" name="originPw" required>
	</div>
	<div class="row left">
		<label>변경 비밀번호</label>
		<input class="form-input w-100" type="password" name="changePw" required>
	</div>
	<div class="row">
		<button type="submit" class="btn btn-positive w-100">비밀번호 변경</button>
	</div>
	<c:if test="${param.error != null}">
	<div class="row important">
		<h3>기존 비밀번호가 일치하지 않습니다</h3>
	</div>
	</c:if>
</div>
</form>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>




