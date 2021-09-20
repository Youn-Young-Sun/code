package 파이프옮기기1_백준;

import java.io.Serializable;
import java.util.Scanner;

public class pipe implements Serializable {
	
	static int N,ans;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		dfs(0,1,0); //(0,1)에서 시작
		
		System.out.println(ans);
		

	}
	
	private static void dfs(int r, int c, int d) {
		if(r == N-1 && c == N-1) { //파이프가 (N-1,N-1)로 갔을 때 끝내
			ans++; 
			return;
		}
		//가로(0): 세로는 못하고, 맵안쪽에 있어야되고, 벽이 없어야됨
		if(d!=1 && c+1<N && map[r][c+1] == 0 ) {
			dfs(r,c+1,0);
		}
		//세로(1): 가로는 못하고, 맵안쪽에 있어야되고, 벽이 없어야됨
		if(d!=0 && r+1<N && map[r+1][c] == 0) {
			dfs(r+1,c,1);
		}
		//대각선(2): 맵안쪽에 있어야되고, 벽이 없어야됌
		if(r+1<N && c+1<N && map[r][c+1]+map[r+1][c]+map[r+1][c+1] == 0) {
			dfs(r+1,c+1,2);
		}
	}

}
