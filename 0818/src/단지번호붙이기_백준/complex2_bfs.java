package 단지번호붙이기_백준;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class complex2_bfs {
	
static int[][] map;
static int N;
static int[] cnt;


public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    map = new int[N][N];
    cnt = new int[N * N];
    
    for(int i = 0; i < N; i++) {
        String str = sc.next();
        for(int j = 0; j < N; j++)
            map[i][j] = str.charAt(j) - '0';
    }

    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
            if( map[i][j] == 1 ) {
                bfs(i, j);
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
static void bfs(int r, int c) {
    Queue<Node> queue = new LinkedList<>(); //큐에 좌표 넣기
    queue.add(new Node(r, c)); //처음 좌표 넣고
    map[r][c] = 0; //갓다온표시
    cnt[idx]++; //카운트
    while(!queue.isEmpty()) {
        Node n = queue.poll();
        for(int d = 0; d < 4; d++) {
            int nr = n.r + dr[d];
            int nc = n.c + dc[d];
            if(nr < 0 || nc < 0 || nr >= N || nc >= N)
                continue;
            if(map[nr][nc] == 0)
                continue;
            queue.add(new Node(nr, nc)); //위에 if문 두개 아니면 큐에 좌표 넣기
            map[nr][nc] = 0;
            cnt[idx]++;
        }
    }
}
static class Node{
    int r, c;
    Node(int r , int c ){
        this.r = r; this.c = c;
    }
}
static int[] dr = {-1, 1, 0, 0};
static int[] dc = {0, 0, -1, 1};
}
