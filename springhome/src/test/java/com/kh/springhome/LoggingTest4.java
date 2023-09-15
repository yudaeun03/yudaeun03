package com.kh.springhome;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class LoggingTest4 {

	@Test
	public void test() {
		for(int i=1; i <= 10000000; i++) {
			log.info("log rolling test {}", i);
		}
	}
	
}