package arraysort;

public class array06 {
	public static void main (String []args) {
		
		// 배열의 위치 조작 
		// Q) [0]번 위치와 [3]번 위치를 조작
		// 자바는 두 데이터의 맞교환이 불가능하다 (새로운변수를추가하여)
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		int backup = data[0];
		data[0] = data[3];
		data[3] = backup;
		
		for(int i=0; i<data.length; i++) {
			System.out.println(data[i]);
		}
	}

}
