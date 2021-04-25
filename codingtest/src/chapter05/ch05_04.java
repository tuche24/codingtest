package chapter05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 실전 문제 4 미로 탈출 참조 : https://freedeveloper.tistory.com/273
public class ch05_04 {

	public static void main(String[] args) {
		ch05_04 ch = new ch05_04();
		ch.execute();
		/*
		 * 입력값 
		 * 5 6 
		 * 101010 
		 * 111111 
		 * 000001 
		 * 111111 
		 * 111111 
		 * 출력값 
		 * 10
		 */
	}

	private void execute() {
		Scanner sc = new Scanner(System.in);
		
		int rows = sc.nextInt();
		int columns = sc.nextInt();
		sc.nextLine();
		
		int[][] matrix = new int[300][300];
		for(int i = 0; i < rows; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < columns; j++) {
				matrix[i][j] = str.charAt(j) - '0';
			}
		}
		
		int locationX = 0;
		int locationY = 0;
		
		bfs(0, 0, rows, columns, matrix);
	}
	
	private void bfs(int locationX, int locationY, int rows, int columns, int[][] matrix) {
		Queue<Node> q = new LinkedList<>();
		// 동, 서, 남, 북
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		
		q.offer(new Node(locationX, locationY));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			locationX = node.getIndex();
			locationY = node.getDistance();
			// 현재 위치에서 4가지 방향으로의 위치 확인
			for(int i = 0; i < 4; i++) {
				int nx = locationX + dx[i];
				int ny = locationY + dy[i];
				// 미로 찾기 공간을 벗어난 경우 무시
				if(nx < 0 || nx >= rows || ny < 0 || ny >= columns) {
					continue;
				}
				// 벽인 경우 무시
				if(matrix[nx][ny] == 0) {
					continue;
				}
				// 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
				if(matrix[nx][ny] == 1) {
					matrix[nx][ny] = matrix[locationX][locationY] + 1;
					q.offer(new Node(nx, ny));
				}
			}
		}
		
		System.out.println(matrix[rows - 1][columns - 1]);
	}
	
}

class Node {
	
	private int index;
	private int distance;
	
	public Node(int index, int distance) {
		super();
		this.index = index;
		this.distance = distance;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	
}
