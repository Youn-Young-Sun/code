package 준홍이의카드놀이;

import java.util.Scanner;

public class Card {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();


		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N=sc.nextInt();
			int M=sc.nextInt();
			
			int[] cnt=new int[N*M];

			//배열에 더한 값 얼마큼인지 표시
			for(int i=1;i<=N;i++) {
				for(int j=1 ; j<=M;j++) {
					cnt[i+j]++;
				}
			}
			int max=0;
			for(int i=2;i<=N+M;i++) { //더한값중에 제일 많이 나온값 구하기
				if(cnt[i]>max) max=cnt[i];
			}
			System.out.print("#"+test_case+" ");
			for(int i=2;i<=N+M;i++) { //더한값중에 제일 많이 나온값이랑 같으면 출력
				if(cnt[i]==max) System.out.print(i+" ");
			}
			
			System.out.println();
			

		}

	}

}
