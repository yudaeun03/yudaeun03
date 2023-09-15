package com.kh.springhome;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.springhome.dao.BoardDao;
import com.kh.springhome.dto.BoardDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BoardInsertTest {

	@Autowired
	private BoardDao boardDao;
	
	@Test
	public void test() {
		//목표 : 등록이 되는지 테스트
		int boardNo = boardDao.sequence();
		log.debug("boardNo = {}", boardNo);
		
		BoardDto boardDto = new BoardDto();
		boardDto.setBoardNo(boardNo);
		boardDto.setBoardTitle("테스트제목");
		boardDto.setBoardContent("테스트내용");
		boardDto.setBoardWriter("testuser1");
		boardDao.insert(boardDto);
	}
	
}