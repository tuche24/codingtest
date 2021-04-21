package chapter04;

import java.text.DecimalFormat;
import java.util.Scanner;

// 예제 4-2 시각 
public class ch04_02 {

	public static void main(String[] args) {

		ch04_02 ch = new ch04_02();
		ch.ch04_02ex1();
		// 입력값 5, 출력값 11475 
	}
	
	public void ch04_02ex1() {

		Scanner sc = new Scanner(System.in);
		int hour = 0;
		int minute = 0;
		int second = 0;

		int goalHour = sc.nextInt() + 1;

		int count = 0;

		while (goalHour != hour) {

			second++;
			
			if (second == 60) {
				minute++;
				second = 0;

				if (minute == 60) {
					hour++;
					minute = 0;
				}
			}
			
			DecimalFormat df = new DecimalFormat("00");
			
			String s_second = df.format(second);
			String s_minute = df.format(minute);
			String s_hour = df.format(hour);
			
			if(s_second.charAt(0) == '3' || s_second.charAt(1) == '3' || 
					s_minute.charAt(0) == '3' || s_minute.charAt(1) == '3' ||
					s_hour.charAt(0) == '3' || s_hour.charAt(1) == '3') {
				count++;
				System.out.println(s_hour + ":" + s_minute + ":" + s_second + " " + count);
			}
		}

		System.out.println(count);
	}
	
}
