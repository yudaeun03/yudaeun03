package forsort;




public class for01 {
	public static void main (String [] args) {
		
		// Q) 10부터 0까지 숫자가 줄어들며 출력하도록 구현 
		for(int i=10; i>=0; i--) {
			System.out.println("i =" + i);
		}
		
		// Q) 10분의 1씩 줄어들며 출력하는 반복문 구현
		for(int i=12345; i>0; i/=10) {
			System.out.println(i);
			// System.out.println(i%10); * for문의 i를 'i--'로 고친다
		}
		
		// Q) 두배씩 늘어나는 반복문 구현
		for(int i=1; i<=1000; i*=2) {
			System.out.println(i);
		}
	}

}
