package com.kh.springhome.interceptor;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.springhome.dao.BoardDao;
import com.kh.springhome.dto.BoardDto;
import com.kh.springhome.error.NoTargetException;

@Component
public class BoardDefenderInterceptor implements HandlerInterceptor{

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//목표 : 세션과 작성자, 글번호를 이용하여 조회수 중복 방지 처리

		//글 정보 불러오기
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(boardDto == null) {
			throw new NoTargetException("존재하지 않는 게시글");
		}
		
		//로그인 사용자 정보 불러오기(없을 수 있음)
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("name");
		
		//세션에 history란 이름의 저장소를 이용하여 중복 조회 검사
		//1. 세션에 history라는 이름의 저장소가 있는지 확인
		//2. 없으면 생성, 있으면 추출
		//3. 지금 읽는 글 번호가 history에 존재하는지 확인
		//4. 없으면 추가하고 다시 세션에 저장
		Set<Integer> history;
		if(session.getAttribute("history") != null) 
			history = (Set<Integer>) session.getAttribute("history");
		else 
			history = new HashSet<>();
		
		boolean isRead = history.contains(boardNo);
		if(isRead == false) {
			history.add(boardNo);
			session.setAttribute("history", history);
		}
		
		boolean isOwner = boardDto.getBoardWriter() != null
									&& memberId != null
									&& boardDto.getBoardWriter().equals(memberId);
		
//		if(내글도 아니고 읽은적도 없으면) {
		if(!isOwner && !isRead) {
			boardDao.updateBoardReadcount(boardNo);
		}
		
		return true;
	}
	
}