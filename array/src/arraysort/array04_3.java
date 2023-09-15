package arraysort;

import java.util.Scanner;

public class array04_3 {
	public static void main(String[]args) {
		
		int[] score = new int[5];
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<score.length; i++) {
			System.out.println("점수를 입력하세요!");
			score[i] = sc.nextInt();
		}
		
		sc.close();
		
		int scoreList = 75;
		int rank = 1;
		
		for(int i=0; i<score.length; i++) {
			if(score[i] > scoreList) {
				rank++;
			}
			System.out.println("예상 등수 = " + rank);
		}
	}

}
