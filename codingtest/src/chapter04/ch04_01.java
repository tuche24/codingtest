package chapter04;

import java.util.Arrays;
import java.util.Scanner;

// 예제 4-1 상하좌우
public class ch04_01 {

	public static void main(String[] args) {
		ch04_01 ch = new ch04_01();
		ch.ch04_01_ex2(); 
		/*
		 * 입력값 
		 * 5 
		 * R R R U D D
		 * 출력값
		 * ex2 = 3 4
		 */ 
	}

	// if문 풀이
	public void ch04_01_ex1() {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		/* int[][] arr = new int[N-1][N-1]; */
		int X = 1;
		int Y = 1;

		while (sc.hasNext()) {
			char a = sc.next().charAt(0);
			if (a == 'R') {
				if (X < N) {
					X = X + 1;
				}
			} else if (a == 'L') {
				if (X > 1) {
					X = X - 1;
				}
			} else if (a == 'U') {
				if (Y < N) {
					Y = Y + 1;
				}
			} else if (a == 'D') {
				if (Y > 1) {
					Y = Y - 1;
				}
			}
		}

		System.out.println();
		System.out.println(X + " " + Y);
		// if문 도배했는데 해답은 다른 방식으로 풀었음
	}

	// 해답 풀이
	public void ch04_01_ex2() {

		Scanner sc = new Scanner(System.in);

		int X = 1;
		int Y = 1;

		// L, R, U, D에 따른 이동방향. 내가 푼 것과 X축 Y축이 반대로 되어있다
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };
		String[] move_types = { "L", "R", "U", "D" };

		int nx = 0;
		int ny = 0;

		int N = sc.nextInt();
		
		sc.nextLine(); // 개행문자를 제거하기 위해 추가 https://allg.tistory.com/17
		
		String plansS = sc.nextLine();
		
		System.out.println(N);
		System.out.println(plansS);
		
		String[] plans = plansS.split(" ");
		
		System.out.println(Arrays.toString(plans));
		
		// 이동계획을 하나씩 확인
		for (String plan : plans) {
			// 이동 후 좌표 구하기
			for (int i = 0; i < move_types.length; i++) {
				if (plan.equals(move_types[i])) {
					nx = X + dx[i];
					ny = Y + dy[i];
				}
				// 공간을 벗어나는 경우 무시
				if (nx < 1 || ny < 1 || nx > N || ny > N) {
					continue;
				}
				// 이동 수행
				X = nx;
				Y = ny;
			}
		}

		System.out.println();
		System.out.println(X + " " + Y);
	}

}
