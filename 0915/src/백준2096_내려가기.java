import java.util.Scanner;

public class 백준2096_내려가기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int max = 0, min = Integer.MAX_VALUE;
		int N = sc.nextInt();
		
		int[][] dp = new int[N][3];
		int[][] DP = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			dp[i][0] = sc.nextInt(); 
			dp[i][1] = sc.nextInt(); 
			dp[i][2] = sc.nextInt(); 
		}
		
		for (int i = 0; i < N; i++) {
			DP[i][0] = dp[i][0];
			DP[i][1] = dp[i][1]; 
			DP[i][2] = dp[i][2]; 
		}
		
		for (int i = 1; i < N; i++) {
			dp[i][0] += Math.min(dp[i-1][0], dp[i-1][1]);
			dp[i][1] += Math.min(Math.min(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
			dp[i][2] += Math.min(dp[i-1][1], dp[i-1][2]);
		}
		
		for (int i = 1; i < N; i++) {
			DP[i][0] += Math.max(DP[i-1][0], DP[i-1][1]);
			DP[i][1] += Math.max(Math.max(DP[i-1][0], DP[i-1][1]), DP[i-1][2]);
			DP[i][2] += Math.max(DP[i-1][1], DP[i-1][2]);
		}
		
		min = Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]);
		max = Math.max(Math.max(DP[N-1][0], DP[N-1][1]), DP[N-1][2]);
		
		System.out.println(max + " " + min);

	}

}
