package 요세푸스순열;

import java.util.LinkedList;
import java.util.Scanner;

public class Josephus {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //숫자 입력받음
		int K =sc.nextInt();  //K번째 없앰
		int cnt = 0;
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for(int i=1;i<=N;i++) { //1~N까지 넣음
			list.add(i);
		}
		
		System.out.print("<");
		while(!list.isEmpty()) {
			cnt++;
			if(cnt%K==0) System.out.print(list.poll()+", "); // K번째라면 출력
			else if (list.size()==1) System.out.print(list.poll()); //마지막이면 쉼표없이 출력
			else list.offer(list.poll()); // K번째 아니면 뒤에 삽입
		}
		System.out.println(">");

	}

}
