package arraysort;

import java.util.Scanner;

public class array04_2 {
	public static void main(String[]args) {
		
		int[] score = new int[5];
		// 학생 5명의 점수 
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<score.length; i++) {
			System.out.println("점수를 입력해주세요!");
			score[i] = sc.nextInt();
		}
		sc.close();
		
		System.out.println("성적 우수자 = ");
		for(int i=0; i<score.length; i++) {
			if(score[i] >= 90) {
				System.out.println("성적우수자 점수 =" + score[i]);
			}
		}
	}

}
