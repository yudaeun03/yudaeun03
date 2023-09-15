<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form action="edit" method="post">
<input type="hidden" name="boardNo" value="${boardDto.boardNo}">

<div class="container w-600">
	<div class="row">
		<h1>게시글 수정</h1>
	</div>
	
	<div class="row left">
		<label>제목</label>
		<input class="form-input w-100" type="text" name="boardTitle" value="${boardDto.boardTitle}" required>
	</div>
	
	<div class="row left">
		<label>내용</label>
		<textarea class="form-input w-100" name="boardContent" 
			style="min-height:250px" required>${boardDto.boardContent}</textarea>
	</div>
	
	<div class="row right">
		<a href="list" class="btn">
			<i class="fa-solid fa-list"></i>
			목록
		</a>
		<button type="submit" class="btn btn-positive">
			<i class="fa-solid fa-edit"></i>
			수정
		</button>
	</div>
</div>

</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>