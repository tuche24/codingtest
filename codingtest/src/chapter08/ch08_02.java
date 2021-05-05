package chapter08;

// 피보나치 수열 참조 : https://freedeveloper.tistory.com/276?category=888096
public class ch08_02 {

	// 한 번 계산된 결과를 메모이제이션(Memoization)하기 위한 배열 초기화
	public static long[] d = new long[100];
	
	public static void main(String[] args) {
		ch08_02 ch = new ch08_02();
		System.out.println(ch.execute(50));
	}
	
	private long execute(int x) {
		// 피보나치 함수(Fibonacci Function)를 재귀함수로 구현 (탑 다운 다이나믹 프로그래밍)
		// 종료 조건 (1 혹은 2일 때 1을 반환)
		if(x == 1 || x == 2) {
			return 1;
		}
		
		// 이미 계산한 적 있는 문제라면 그대로 반환
		if(d[x] != 0) {
			return d[x];
		}
		
		// 아직 계산하지 않은 문제라면 점화식에 따라서 피보나치 결과 반환
		d[x] = execute(x-1) + execute(x-2);
		return d[x];
	}	
}
