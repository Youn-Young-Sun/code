package 한빈이와SpotMart;

import java.util.Scanner;

public class SpotMart {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt(); //과자개수
			int M = sc.nextInt(); //제한 무게 합
			int[] n = new int[N];
			
			for(int i=0;i<N;i++) { //과자 무게 입력받기
				n[i] = sc.nextInt();
			}
			
			int ans = -1;
			for(int i=0;i<N;i++) {
				for(int j=i+1;j<N;j++) {
					if(n[i]+n[j]<=M) ans=Math.max(ans,n[i]+n[j]); //최대무게합 보다 같거나 작으면 ans에 저장
				}
			}
			 System.out.println("#"+test_case+" "+ans);
			
		}

	}

}
