package arraysort;

import java.util.Scanner;

public class array03 {
	public static void main (String []args) {
		// 배열과 반복문 
		// -> 3개의 숫자를 입력받아서 출력, 합계 구하기 
		int[] data = new int[3];
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 3개 입력해주세요");
		
		for(int i=0; i<3; i++) {
			data[i] = sc.nextInt();
		}
		sc.close();
		
		for(int i=0; i<3; i++) {
			System.out.println(data[i]);
		}
	}

}
