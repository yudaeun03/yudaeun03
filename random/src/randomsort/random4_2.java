package randomsort;

import java.util.Random;

public class random4_2 {
	public static void main(String[]args) {
		// 주사위 턴이 더블일 경우 한 턴 더 실행시키는 방법
		
		Random r = new Random();
		
		
		int count = 0; // 더블이 나왔을 때 횟수
		int real = 0; // 실제로 던진 횟수
		
		for(int i = 1; i<100; i++) {
			real ++;
			int dice1 = r.nextInt(6)+1;
			int dice2 = r.nextInt(6)+1;
			
			if(dice1 == dice2) {
				count ++;
				
				// 재추첨 하는 값 
				i--;
			}
		}
		System.out.println("더블 ! " + count);
		System.out.println("실제로 던진 횟수 = " + real);
		
	}

}
