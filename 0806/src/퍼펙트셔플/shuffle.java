package 퍼펙트셔플;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class shuffle {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();	// 카드 개수
			
			Queue<String> q1 = new LinkedList<>();
			Queue<String> q2 = new LinkedList<>();
			
			
			for(int i=0;i<N;i++) { //카드 입력받아서 큐에 넣어
				q2.offer(sc.next());
			}
			
			int num = (N%2)==0?N/2:(N/2+1); //카드개수 반으로 나누기

			for(int i=0;i<num;i++) { //다른 큐에 반 넣어
				q1.offer(q2.poll());
			}
			
			System.out.print("#"+test_case+" ");
			
			for(int i=0;i<N;i++) { //번갈아 가면서 출력하기
				if(i%2 == 0)
					System.out.print(q1.poll()+" "); 
				else
					System.out.print(q2.poll()+" ");
			}
			System.out.println();

		}
	}

}
