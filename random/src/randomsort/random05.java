package randomsort;

import java.util.Random;
import java.util.Scanner;

public class random05 {
	public static void main (String []args) {
		
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
	
		for(int i=1; i<100; i++) {
		
		int a = r.nextInt(8)+2;
		int b = r.nextInt(9)+1;
		System.out.println(a + " X " + b + " = ");
		
		int user = sc.nextInt();
		
	
		
		if(a*b == user) {
			System.out.println("정답 !!");
		}
		else {
			System.out.println(" 오답 !!! ");
		}
		
		}
		sc.close();
	}
}
