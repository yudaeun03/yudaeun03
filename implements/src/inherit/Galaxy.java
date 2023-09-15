package inherit;

// Galaxy 시리즈의 상위 클래스
public class Galaxy {
	
	// 공통 필드
	// 접근 제한을 주의
	// private를 사용하면 이 클래스에서 정한 방식으로만 이용 가능
	// protected 를 사용하면 자식 클래스(패키지) 만큼은 자유롭게 접근 가능 
	private String number;
	private String color;
	private int price;
	
	
	// + 추상클래스 (abstract class) 
	// 추상클래스를 상속받으면 추상메소드를 해결(재정의) 해야한다
	// 상속관계에서 추상적인 (확실치않은) 개념을 정의하기 위해 만들어진 클래스
	// 일반클래스처럼 필드,메소드,생성자를 가질 수 있다
	// 추상클래스는 추상메소드를 가질 수 있다
	
	
	// get.set 메소드 생성 
	// 공통 메소드 재정의(override) 가능하다
	// final 키워드를 붙이면 재정의가 불가능하다
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public void call() {
		System.out.println("전화 기능");
	}
	
	public final void battery() {
		System.out.println("배터리 표시 기능");
	}
	
	
	// 생성자
	// 생성할 때 반드시 넣어야 하는 값을 지정하는 구문
	// 부모클래스는 생성할 일 없음
	// 자식클래스 객체가 생성되면 자동으로 부모클래스의 내용이 내부에 생성
	// 반드시 초기화 되야하는 필드에 대한 생성자가 자식클래스에 있어야 함
	// 부모클래스의 생성자를 만족시키는 생성자가 자식클래스에 있어야 함
	public Galaxy (String color) {
		this.setColor(color);
	}
	

}
