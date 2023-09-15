package com.kh.springhome;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class LoggingTest2 {
	
	//[1] 로거는 파일마다 만들어야 사용할 수 있다.
	//(해결책) Lombok의 기능을 사용한다 (@Slf4j)
	//private Logger log = LoggerFactory.getLogger(LoggingTest2.class);

	@Test
	public void test() {
		//[2] 로그에는 수준(level)이 존재한다
		//- 총 6가지가 존재
		//- fatal - 시스템이 다운되는 오류. 개발자가 작성 불가.
		//- error - 기능이 다운되는 오류.
		//- warn - 기능에 문제는 없지만 성능저하나 메모리 낭비 등 위험이 예상되는 상황.
		//- info - 시스템에서 발행하는 정보. 사용자에게 보여지는 정보.
		//- debug - 개발자에게 필요한 정보. 오류 해결을 위한 정보.
		//- trace - 시스템의 모든 작업에 대한 상세정보. 직접 작성을 피해야함.
		log.trace("메세지1");
		log.debug("메세지2");
		log.info("메세지3");
		log.warn("메세지4");
		log.error("메세지5");
	}
	
}




