package arraysort;

import java.util.Scanner;

public class array04_1 {
	public static void main (String[]args) {
		
		int[] score = new int[5];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("점수를 입력해주세요");
		for(int i=0; i<score.length; i++) {
			score[i] = sc.nextInt();
		
		
		
		
		if(score[i] >= 90) {
			System.out.println(score[i] +"점! " + "90점 이상 통과입니다!");
			}
		}
	}
}

