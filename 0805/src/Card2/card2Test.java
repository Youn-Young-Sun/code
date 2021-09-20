package Card2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class card2Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Queue<Integer> q = new LinkedList<>();
		
		int N = sc.nextInt();
		
		for(int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		
		while(q.size() > 1) { //하나 남을때까지 반복
			q.remove();		// 맨 앞의 원소 버려 
			q.add(q.poll());	// 맨 앞의 원소를 버림과 동시에 버려진 원소를 맨 뒤에 삽입 
		}
		
		System.out.println(q.poll());	// 마지막으로 남은 원소 출력 
		
		
	}

}
