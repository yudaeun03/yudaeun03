package loopsort;

import java.util.Random;
import java.util.Scanner;

public class while03_1 {
	public static void main (String[]args) {
	
	Random r = new Random();
	Scanner sc = new Scanner(System.in);

	//정답을 생성하고
	int answer = r.nextInt(1000) + 1;
	//System.out.println("answer = " + answer);

	System.out.println("1부터 1000 사이의 숫자 중 하나를 컴퓨터가 골랐습니다!");

	int round = 0;

	while(true) {
		//입력하여 맞춘다
		System.out.print("입력 : ");
		int input = sc.nextInt();

		round++;

		if(input == answer) {//입력값 == 정답
			System.out.println("정답!");
			break;
		}
		else if(input > answer) {//입력값 > 정답
			System.out.println("다운");
		}
		else {//입력값 < 정답
			System.out.println("업");
		}
	}

	sc.close();

	System.out.println("총 입력한 횟수는 "+round+"번 입니다");
}
}
