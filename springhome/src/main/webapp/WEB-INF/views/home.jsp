<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 
	매번 페이지 코드를 복사할 수 없으니 미리 만든 것을 불러오도록 설정
	- 템플릿 페이지(template page)라고 부름 
	- 절대경로를 사용할 것
--%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container w-600">
	<div class="row">
		<h1>환영합니다!</h1>
	</div>
	<div class="row">
		<img src="https://dummyimage.com/600x400/000/fff">
	</div>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>





