package 부분수열의합2;

import java.util.Scanner;

public class subsequence2 {
	static int[] num;
	static int N,K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			K = sc.nextInt();
			num = new int[N];

			cnt=0;
			for(int i=0;i<N;i++) {
				num[i]=sc.nextInt();
			}
			powerSet(0, 0);
			System.out.println("#"+test_case+" "+cnt);

		}

	}
	static int cnt;
	static void powerSet(int idx, int sum) {
		if(idx==num.length) {
			if(sum==K) {
				cnt++;	
			}
			return;
		}	
		
		powerSet(idx+1, sum+num[idx]);
		powerSet(idx+1, sum);
	}

}