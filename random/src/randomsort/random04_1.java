package randomsort;

import java.util.Random;

public class random04_1 {

	public static void main (String []args) {
		// 주사위 2개를 100번 던지기
		
		Random r = new Random();
		
		int count = 0;
		
		for(int i=1; i<100; i++) {
			int dice1 = r.nextInt(6)+1;
			int dice2 = r.nextInt(6)+1;
		
		
		if(dice1 == dice2) {
			count ++;
		}
}
//		System.out.println("1번주사위 = " + dice1 + "  2번주사위 =" + dice2);
				System.out.println(count + "회차 " + "더블 !! 한 번 더 !!!!");
}
}
