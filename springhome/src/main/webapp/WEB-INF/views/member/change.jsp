<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form action="change" method="post" autocomplete="off">
	<div class="container w-500">
        <div class="row">
            <h1>개인정보 변경</h1>
        </div>
        <div class="row left">
            <label>
            	닉네임 
				<i class="fa-solid fa-asterisk red"></i>
			</label>
            <input type="text" name="memberNickname" class="form-input w-100"
					value="${memberDto.memberNickname}" required>
        </div>
        <div class="row left">
            <label>이메일</label>
            <input type="email" name="memberEmail" class="form-input w-100"
					value="${memberDto.memberEmail}" placeholder="testuser@kh.com">
        </div>
        <div class="row left">
            <label>연락처</label>
            <input type="tel" name="memberContact" class="form-input w-100"
					value="${memberDto.memberContact}" placeholder="- 제외하고 입력">
        </div>
        <div class="row left">
            <label>생년월일</label>
            <input type="date" name="memberBirth" class="form-input w-100"
							value="${memberDto.memberBirth}">
        </div>
        <div class="row left">
            <label class="mb-10" style="display: block;">주소</label>
            <input type="text" class="form-input" name="memberPost" placeholder="우편번호" style="width:8em;" value="${memberDto.memberPost}">
            <button type="button" class="btn">우편번호 찾기</button>
            <input type="text" class="form-input w-100 mt-10" name="memberAddr1" placeholder="기본주소" value="${memberDto.memberAddr1}">
            <input type="text" class="form-input w-100 mt-10" name="memberAddr2" placeholder="상세주소" value="${memberDto.memberAddr2}">
        </div>
        <div class="row left">
        	<label>
        		비밀번호 확인
				<i class="fa-solid fa-asterisk red"></i>
			</label>
        	<input type="password" name="memberPw" required class="form-input w-100">
        </div>
        <div class="row">
            <button type="submit" class="btn btn-positive w-100">정보변경</button>
        </div>
        <c:if test="${param.error != null}">
        <div class="row red">
			<h3>입력하신 비밀번호가 일치하지 않습니다</h3>
		</div>
		</c:if>
    </div>
    
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>