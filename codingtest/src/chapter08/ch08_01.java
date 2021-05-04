package chapter08;
// 피보나치 수열 참조 : https://freedeveloper.tistory.com/276?category=888096
public class ch08_01 {

	public static void main(String[] args) {
		ch08_01 ch = new ch08_01();
		ch.execute(4);
	}
	
	private int execute(int x) {
		if(x == 1 || x == 2) {
			return 1;
		}
		return execute(x - 1) + execute(x - 2);
	}
	
}
