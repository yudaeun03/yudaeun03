package loopsort;

import java.util.Random;

public class while02 {
	public static void main (String []args) {
		
		Random r = new Random();
		
		while(true) {
			int dice = r.nextInt(6) + 1;
			System.out.println("주사위 = " + dice);
			
			if(dice == 6) { // 주사위 값이 6이면 
				break; // 반복종료!! 
			}
		}
	}

}
