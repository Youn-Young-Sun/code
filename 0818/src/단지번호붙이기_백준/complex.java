package 단지번호붙이기_백준;

import java.util.Arrays;
import java.util.Scanner;

public class complex {
	static int count = 1;	// 단지번호
	static int N;			// 지도 크기
	static int[][] map = new int[25][25];	
	static boolean[][] visit = new boolean[25][25];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	// 지도 크기
		
		for(int i=0; i<N; i++) {	// 지도 입력
			String str = sc.next();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1 && visit[i][j] == false) { //방문 안했으면
					dfs(i, j);	// 단지수 카운드
					count ++;	// 단지번호 +1
				}
			}
		}
		
		System.out.println(count-1);	// 단지개수
		
		//단지별로 카운트
		int[] arr = new int[count];		// 단지개수 만큼 집 개수
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != 0) {	// 집 있으면 1~
					arr[map[i][j]] ++;	// 단지 번호로 저장
				}
			}
		}
		
		Arrays.sort(arr);
		for(int i=1; i<count; i++) 
			System.out.println(arr[i]);	// 단지 개수 
	}
	
    private static void dfs(int r, int c) {
    	map[r][c] = count; //단지 번호 남기기
		visit[r][c] = true;
		
		for(int i=0; i<4; i++) {	
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr>=0 && nc>=0 && nr<N && nc<N) {	
				if(map[nr][nc] == 1 && visit[nr][nc] == false) {//1이고 방문하지 않으면 다시 탐색
					dfs(nr, nc);	
				}
			}
		}
	}
    static int[] dr = { -1, 0, 1, 0}; //서 남 동 북
    static int[] dc = { 0, 1, 0, -1};
}
