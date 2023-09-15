package arraysort;



public class array08 {
	public static void main (String []args) {
		
		// 배열 셔플 문제
		// 같은 자리가 나오면 다시 뽑는다
		// 같은 자리가 나오면 하던 작업을 무효화 시킨다
		
		Random r = new Random();
		
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		for(int i=0; i<data.length; i++) {
			int index = r.nextInt(data.length);
			
			if(i == index) {
				i--;
				continue;
			}
			
			int backup = data[i];
			data[i] = data[index];
			data[index] = backup;
		}
		for(int i=0; i<data.length; i++) {
			System.out.println(data[i]);
		}
	}

}
