package 안전영역_백준;

import java.util.Scanner;

public class safetyField {
    static int[][] map;
    static int N;
    static int[] cnt;
    public static boolean [][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        int result = 1;	// 안전영역이 최대인 개수(출력할 변수)
        
        for(int i = 0; i < N; i++) { //지도 입력
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
		
		// 안전영역이 최대인 개수 찾기.높이가 1~100까지
		for(int i=1; i<=100; i++) {	
			visited = new boolean[N][N];	// 각 높이마다 방문 영역 초기화
			int count = 0;	// 각 높이마다 안전영역의 개수 초기화
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					// 잠기지 않는곳(높이보다 높고) && 방문하지 않은 곳 이면
					if(map[j][k] > i && visited[j][k] == false) {
						count ++;
						dfs(j, k, i);
					}
				}
			}
			// i 높이의 모든 탐색이 끝나면 이전과 비교해 크기가 최대인 영역 구하기.
			result = Math.max(result, count);	
		}
		System.out.println(result);
        
    }

    static void dfs(int r, int c, int height) {
        visited[r][c] = true;
        
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if(nr < 0 || nc < 0 || nr >= N || nc >= N ) //범위 아니면 넘어가
            	continue;
            if(visited[nr][nc]) //방문했으면 넘어가
                continue;
            if(map[nr][nc]<=height) //높이 낮으면 넘어가 
            	continue;
            
            dfs(nr, nc, height); //아닌것들만
            
        }
    }
    //좌 우 상 하
    static int[] dr = {-1, 1, 0, 0}; //행(row) 
    static int[] dc = {0, 0, -1, 1}; //열(column) 
}
