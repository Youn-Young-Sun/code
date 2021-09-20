import java.util.Scanner;

public class 백준3095_123더하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		int[] dp = new int[12];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int i = 4; i <= 11; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			System.out.println(dp[N]);
		}

	}

}
