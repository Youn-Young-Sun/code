import java.io.BufferedReader;
import java.io.InputStreamReader;

// 순회 중 기지국을 만나면 A-B-C 에 따라 반복횟수를 구한 뒤 사방 탐색
// 사방 탐색 중 H 를 만나면 H => X 로 변경
// 배열 다시 탐색하면서 H 개수 계산
public class Intermediate_기지국 {
	
	static int T, N, ans;
	static char[][] map;
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];

			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray(); //한줄씩 읽어와서 1차원배열에 넣기
			}

			ans = 0; // 테스트케이스마다 초기화

			// 기지국별 커버가능한 집 체크 (커버가능한 집은 X로 변경)
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					// 비교 조건을 생각!!
					// A || B || C 로 처리 보다는 X != H != 이 낫다.
					// if (조건에 맞으면){} 보다는 
					//     if (map[i][j] != 'X' && map[i][j] != 'H') { .... }
					// if (조건에 안 맞으면) continue 가 보기에 또 문서 구조에 유리
					
					if (map[y][x] == 'X' ||  map[y][x] == 'H') continue; //구현에는 영향이 없지만 깔끔하게
					
					// A || B || C
					int cnt = map[y][x] - 'A'; //0,1,2 셋중에 하나
					
					for (int i = 1; i < cnt + 2; i++) {
						// 기지국 종류별로 반복횟수 설정
						if (y + i < N && map[y + i][x] == 'H') { // 남
							map[y + i][x] = 'X';
						}
						if (x + i < N && map[y][x + i] == 'H') { // 동
							map[y][x + i] = 'X';
						}
						if (y - i > -1 && map[y - i][x] == 'H') { // 북
							map[y - i][x] = 'X';
						}
						if (x - i > -1 && map[y][x - i] == 'H') { // 서
							map[y][x - i] = 'X';
						}
					}
				}
			}

			// 커버 안된 집 개수 카운트
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'H')
						ans++;
				}
			}

			System.out.println("#" + t + " " + ans);
		}
	}
}
