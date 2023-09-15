package randomsort;

import java.util.Random;

public class random03 {
	public static void main (String[]args) {
		
		// 윷놀이게임 ex
		Random r = new Random();
		
		int game = r.nextInt(6) + 1;
		System.out.println("game = " + game);
		
		
		switch (game) {
		case 1: 
			System.out.println("빽도");
			break;
		case 2:
			System.out.println("도");
			break;
		case 3: 
			System.out.println("개");
		case 4:
			System.out.println("걸");
			break;
		case 5: 
			System.out.println("윷");
			break;
		case 6: 
			System.out.println("모");
			break;
		}
		
	}

}
