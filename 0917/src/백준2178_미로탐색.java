import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준2178_미로탐색 {
    static int[] dx = {0,0,1,-1}; //하 상 좌 우
    static int[] dy = {1,-1,0,0};
    static int[][] map;
    static boolean[][] visited;
    static int N, M;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String str = sc.next();
            for(int j = 0; j < M; j++){
            	map[i][j] = str.charAt(j) - '0';
            }
        }
        bfs();
        System.out.println(map[N-1][M-1]);
    }

    private static void bfs() {
        Queue<Integer> qx = new LinkedList<Integer>();
        Queue<Integer> qy = new LinkedList<Integer>();

        qx.offer(0);
        qy.offer(0);

        visited[0][0] = true;

        while(!qx.isEmpty()){
            int x = qx.poll();
            int y = qy.poll();

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if(map[nx][ny] == 1 && !visited[nx][ny]){
                    	qx.offer(nx);
                        qy.offer(ny);

                        visited[nx][ny] = true;

                        map[nx][ny] = map[x][y] + 1;
                    }
                }
            }
        }
    }
}
