import java.util.Scanner;

public class 데일리실습_연습문제2번 {
static long[] memo;
	
	public static long fibo1(int n) {
		if(n >= 3 && memo[n]==0) {
			memo[n] = fibo1(n-1)*2 + fibo1(n-2);
		}
		return memo[n];
	}
	
	public static long fibo2(int n) {
		long[] D = new long[n+1];
		D[1] = 2;
		D[2] = 5;
		for (int i = 3; i <= n; ++i) {
			D[i] = D[i-1]*2 + D[i-2];
		}
		return D[n];
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		memo = new long[N+1]; //자동으로 0 초기화 : 메모되지 않은 상태로 사용할 것
		
		//계산할 수 없는 기본값들 초기화
		memo[1] = 2;
		memo[2] = 5;
		
		System.out.println(fibo1(N));
		System.out.println(fibo2(N));
		
	}
}
