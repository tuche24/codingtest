package chapter06;
// 퀵 정렬 참조 주소 : https://freedeveloper.tistory.com/274?category=888096
public class ch06_03 {

	public static void main(String[] args) {
		ch06_03 ch = new ch06_03();
		int n = 10;
		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		
		ch.quickSort(arr, 0, n-1);
		
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i] + " ");
		}
	}
	
	private void quickSort(int[] arr, int start, int end) {
		if (start >= end) return; // 원소가 1개인 경우 종료
		int pivot = start; // 피벗은 첫 번째 원소
		int left = start + 1;
		int right = end;
		while(left <= right) {
			// 피벗보다 큰 데이터를 찾을 때까지 반복
			while(left <= end && arr[left] <= arr[pivot]) left++;
			// 피벗보다 작은 데이터를 찾을 때까지 반복
			while(right > start && arr[right] >= arr[pivot]) right--;
			// 엇갈렸다면 작은 데이터와 피벗을 교체
			if (left > right) {
				int temp = arr[pivot];
				arr[pivot] = arr[right];
				arr[right] = temp;
			}
			// 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
			else {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		// 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
		quickSort(arr, start, right - 1);
		quickSort(arr, right + 1, end);
		
		
	}
}
