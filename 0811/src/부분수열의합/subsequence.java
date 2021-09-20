package 부분수열의합;

import java.util.Scanner;

public class subsequence {
	
	static int[] num;
	static boolean sel[];
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
			sel = new boolean[N];
			cnt=0;
			for(int i=0;i<N;i++) {
				num[i]=sc.nextInt();
			}
			powerSet(0);
			System.out.println("#"+test_case+" "+cnt);

		}

	}
	static int cnt;
	static void powerSet(int idx) {
		if(idx==num.length) {
			int sum = 0;
			for(int i=0;i<num.length;i++) {
				if(sel[i]) {
					sum += num[i];
				}
			}
			if(sum==K) {
				cnt++;	
			}
			return;
		}	
		sel[idx] = true;
		powerSet(idx+1);
		sel[idx] = false;
		powerSet(idx+1);
	}

}
