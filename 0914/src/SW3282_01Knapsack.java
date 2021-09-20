

import java.util.Scanner;

public class SW3282_01Knapsack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[] weights = new int[N+1];
			int[] profits = new int[N+1];
			
			for (int i = 1; i <= N; i++) {
				weights[i] = sc.nextInt();
				profits[i] = sc.nextInt();
			}
			
			int[][] D = new int[N+1][K+1];
			
			for (int i = 1; i <= N; i++) {
				for (int w = 1; w <= K; w++) {
					
					if(weights[i] <= w) { //해당 물건을 가방에 넣을 수 있다.
						D[i][w] = Math.max(D[i-1][w], profits[i]+D[i-1][w-weights[i]]);
					}else { //해당 물건을 가방에 넣을 수 없다.
						D[i][w] = D[i-1][w];
					}
				}
			}
			System.out.println("#"+test_case+" "+D[N][K]);
		}

	}

}
