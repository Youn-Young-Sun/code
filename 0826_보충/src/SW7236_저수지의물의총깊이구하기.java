import java.util.Scanner;

public class SW7236_저수지의물의총깊이구하기 {

	//팔방
	static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};
	static int[] dx = {0, 0, 1, -1, -1, 1, -1, 1};
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int max = 1; //물의 높이 하나도 없으면 1
			int N = sc.nextInt(); //저수지의 크기
			char[][] map = new char[N+2][N+2]; //범위체크를 하지 않기 위해서

			//초기 데이터 세팅
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}
			
			
			//각 원소를 돌면서 팔방 체크
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(map[i][j] == 'G') continue;
					//W인 경우
					//8방 돌면서 개수 세기
					int cnt = 0;
					for (int d = 0; d < 8; d++) {
						if(map[i+dy[d]][j+dx[d]] == 'W') cnt++;
					}
					max = Math.max(max, cnt);
				}
			}
			System.out.println("#"+test_case+" "+max);
		}

	}

}
