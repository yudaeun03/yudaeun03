<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>
	자유 게시판(멘션 형식)	
	<a href="list">(원래 형태로 이동)</a>
</h2>

<%-- 글쓰기는 로그인 상태인 경우에만 출력 --%>
<c:if test="${sessionScope.name != null}">
<h3><a href="write">글쓰기</a></h3>
</c:if>

<table border="1" width="600">
	<c:forEach var="boardMentionListDto" items="${list}">
	<tr height="60">
		<td align="left">
			
			<c:if test="${boardMentionListDto.boardDepth > 0}">
				<a href="detail?boardNo=${boardMentionListDto.superBoardNo}">
					<font color="gray">${boardMentionListDto.superBoardTitle}</font>
				</a>
				<br>
				<img src="/images/reply.png" width="15" height="15">
			</c:if>
			
		
			<!-- 제목을 누르면 상세페이지로 이동 -->
			<a href="detail?boardNo=${boardMentionListDto.boardNo}">
				${boardMentionListDto.boardTitle}
			</a>
			
			<!-- 댓글이 있다면 개수를 표시 -->
			<c:if test="${boardMentionListDto.boardReplycount > 0}">
			[${boardMentionListDto.boardReplycount}]
			</c:if>
		
		<c:choose>
			<c:when test="${boardMentionListDto.boardWriter != null}">
				(${boardMentionListDto.boardWriter})
			</c:when>
			<c:otherwise>
				(탈퇴한 사용자)
			</c:otherwise>
		</c:choose>
	</tr>
	</c:forEach>
</table>

<br>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>


