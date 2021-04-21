package chapter04;

import java.util.Scanner;

// 실전 문제 게임 개발
public class ch04_04 {

	public static void main(String[] args) {
		ch04_04 ch = new ch04_04();
		ch.ch04_04_ex1();
		// 입력값
		// 4 4
		// 1 1 0
		// 1 1 1 1
		// 1 0 0 1
		// 1 1 0 1
		// 1 1 1 1
		// 출력값
		// 3
	}

	// 푸는 중 오류..
	public void ch04_04_ex1() {
		
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		String mapSize = sc.nextLine();
		String location = sc.nextLine();
		
		String[] mapSizeArray = mapSize.split(" ");
		int mapX = Integer.parseInt(mapSizeArray[0]);
		int mapY = Integer.parseInt(mapSizeArray[1]);
		
		String[] locationArray = location.split(" ");
		int locationX = Integer.parseInt(locationArray[0]);
		int locationY = Integer.parseInt(locationArray[1]);
		int direction = Integer.parseInt(locationArray[2]);
		
		int[][] mapMatrix = new int[mapX][mapY];
		
		while(sc.hasNext()) {
			String row1 = sc.nextLine();
			String[] rowIndex = row1.split(" ");
			int column = 0;
			
			for(int i = 0; i < mapY; i++) {
				mapMatrix[i][column] = Integer.parseInt(rowIndex[i]);
			}
			column++;
		}
		
		int[][] visited = new int[mapX][mapY];
		
		// 북 동 남 서
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		int count = 0;
		int turn_time = 0;
		
		visited[locationX][locationY] = 1;
		
		while(true) {
			direction = turnLeft(direction);
			
			int nx = locationX + dx[direction];
			int ny = locationY + dy[direction];
			
			if(nx <= 0 || ny <= 0 || nx > mapX || ny > mapY) {
				continue;
			}
			
			System.out.println("nx, ny location = " + nx + " " + ny + " count = " + count);
			
			// 회전한 후 정면이 육지이고, 방문하지 않은 경우
			if(mapMatrix[nx][ny] == 0 && visited[nx][ny] == 0) {
				visited[nx][ny] = 1;
				locationX = nx;
				locationY = ny;
				count++;
				turn_time = 0;
				continue;
			} else {
				turn_time++;
			}
			
			if(turn_time == 4) {
				nx = locationX - dx[direction];
				ny = locationY - dy[direction];
				
				if(mapMatrix[nx][ny] == 0) {
					locationX = nx;
					locationY = ny;
				} else {
					break;
				}
				
			}
			
		}
		
		System.out.println(count);
		
	}

	public int turnLeft(int direction) {
		int result = 0;
		result = direction - 1;
		if (result == -1) {
			result = 3;
		}
		return result;
	}

}
