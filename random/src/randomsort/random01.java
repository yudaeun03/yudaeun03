package randomsort;

import java.util.Random;

public class random01 {
	public static void main (String []args) {
		// random 랜덤 
		
		Random r = new Random();
		
		int a = r.nextInt();
		// 무작위로 int 숫자 한개를 추첨 
		int b = r.nextInt(6)+1;
		// 무작위로 0부터 6개의 int값 중 하나를 추첨
		
		
		// * 최종형태 
		// -> int number = r.nextInt(개수) + 시작값;
		
		int dice = r.nextInt(6) + 1;
		System.out.println("주사위 값 = " + dice);
		
	}

}
