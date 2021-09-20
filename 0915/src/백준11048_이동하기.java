import java.util.Scanner;

public class 백준11048_이동하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int max = Integer.MIN_VALUE;
		int[][] map = new int[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
				
				max = Math.max(Math.max(map[i-1][j], map[i][j-1]), map[i-1][j-1]); //가장 큰거 구해서
				map[i][j] += max; //더해줌
			}
		}
		System.out.println(map[N][M]);
		

		
		

	}

}
