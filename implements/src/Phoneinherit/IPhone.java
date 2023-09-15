package Phoneinherit;

public class IPhone extends Mobile {
	
	public IPhone(String number, String color) {
		super(number, color);
	}

	public void siri() {
		System.out.println("음성 인식 기능 실행");
	}
}
