package arraysort;

import java.util.Scanner;

public class array04 {
	public static void main (String[]args) {
		// 사용자에게 나라이름 5개를 입력받아서 출력하도록 구현 
		
		
		String[] data = new String[5];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("나라 이름 입력해주세요!");
		
		for(int i=0; i<data.length; i++) {
			data[i]= sc.next();
		}
		sc.close();
		
		
		for(int i=0; i<data.length; i++) {
			System.out.println(data[i]);
		}
		
	}

}
