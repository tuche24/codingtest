package chapter05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// ch5 DFS.BFS 예제 참조주소 : https://freedeveloper.tistory.com/273
public class ch05_ex {

	public static void main(String[] args) {
		ch05_ex ch = new ch05_ex();
		ch.queEx();
	}
	
	// 스택 구현 예제
	private void stackEx() {
		Stack<Integer> s = new Stack<>();
		
		s.push(5);
		s.push(2);
		s.push(3);
		s.push(7);
		s.pop();
		s.push(1);
		s.push(4);
		s.pop();
		// 스택의 최상단 원소부터 출력
		while(!s.empty()) {
			System.out.println(s.peek());
			s.pop();
		}
		
	}
	
	// 큐 구현 예제
	private void queEx() {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(5);
		q.offer(2);
		q.offer(3);
		q.offer(7);
		q.poll();
		q.offer(1);
		q.offer(4);
		q.poll();
		// 먼저 들어온 원소부터 추출
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}
	
}
