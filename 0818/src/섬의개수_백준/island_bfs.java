package 섬의개수_백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class island_bfs {
	 static int[][] map;
	 static int W, H;
	 public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	      while(true) {
	          W = sc.nextInt(); 
	          H = sc.nextInt();
	          if(W == 0 && H == 0)
	              break;
	          map = new int[H][W];
	          for(int i = 0; i < H; i++) {
	              for(int j = 0; j < W; j++)
	                  map[i][j] = sc.nextInt();
	          }
	          //탐색하면서, 육지인 경우. 카운트를 하나 세고, 연결된 모든 육지를 삭제
	          int cnt = 0;
	          for(int i = 0; i < H; i++) {
               for(int j = 0; j < W; j++) {
	                  if( map[i][j] == 1 ) {
	                      cnt++;
	                      //연결된 모든 육지를 0으로 삭제
	                      bfs(i, j);
	                 }
	              }
	           }
	            System.out.println(cnt);
	        }
	      }
	private static void bfs(int y, int x) {
		int[] dx = {-1,0,1,1,1,0,-1,-1};
	    int[] dy = {-1,-1,-1,0,1,1,1,0};
	            
	    Queue<int[]> queue = new LinkedList<>();
	        
	    // 시작위치 큐에 넣기
	    queue.add(new int[] {y,x});
	    map[y][x] = 0;
	        
	    while(!queue.isEmpty()) {
	    	int[] temp = queue.poll();
	        y = temp[0];
	        x = temp[1];
	           
	        for(int i = 0; i<8; i++) {
	           int currentY = y+dy[i];
	           int currentX = x+dx[i];
	            
	           if(currentY < 0 || currentY >= H || currentX < 0 || currentX >= W)
	               continue;
	           if(map[currentY][currentX] == 0)
	        	   continue;
	              
	           // 인접한 위치 큐에 넣기
	           queue.add(new int[] {currentY,currentX});
	           map[currentY][currentX] = 0;
	       
	        }
	      }
	  }
}

