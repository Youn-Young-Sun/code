package 색종이붙이기_백준;

import java.util.Scanner;

public class coloredPaper {
		static int[][] map = new int[10][10];
		static int ans = 26; //아무 수나
		public static void main(String[] args) {
		    Scanner sc = new Scanner(System.in);
		    for(int i = 0; i < 10; i++) {
		        for(int j = 0; j < 10; j++)
		            map[i][j] = sc.nextInt();
		    }
		    backtrack(0);
		    System.out.println(ans == 26 ? -1 : ans); //안되면 -1 출력
		}
		static void backtrack(int cnt) {
		    int sR = -1, sC =-1; 
		    out:for(int i = 0; i < 10; i++) {
		        for(int j = 0; j < 10; j++) {
		            if( map[i][j] == 1 ) { 
		                sR = i; sC = j; //1인 위치 기억
		                break out;
		            }
		        }
		    }
		    if( sR == -1 && sC == -1) { //모두 0이면 정답
		        ans = Math.min(ans, cnt);
		        return;
		    }
		    int max = 5;
		    while(max > 0) {
		        boolean isOk = true;
		        out:for(int i = 0; i < max; i++) {
		            for(int j = 0; j < max; j++) {
		                if( sR+i >= 10 || sC+j >= 10 || map[sR+i][sC+j] == 0 ) { //지도에 있어야돼
		                    isOk = false;
		                    break out;
		                }
		            }
		        }
		        if(isOk)
		            break;
		        max--;
		    }
		    for(int i = 1; i <= max; i++) { //5장 다 쓸때까지 반복
		        if(paper[i] == 0) //5장 다 쓸때까지
		            continue;
		        paper[i]--; //붙이고
		        for(int r = sR; r < sR+i; r++) {
		            for(int c = sC; c < sC+i; c++)
		                map[r][c] = 0;
		        }
		        backtrack(cnt+1);
		        paper[i]++; //떼고
		        for(int r = sR; r < sR+i; r++) {
		            for(int c = sC; c < sC+i; c++)
		                map[r][c] = 1;
		        }
		    }
		}
		static int[] paper = {0, 5,5,5,5,5}; //5장까지 가능
}