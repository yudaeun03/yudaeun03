package com.kh.springhome;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoggingTest1 {
	
	//로거(Logger)를 생성하여 로깅을 처리할 수 있도록 구현
	private Logger log = LoggerFactory.getLogger(LoggingTest1.class);

	@Test
	public void test() {
		//System.out.println("메세지");
		log.trace("메세지1");
		log.debug("메세지2");
		log.info("메세지3");
		log.warn("메세지4");
		log.error("메세지5");
	}
	
}