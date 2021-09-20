package 햄버거다이어트;

import java.util.Scanner;

public class v1 {

	static int[] score;
	static int[] cal;
	static boolean sel[];
	static int N,L;
	static int ans=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt(); //재료수
			L = sc.nextInt(); //제한 칼로리
			sel = new boolean[N];
			score = new int[N];
			cal= new int[N];
			ans=0;
			
			for(int i=0;i<N;i++) {
				score[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			
			powerSum(0);
			System.out.println("#"+test_case+" "+ans);

		}

	}
	
	static void powerSum(int idx) {
		if(idx==N) {
			int sumScore = 0;
			int sumCal = 0;
			for(int i=0;i<N;i++) {
				if(sel[i]) {
					sumScore += score[i];
					sumCal += cal[i];
				}
			}
			if(sumCal<=L) {
				ans = Math.max(sumScore, ans);
			}
			return;
		}	
		
		sel[idx] = true;
		powerSum(idx+1);
		sel[idx] = false;
		powerSum(idx+1);
	}
}
