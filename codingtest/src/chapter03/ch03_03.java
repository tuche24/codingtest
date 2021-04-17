package chapter03;

import java.util.Arrays;
import java.util.Scanner;
// 문제 3번 숫자 카드 게임
public class ch03_03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int row = sc.nextInt();
		int column = sc.nextInt();
		
		int[][] arr; 
		arr = new int[row][column];
		int[] minarr = new int[row];
		
		for(int i = 0 ; i < row; i++) {
			for(int j = 0 ; j < column; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		/*
		 * for(int i = 0 ; i < arr.length; i++) {
		 * System.out.println(Arrays.toString(arr[i])); }
		 */
		
		for (int i = 0 ; i < arr.length; i++) {
			Arrays.sort(arr[i]);
			
			minarr[i] = arr[i][0];
		}
		
		System.out.println(minarr[row-1]);
		
	}
}
