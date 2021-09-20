package 도영이가만든맛있는음식;

import java.util.Scanner;

public class food {

	static int[] S;
	static int[] B;
	static int N;
	static int ans=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
			N = sc.nextInt(); //재료수
			S = new int[N]; //신맛
			B = new int[N]; //쓴맛 
			ans=Integer.MAX_VALUE;
			
			for(int i=0;i<N;i++) {
				S[i] = sc.nextInt();
				B[i] = sc.nextInt();
			}
			
			powerSum(0,1,0);
			System.out.println(ans);

	}
	
	static void powerSum(int idx, int multiS, int sumB) {
		if( idx == N ) {
			if(multiS == 1 && sumB == 0) return; //공집합 처리
			if(ans > Math.abs(multiS-sumB)) 
			    ans =Math.abs(multiS-sumB);
			return;
		}
		
		powerSum(idx + 1, multiS * S[idx], sumB+B[idx]);
		powerSum(idx + 1, multiS, sumB);
	}

}
