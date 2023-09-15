package com.kh.springhome.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
	인터셉터(Interceptor)
	- 완성된 스프링 프로젝트의 구석구석을 간섭할 수 있도록 만들어진 도구
	
	만드는 법
	1. 상속을 받아서 자격을 획득 (HandlerInterceptor)
	2. 등록
	3. 메소드 재정의
	4. 설정파일을 만들어서 어느 주소를 간섭할 것인지 설정
 */
@Component
public class TestInterceptor implements HandlerInterceptor{
	
	/**
	 * preHandle은 컨트롤러가 실행되기 직전 시점을 간섭하는 메소드
	 * - true를 반환하면 요청에 대한 작업을 진행하겠다는 의미
	 * - false를 반환하면 요청에 대한 작업을 차단하겠다는 의미
	 * - 자격 여부에 따른 접근 가능/차단 여부를 처리할 때 적합
	 * - request에는 사용자의 요청정보가 들어있다(ex : 파라미터, 세션 정보, ..)
	 * - response에는 사용자에게 나갈 정보가 들어있다(ex : 화면정보, ..)
	 * - handler에는 이 요청을 처리할 대상 컨트롤러/메소드의 정보가 들어있다
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle 실행");
		return true;
	}
	/**
	 * postHandle은 컨트롤러 처리 후 화면 생성 전 시점을 간섭하는 메소드
	 * - 유일하게 Model의 정보와 들어있는 데이터를 확인할 수 있다.
	 * - 검사, 모니터링, 치환 등의 작업을 할 수 있다
	 */
	@Override
	public void postHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle 실행");
		System.out.println(modelAndView);
	}
	/**
	 * afterCompletion은 화면 생성 후(모든 처리가 끝난 후) 시점을 간섭하는 메소드
	 * - 유일하게 예외의 발생 여부를 알 수 있는 곳
	 * - 발생한 예외에 따라 처리할 내용들을 이곳에 작성할 수 있다.
	 * - 사용자가 볼 페이지를 변경할 수는 없다(모니터링, 로깅-기록을 남기는 행위, ..)
	 */
	@Override
	public void afterCompletion(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler, 
			Exception ex)
			throws Exception {
		System.out.println("afterCompletion 실행");
		System.out.println(ex);
	}
}



