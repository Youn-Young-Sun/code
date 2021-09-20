import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오목_백준2615 {
	static int ans, ansY, ansX;
	static boolean found;
	static int N=19; //바둑판
	static int[][] map;
	
	//델타: 우, 우하, 하, 좌하
	 static int[] dy = {0, 1, 1, 1}; //행(row) 
	 static int[] dx = {1, 1, 0, -1}; //열(column) 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[N+1][N+1];
		
		//입력
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		
		//탐색
		outer :  //불리안을 트루로해서 해도됌
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(found ) break outer;  //발견하면 완전 끝내
				if(map[i][j] != 0) search(i,j); //1,2니깐
			}
		}
		
		//출력
		System.out.println(ans);
		if(ans != 0) {
			System.out.println(ansY + " " + ansX);
		}
	}
	
	//y,x 지점에서 오목 체크
	private static void search(int y, int x) {
		//4가지 방향으로 탐색
		for (int d = 0; d < 4; d++) {
			
			//5개 확인(오목인지)
			int cnt = 1; //이미 들어온 돌 하나 세고
			int ny = y;
			int nx = x;
			
			//해당 방향으로 5개인지 확인
			for (int i = 0; i < 5; i++) { //진행방향으로 하나 더 확인
				ny = ny + dy[d];
				nx = nx + dx[d];
				
				//범위 체크(1 ~ N), 유효성 체크
				if(ny < 1 || ny > N || nx < 1 || nx > N || map[ny][nx] != map[y][x]) //색깔이 같지 않으면
					break;
				
				cnt++; //계속 같은색 
			}
			//오목 6목 확인
			if(cnt == 5) {//5개까지 같은 색이면
				//강력한 오목 후보
				//시작점 바로 뒤쪽 색 확인
				if(watchBack(y, x, d)) { //true면 오목 발견
					found = true;
					ans = map[y][x];
					
					if(d == 3) { //방향이 좌하 면
						ansY = y + 4;
						ansX = x - 4;
					}
					else {
						ansY = y;
						ansX = x;
					}
					
					break;
				}
			}
		}
	}
	static boolean watchBack(int y, int x, int d) { //뒤쪽 색 확인 d=direction
		int by = y - dy[d]; //뒤쪽으로
		int bx = x - dx[d]; //뒤쪽으로
		
		if(map[by][bx] != map[y][x]) return true; //다르면 true
		return false; //같으면 false
	}
}
