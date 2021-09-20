package 단지번호붙이기_백준;

import java.util.Arrays;
import java.util.Scanner;

public class complex2_dfs {
    static int[][] map;
    static int N;
    static int[] cnt;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        cnt = new int[N * N];
        
        for(int i = 0; i < N; i++) { //지도 입력
            String str = sc.next();
            for(int j = 0; j < N; j++)
                map[i][j] = str.charAt(j) - '0';
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if( map[i][j] == 1 ) {
                    dfs(i, j);
                    idx++;
                }
            }
        }
        
        Arrays.sort(cnt, 0, idx);
        System.out.println(idx);//단지의 수
        for(int i = 0; i < idx; i++)
            System.out.println(cnt[i]);
    }
    static int idx;
    static void dfs(int r, int c) {
        map[r][c] = 0;
        cnt[idx]++; //단지별로 개수 세기
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nc < 0 || nr >= N || nc >= N)
                continue;
            if(map[nr][nc] == 0)
                continue;

            dfs(nr, nc);
        }
    }
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
}


