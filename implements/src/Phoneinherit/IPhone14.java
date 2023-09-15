package Phoneinherit;

public class IPhone14 extends IPhone {

	public IPhone14(String number, String color) {
		super(number, color);
	}
	
	public void facetime() {
		System.out.println("아이폰 14 영상통화 기능 실행");
	}
	
	public void call() {
		System.out.println("아이폰 14 전화 기능 실행");
	}
	public void sms() {
		System.out.println("아이폰 14 문자 기능 실행");
	}
	public void siri() {
		System.out.println("아이폰 14 음성 인식 기능 실행");
	}
	
}
