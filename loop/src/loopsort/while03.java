package loopsort;

import java.util.Random;
import java.util.Scanner;

public class while03 {
	public static void main(String []args) {
		
		Random r = new Random();
	
		
		for(int i=1; i<100; i++) {
		int user = r.nextInt(1000)+1;
	
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정답을 예측해주세요!");
		int notuser = sc.nextInt();
		
		if(user == notuser) {
			System.out.println("게임 끝 !!!!");
		}
		else if (user > notuser) {
			System.out.println("업!!!!!!");
		}
		else if (user < notuser) {
			System.out.println("다운!!!!!!!");
		}
			
	}

}
}