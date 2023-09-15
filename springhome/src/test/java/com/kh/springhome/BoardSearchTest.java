package com.kh.springhome;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.springhome.dao.BoardDao;
import com.kh.springhome.dto.BoardListDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BoardSearchTest {

	@Autowired
	private BoardDao boardDao;
	
	@Test
	public void test() {
		String type = "board_writer";
		String keyword = "test";
		
		List<BoardListDto> list = boardDao.selectList(type, keyword);
		log.debug("결과 수 : {}", list.size());
	}
	
}



