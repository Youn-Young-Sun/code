package 문제풀기;

import java.util.Scanner;

public class 최빈수구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int[] students = new int[1000];
			int[] cnt = new int[101];
			int max = 0;
			int t=sc.nextInt(); //상관없는
			
			for(int i=0; i<students.length; i++)
			{
				int score = sc.nextInt();
				cnt[score]++;
			}
			 for(int k=0; k<cnt.length; k++)
	            {
	                if(cnt[max] <= cnt[k]) max = k;
	            }
		}
	}
}

	


