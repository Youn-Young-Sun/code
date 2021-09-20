package 암호생성기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class codeTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1;tc<=10;tc++) {
			int T =sc.nextInt();
			
			Queue<Integer> que = new LinkedList<>();
		
			//큐에 입력
			for(int i=0;i<8;i++) {
				int data = sc.nextInt();
				que.add(data);
			}
			
			int cnt =1;
			while(cnt!=0) {
				for(int i=1;i<6;i++) { //한사이클 돌기
					cnt=que.poll();
					cnt-=i;
					if(cnt<=0) cnt=0;
					que.offer(cnt);
					if(cnt==0) break;
				}
			}
			
			System.out.println("#"+tc+" ");
			
			for(int i=0;i<8;i++) {
				int a=que.poll();
				System.out.print(a+" ");
			}
			System.out.println();

		
		}
	}

}
