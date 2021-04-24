package chapter05;

import java.util.Scanner;
// 실전 문제3 음료수 얼려먹기 참조 주소 : https://freedeveloper.tistory.com/273
public class ch05_03 {

	public static void main(String[] args) {
		ch05_03 ch = new ch05_03();
		ch.execute();
		/*
		 * 입력값 15 14 00000111100000 11111101111110 11011101101110 11011101100000
		 * 11011111111111 11011111111100 11000000011111 01111111111111 00000000011111
		 * 01111111111000 00011111111000 00000001111000 11111111110011 11100011111111
		 * 11100011111111
		 */
		/*
		 * 출력값 8
		 */
	}
	
	private void execute() {
		Scanner sc = new Scanner(System.in);
		
		int rows = sc.nextInt();
		int columns = sc.nextInt();
		sc.nextLine();
		
		int[][] matrix = new int[1000][1000];
		
		for(int i = 0; i < rows; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < columns; j++) {
				matrix[i][j] = str.charAt(j) - '0';
			}
		}
		
		// 모든 노드(위치)에 대하여 음료수 채우기
		int result = 0;
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				if(dfs(i, j, rows, columns, matrix)) {
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
	
	private boolean dfs(int x, int y, int rows, int columns, int[][] graph) {
		// 주어진 범위를 벗어나는 경우에는 즉시 종료
		if(x <= -1 || x >= rows || y <= -1 || y >= columns) {
			return false;
		}
		// 현재 노드를 아직 방문하지 않았다면
		if(graph[x][y] == 0) {
			graph[x][y] = 1;
			// 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
			dfs(x - 1, y, rows, columns, graph);
			dfs(x, y - 1, rows, columns, graph);
			dfs(x + 1, y, rows, columns, graph);
			dfs(x, y + 1, rows, columns, graph);
			return true;
		}
		return false;
	}
	
}
