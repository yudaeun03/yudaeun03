package com.kh.springhome.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.springhome.dao.BoardDao;
import com.kh.springhome.dto.BoardDto;
import com.kh.springhome.error.AuthorityException;

//게시글 소유자인 경우만 통과시키는 인터셉터
//필요한 정보 : 게시글번호(파라미터), 사용자ID(세션)
@Component
public class BoardOwnerInterceptor implements HandlerInterceptor{
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		//현재 사용자의 아이디를 읽는 코드
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("name");
		
		//글번호를 읽는 코드
		//- request.getParameter("이름") 으로 파라미터를 읽는다
		//- 통신이기 때문에 반환형이 String이다
		//- 변환 명령을 이용하여 원하는 형태로 바꿔 사용할 수 있다
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		BoardDto boardDto = boardDao.selectOne(boardNo);
		
		if(boardDto.getBoardWriter().equals(memberId)) {//소유자라면
			return true;
		}
		else {
			//return false;
			throw new AuthorityException("글 소유자가 아닙니다");
		}
	}
	
}