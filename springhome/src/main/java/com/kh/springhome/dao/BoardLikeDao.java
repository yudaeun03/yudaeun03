package com.kh.springhome.dao;

import java.util.List;

import com.kh.springhome.dto.BoardDto;
import com.kh.springhome.dto.BoardLikeDto;


//복합키로 구성된 테이블이므로 기본키 대신 DTO를 사용
public interface BoardLikeDao {
	void insert(BoardLikeDto boardLikeDto); // 등록 
	boolean delete(BoardLikeDto boardLikeDto); // 확인 
	boolean check(BoardLikeDto boardLikeDto); // 체크 
	int count(int boardNo); // 게시글 번호만 넣어서 숫자로 알려주는 
	List<BoardDto> findByMemberId(String memberId);
}
