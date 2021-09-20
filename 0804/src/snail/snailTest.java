package snail;

import java.util.Scanner;

public class snailTest {

	public static void main(String[] args) {
		
	   Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{ 	
			int N=sc.nextInt();
			int[][] arr = new int[N][N];
			int cnt=1;
			 int i=0, j=-1, h=N;
			 
			while(cnt<=(N*N)) {
				for(int k=0;k<h;k++) {
					arr[i][++j]=cnt++;
				}
				h--;
				for(int k=0;k<h;k++) {
					arr[++i][j]=cnt++;
				}
				for(int k=0;k<h;k++) {
					arr[i][--j]=cnt++;
				}
				h--;
				for(int k=0;k<h;k++) {
					arr[--i][j]=cnt++;
				}
				
			}
			System.out.println("#"+test_case);
			
			for(int a=0;a<N;a++) {
				for(int b=0;b<N;b++) {
					System.out.print(arr[a][b]+ " ");
				}
				System.out.println();
			}
			

		}
	}

}
