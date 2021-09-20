import java.util.Scanner;

public class 백준1912_연속합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int max = Integer.MIN_VALUE;
		int[] arr = new int[100001];
		int[] dp = new int[100001];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 1; i <= N; i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
		}
		
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);

	}

}
