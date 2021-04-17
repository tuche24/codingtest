package chapter03;

import java.util.Scanner;

// 문제 4번 1이 될때까지
public class ch03_04 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int divVal = sc.nextInt();
		
		int count = 0;
		
		while(num != 1) {
			if(num % divVal == 0) {
				num = num/divVal;
			} else {
				num = num - 1;
			}
			
			count++;
		}
		
		System.out.println(count);
	}
}
// N이 100억 이상의 큰 수가 되는 경우를 가정했을 때에도 빠르게 동작하려면, 
// N이 K의 배수가 되도록  효율적으로 한 번에 빼는 방식으로 소스코드를 작성할 수 있다.
