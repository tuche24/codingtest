package chapter04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

// 실전 문제 게임 개발
public class ch04_04 {

	public static void main(String[] args) {
		ch04_04 ch = new ch04_04();
		try {
			ch.ch04_04_ex2();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		int locationX = Integer.parseInt(locationArray[0]) - 1;
		int locationY = Integer.parseInt(locationArray[1]) - 1;
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
			
			System.out.println("nx, ny location = " + nx + " " + ny + " count = " + count);
			
			if(nx < 0 || ny < 0 || nx > mapX - 1 || ny > mapY - 1) {
				continue;
			}
			
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
				
				if(mapMatrix[nx][ny] == 0 && visited[nx][ny] == 0) {
					visited[nx][ny] = 1;
					locationX = nx;
					locationY = ny;
					turn_time = 0;
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

	// 문제가 안 풀려서 참조 https://velog.io/@uhan2/%EC%9D%B4%EA%B2%83%EC%9D%B4-%EC%BD%94%EB%94%A9-%ED%85%8C%EC%8A%A4%ED%8A%B8%EB%8B%A4.Part02.Chapter04-%EA%B2%8C%EC%9E%84-%EA%B0%9C%EB%B0%9C-Java
	// 출력값이 정답과 다르다.
	// StringTokenizer의 활용법을 익힐 수 있었음
	public void ch04_04_ex2() throws IOException {
		int[][] map;
		boolean[][] visit;
		int playerDir;
		int playerRowPos;
		int playerColPos;
		// 북동남서를 바라볼때 움직이는 경로
		int[] dRow = {-1, 0, 1, 0};
		int[] dCol = {0, 1, 0, -1};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int mapRow = Integer.parseInt(st.nextToken());
		int mapCol = Integer.parseInt(st.nextToken());
		
		map = new int[mapRow][mapCol];
		visit = new boolean[mapRow][mapCol];
		
		st = new StringTokenizer(br.readLine());
		playerRowPos = Integer.parseInt(st.nextToken());
		playerColPos = Integer.parseInt(st.nextToken());
		playerDir = Integer.parseInt(st.nextToken());
		
		visit[playerRowPos][playerColPos] = true;
		
		for(int i = 0 ; i < mapRow; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < mapCol; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 0;
		int visitCount = 1;
		
		while(true) {
			turnPlayer(playerDir);
			
			if((map[playerRowPos + dRow[playerDir]][playerColPos + dCol[playerDir]] == 0) &&
					(visit[playerRowPos + dRow[playerDir]][playerColPos + dCol[playerDir]] == false)) {
				visit[playerRowPos + dRow[playerDir]][playerColPos + dCol[playerDir]] = true;
				visitCount++;
				
				playerRowPos += dRow[playerDir];
				playerColPos += dCol[playerDir];
				
				count = 0;
			} else {
				count++;
			}
			
			if(count == 4) {
				if(map[playerRowPos - dRow[playerDir]][playerColPos - dCol[playerDir]] == 1) {
					break;
				} else {
					count = 0;
					playerRowPos -= dRow[playerDir];
					playerColPos -= dCol[playerDir];
				}
			}
		}
		
		System.out.println(visitCount);
		
	}
	
	public int turnPlayer(int playerDir) {
		playerDir -= 1;
		
		if (playerDir < 0) {
			playerDir = 3;
		}
		
		return playerDir;
	}
}
