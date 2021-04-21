package chapter04;

import java.util.Scanner;

// 실전 문제 왕실의 나이트
public class ch04_03 {

	public static void main(String[] args) {
		ch04_03 ch = new ch04_03();
		ch.ch04_03_ex();
		// 입력값 a1 출력값 2
	}

	public void ch04_03_ex() {

		Scanner sc = new Scanner(System.in);

		String locationNow = sc.nextLine();
		char locationX_char = locationNow.charAt(0);
		char locationY_char = locationNow.charAt(1);

		int locationX = 0;
		int locationY = Character.getNumericValue(locationY_char);

		if (locationX_char == 'a') {
			locationX = 1;
		} else if (locationX_char == 'b') {
			locationX = 2;
		} else if (locationX_char == 'c') {
			locationX = 3;
		} else if (locationX_char == 'd') {
			locationX = 4;
		} else if (locationX_char == 'e') {
			locationX = 5;
		} else if (locationX_char == 'f') {
			locationX = 6;
		} else if (locationX_char == 'g') {
			locationX = 7;
		} else if (locationX_char == 'h') {
			locationX = 8;
		}

		int count = 0;

		System.out.println(locationX);
		System.out.println(locationY);

		// 위좌, 위우, 우위, 우하, 하우, 하좌, 좌하, 좌상
		int[] dx = { -1, 1, 2, 2, 1, -1, -2, -2 };
		int[] dy = { 2, 2, 1, -1, -2, -2, -1, 1 };

		for (int i = 0; i < dx.length; i++) {
			int nX = locationX + dx[i];
			int nY = locationY + dy[i];

			if (nX < 1 || nX > 8 || nY < 1 || nY > 8) {
				System.out.println("fail Ex) " + nX + ", " + nY);
				continue;
			}
			System.out.println("Success Ex) " + nX + ", " + nY);
			count++;
		}

		System.out.println(count);
	}

}
