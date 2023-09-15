<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<jsp:include page="/WEB-INF/views/template/adminHeader.jsp"></jsp:include>

<form action="edit" method="post">
	<input type="hidden" name="memberId" value="${memberDto.memberId}">

	<div class="container w-600">
		<div class="row">
			<h1>회원 정보 변경</h1>
		</div>
		<div class="row left">
			<label>닉네임</label>
			<input type="text" name="memberNickname" class="form-input w-100"
				value="${memberDto.memberNickname}" required>
		</div>
		<div class="row left">
			<label>연락처</label>
			<input type="tel" name="memberContact" class="form-input w-100"
				value="${memberDto.memberContact}">
		</div>
		<div class="row left">
			<label>이메일</label>
			<input type="email" name="memberEmail" class="form-input w-100"
				value="${memberDto.memberEmail}">
		</div>
		<div class="row left">
			<label>생년월일</label>
			<input type="date" name="memberBirth" class="form-input w-100"
				value="${memberDto.memberBirth}">
		</div>
		<div class="row left">
			<label style="display:block">주소</label>
			<input type="text" name="memberPost" class="form-input"
				value="${memberDto.memberPost}" placeholder="우편번호">
			<button type="button" class="btn">우편번호 찾기</button>
			
			<input type="text" name="memberAddr1" class="form-input w-100 mt-10"
				value="${memberDto.memberAddr1}" placeholder="기본주소">
			<input type="text" name="memberAddr2" class="form-input w-100 mt-10"
				value="${memberDto.memberAddr2}" placeholder="상세주소">
		</div>
		
		<div class="row left">
			<label>등급</label>
			
			<c:choose>
				<c:when test="${memberDto.memberLevel == 'VIP'}">
					<input type="radio" name="memberLevel" value="일반"> 일반
					<input type="radio" name="memberLevel" value="VIP" checked> VIP
					<input type="radio" name="memberLevel" value="관리자"> 관리자
				</c:when>
				<c:when test="${memberDto.memberLevel == '관리자'}">
					<input type="radio" name="memberLevel" value="일반"> 일반
					<input type="radio" name="memberLevel" value="VIP"> VIP
					<input type="radio" name="memberLevel" value="관리자" checked> 관리자
				</c:when>
				<c:otherwise>
					<input type="radio" name="memberLevel" value="일반" checked> 일반
					<input type="radio" name="memberLevel" value="VIP"> VIP
					<input type="radio" name="memberLevel" value="관리자"> 관리자
				</c:otherwise>
			</c:choose>
		</div>
		
		<div class="row left">
			<label>포인트</label>
			<input type="number" name="memberPoint" class="form-input w-100"
					value="${memberDto.memberPoint}">
		</div>
		
		<div class="row mt-30">
			<button type="submit" class="btn btn-positive w-100">정보변경</button>
		</div>
	</div>

</form>

<jsp:include page="/WEB-INF/views/template/adminFooter.jsp"></jsp:include>