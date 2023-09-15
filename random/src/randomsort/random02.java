package randomsort;

import java.util.Random;

public class random02 {
	public static void main(String []args) {
		
		Random r = new Random();
		
		
		// 1) 무작위 주사위 번호 1개
		int dice = r.nextInt(6) + 1;
		System.out.println(" 주사위 값 = " + dice);
	

		// 2) 무작위 로또번호 2개
		int lotto = r.nextInt(45) + 2;
		System.out.println(" 로또 개수 = " + lotto);
		
		
		// 3) 무작위 동전 앞/뒤 출력
		int coin = r.nextInt(2);
		System.out.println("동전 = " + coin);
		
		if(coin == 0) {
			System.out.println("앞!");
		}
		else {
			System.out.println("뒤!");
		}
		
		// 4) 무작위 가위바위보 출력
		int game = r.nextInt(3);
		if (game == 0) {
			System.out.println("가위!!");
		}
		else if (game == 1) {
			System.out.println("바위!!!");
		}
		else { 
			System.out.println("보!!!!");
		}
	}
	
	
}
	
