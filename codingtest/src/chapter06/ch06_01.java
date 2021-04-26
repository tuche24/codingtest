package chapter06;
// 선택 정렬 참조 : https://freedeveloper.tistory.com/274?category=888096
public class ch06_01 {

	public static void main(String[] args) {
		
		int n = 10;
		int[] arr = {7, 5, 9 , 0, 3, 1, 6, 2, 4, 8};
		
		for(int i = 0; i < n; i++) {
			int min_index = i;
			for(int j = i + 1; j < n; j++) {
				if (arr[min_index] > arr[j]) {
					min_index = j;
				}
			}
			// 스와프
			int temp = arr[i];
			arr[i] = arr[min_index];
			arr[min_index] = temp;
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
}
