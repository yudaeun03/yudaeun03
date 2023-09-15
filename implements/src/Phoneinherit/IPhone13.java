package Phoneinherit;

public class IPhone13 extends IPhone {
	
	public IPhone13(String number, String color) {
		super(number, color);
	}
	
	public void itunes() {
		System.out.println("아이폰 13 아이튠즈 기능 실행");
	}
	
	public void call() {
		System.out.println("아이폰 13 전화 기능 실행");
	}
	public void sms() {
		System.out.println("아이폰 13 문자 기능 실행");
	}
	public void siri() {
		System.out.println("아이폰 13 음성 인식 기능 실행");
	}

}
