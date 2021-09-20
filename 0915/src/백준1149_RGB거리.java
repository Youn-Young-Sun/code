import java.util.Scanner;

public class 백준1149_RGB거리 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] dp = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			dp[i][0] = sc.nextInt(); //R
			dp[i][1] = sc.nextInt(); //G
			dp[i][2] = sc.nextInt(); //B
		}
		
		for (int i = 1; i < N; i++) {
			dp[i][0] += Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] += Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] += Math.min(dp[i-1][0], dp[i-1][1]);
		}
		
		System.out.println(Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));

		
		

	}

}
