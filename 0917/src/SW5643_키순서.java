import java.util.Arrays;
import java.util.Scanner;

public class SW5643_키순서 {
    static final int INF = 987654321;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 사람의 수
            int M = sc.nextInt(); // 간선의 수
            int[][] adj = new int[N+1][N+1];
            for(int i = 0; i < N+1; i++) {
                Arrays.fill(adj[i], INF);
                adj[i][i] = 0;
            }
            for(int i = 0; i < M; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                adj[from][to] = 1;
            }
            //floyd warshall 알고리즘 수행
            for (int k = 1; k < N+1; k++) {
    			for (int i = 1; i < N+1; i++) {
    				// 출발점==경유지는 관심이 없다~~
    				if (i == k) {
    					continue;
    				}
    				for (int j = 1; j < N+1; j++) {
    					// 경유지==목적지는 관심 없다~~
    					if (k == j) {
    						continue;
    					}
    					// 경유해서 가는 비용이 더 적다면 바꿔주자.!!!!
    					if (adj[i][k] + adj[k][j] < adj[i][j]) {
    						adj[i][j] = adj[i][k] + adj[k][j];
    					}
    				}
    			}
    		}
//            int result = 0;
//            for(int i = 1; i < N+1; i++) {
//            	int cnt = 0;
//            	for (int j = 1; j < N+1; j++) {
//					if(adj[i][j] != INF) cnt++;
//					if(adj[j][i] != INF) cnt++;
//				}
//            	if(cnt == N-1) result++;
//            }
            int[] cnt = new int[N+1];//각 사람별로 INF가 아닌 갯수
            //각 사람별로 INF의 갯수를 카운트
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if( adj[i][j] != INF && adj[i][j] != 0 ) {
                        cnt[i]++;
                        cnt[j]++;
                    }
                }
            }
            //INF의 갯수가 0인 사람은 내 키를 아는것. 그놈의 수를 센다
            int ans = 0;
            for(int i = 1; i <= N; i++) {
                if( cnt[i] == N-1 )
                    ans++;
            }
           
            
            //그 값이 결과
            System.out.println("#"+tc+" "+ans);
        }
    }
}