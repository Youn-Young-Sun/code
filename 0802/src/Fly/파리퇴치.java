package Fly;

import java.util.Scanner;
import java.io.FileInputStream;

public class 파리퇴치 {
		public static void main(String args[]) throws Exception
		{

			Scanner sc = new Scanner(System.in);
			int T;
			T=sc.nextInt();

			for(int test_case = 1; test_case <= T; test_case++)
			{
				int N=sc.nextInt();
				int M=sc.nextInt();
				int[][] NN=new int[N][N];
				int sum=0;
				int max=0; 
				
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						NN[i][j]=sc.nextInt();
					}
				}
				
				
				for(int i=0;i<N-M+1;i++) {
					for(int j=0;j<N-M+1;j++) {
						sum=0;
						for(int k=0;k<M;k++) {
							for(int l=0;l<M;l++) {
								sum+=NN[i+k][j+l];
							}
						}
						if(sum>max) max=sum;
					}
				}
				System.out.println("#"+test_case+" "+max);
		}
	}
}
