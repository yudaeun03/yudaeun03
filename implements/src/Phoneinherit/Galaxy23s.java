package Phoneinherit;


public class Galaxy23s extends Galaxy{
	
	public Galaxy23s(String number, String color) {
		super(number, color);
	}

	public void bixby() {
		System.out.println("갤럭시 23s의 빅스비 기능 실행");
	}
	
	public void call() {
		System.out.println("갤럭시 23s의 전화 기능 실행");
	}
	public void sms() {
		System.out.println("갤럭시 23s의 문자 기능 실행");
	}
	public void samsungPay() {
		System.out.println("갤럭시 23s의 삼성페이 기능 실행");
	}
	
}
