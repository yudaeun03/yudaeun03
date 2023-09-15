package com.kh.springhome;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class LoggingTest3 {
	
	@Test
	public void test() {
		//logger의 사용법
		//- 일반적인 메세지 출력은 System.out.println()과 같다
		System.out.println("Hello!");
		log.info("Hello!");
		
		//변수 등을 출력할 때는 홀더를 제공한다.
		int a = 10;
		System.out.println("a = " + a);
		log.info("a = " + a);
		log.info("a = {}", a);
		
		int b = 20, c = 30;
		System.out.println(b + " + " + c + " = " + (b+c));
		log.info("{} + {} = {}", b, c, b+c);
		
	}
	
}
