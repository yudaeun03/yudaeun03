<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<jsp:include page="/WEB-INF/views/template/adminHeader.jsp"></jsp:include>

<div class="container w-700">
	<div class="row mv-40">
		<h1>회원 관리</h1>
	</div>
	<div class="row">
		<form action="list" method="get">
			<c:choose>
				<c:when test="${vo.type == 'member_nickname'}">
					<select name="type" class="form-input">
						<option value="member_id">아이디</option>
						<option value="member_nickname" selected>닉네임</option>
						<option value="member_contact">전화번호</option>
						<option value="member_birth">생년월일</option>
					</select>
				</c:when>
				<c:when test="${vo.type == 'member_contact'}">
					<select name="type" class="form-input">
						<option value="member_id">아이디</option>
						<option value="member_nickname">닉네임</option>
						<option value="member_contact" selected>전화번호</option>
						<option value="member_birth">생년월일</option>
					</select>
				</c:when>
				<c:when test="${vo.type == 'member_birth'}">
					<select name="type" class="form-input">
						<option value="member_id">아이디</option>
						<option value="member_nickname">닉네임</option>
						<option value="member_contact">전화번호</option>
						<option value="member_birth" selected>생년월일</option>
					</select>
				</c:when>
				<c:otherwise>
					<select name="type" class="form-input">
						<option value="member_id">아이디</option>
						<option value="member_nickname">닉네임</option>
						<option value="member_contact">전화번호</option>
						<option value="member_birth">생년월일</option>
					</select>
				</c:otherwise>
			</c:choose>
		
			
			<input type="search" name="keyword" placeholder="검색어" 
				value="${vo.keyword}" required class="form-input">
			<button type="submit" class="btn btn-positive">검색</button>
		</form>
	</div>
	<div class="row">
		<table class="table table-hover table-border">
			<thead>
				<tr>
					<th>아이디</th>
					<th>닉네임</th>
					<th>전화번호</th>
<!-- 					<th>이메일</th> -->
					<th>생년월일</th>
					<th>등급</th>
					<th>차단</th>
					<th>메뉴</th>
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach var="memberListDto" items="${list}">
				<tr>
					<td>${memberListDto.memberId}</td>
					<td>${memberListDto.memberNickname}</td>
					<td>${memberListDto.memberContact}</td>
<%-- 					<td>${memberListDto.memberEmail}</td> --%>
					<td>${memberListDto.memberBirth}</td>
					<td>${memberListDto.memberLevel}</td>
					<td>${memberListDto.block}</td>
					<td>
						<a class="link" href="detail?memberId=${memberListDto.memberId}">상세</a>
						<a class="link" href="edit?memberId=${memberListDto.memberId}">수정</a>
						
						<c:choose>
							<c:when test="${memberListDto.block == 'Y'}">
								<a class="link" href="cancel?memberId=${memberListDto.memberId}">해제</a>
							</c:when>
							<c:otherwise>
								<a class="link" href="block?memberId=${memberListDto.memberId}">차단</a>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="row">
		<div class="page-navigator">
			<c:if test="${!vo.first}">
				<a href="list?${vo.prevQueryString}">&lt;</a>
			</c:if> 
			
			<c:forEach var="i" begin="${vo.begin}" end="${vo.end}" step="1">
				<c:choose>
					<c:when test="${i == vo.page}">
						<a class="on">${i}</a>
					</c:when>
					<c:otherwise>
						<a href="list?${vo.getQueryString(i)}">${i}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<c:if test="${!vo.last}">
				<a href="list?${vo.nextQueryString}">&gt;</a>
			</c:if>
			
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/views/template/adminFooter.jsp"></jsp:include>





