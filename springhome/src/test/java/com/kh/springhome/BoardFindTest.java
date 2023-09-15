package com.kh.springhome;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.springhome.dao.BoardDao;
import com.kh.springhome.dto.BoardDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BoardFindTest {

	@Autowired
	private BoardDao boardDao;
	
	@Test
	public void test() {
		int boardNo = 3;
		BoardDto boardDto = boardDao.selectOne(boardNo);
		log.debug("boardDto = {}", boardDto);
		assertNotNull(boardDto);//boardDto는 null이 아니다
	}
	
}




