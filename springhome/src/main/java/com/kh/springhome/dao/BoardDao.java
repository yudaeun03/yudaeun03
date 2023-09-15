package com.kh.springhome.dao;

import java.util.List;

import com.kh.springhome.dto.BoardDto;
import com.kh.springhome.dto.BoardListDto;
import com.kh.springhome.dto.BoardMentionListDto;
import com.kh.springhome.vo.PaginationVO;

public interface BoardDao {
	int sequence();
	void insert(BoardDto boardDto);
	BoardDto selectOne(int boardNo);
	boolean update(BoardDto boardDto);
	boolean delete(int boardNo);
	
	boolean updateBoardReadcount(int boardNo);
	Integer selectMax(String boardWriter);
	
	List<BoardListDto> selectList();
	List<BoardListDto> selectList(String type, String keyword);
	List<BoardMentionListDto> selectMentionList();
	
	List<BoardListDto> selectListByPage(int page);
	List<BoardListDto> selectListByPage(String type, String keyword, int page);
	List<BoardListDto> selectListByPage(PaginationVO vo);
	
	int countList();
	int countList(String type, String keyword);
	int countList(PaginationVO vo);
	
	//특정 사용자가 작성한 글을 조회하는 메소드
	List<BoardListDto> selectListByBoardWriter(String boardWriter);
	
	boolean updateBoardReplycount(int boardNo);
}










