<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>비밀번호 찾기</h1>
<br><br>
<form action="findPw" method="post">
	아이디 <input type="text" name="memberId" required> <br><br>
	이메일 <input type="email" name="memberEmail" required> <br><br>
	<button type="submit">비밀번호 찾기</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>