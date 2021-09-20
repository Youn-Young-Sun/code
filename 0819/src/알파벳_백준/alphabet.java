package 알파벳_백준;

import java.util.Scanner;

public class alphabet {
	   static int[][] map;
	    static int R, C,result=0;
	    static int[] cnt;
	    static boolean[] visited;

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        R = sc.nextInt();
	        C= sc.nextInt();
	        map = new int[R][C];
	        visited = new boolean[26];	//지나간 알파벳표시
	        
	        for(int i = 0; i < R; i++) { //지도 입력
	        	String str = sc.next();
	            for(int j = 0; j < C; j++) {
	                map[i][j] = str.charAt(j)-'A'; //0부터 시작할 수 있게
	            }
	        }

	        //시작지점
	        visited[map[0][0]] = true;
			dfs(0,0,1);
	
			
			System.out.println(result);
	        
	    }
	    static void dfs(int r, int c, int cnt) {

    		result = Math.max(result, cnt);
    		
    		if(result == 26) return;
    		
    		for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if(nr < 0 || nc < 0 || nr >= R || nc >= C ) //범위 아니면 넘어가
            	continue;
            
            if(visited[map[nr][nc]])
            	continue;
            
            visited[map[nr][nc]] = true;
            dfs(nr, nc, cnt+1); 
            visited[map[nr][nc]] = false;
    		}
	    }
	    //좌 우 상 하
	    static int[] dr = {-1, 1, 0, 0}; //행(row) 
	    static int[] dc = {0, 0, -1, 1}; //열(column) 

}