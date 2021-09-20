package 알파벳_백준;

import java.util.Scanner;

public class test {
	static boolean[] check;// 알파벳을 이미 방문했는지를 저장할 배열
	static char[][] map;
	static int R, C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt(); // 1≤R≤20
		C = sc.nextInt(); // 1≤C≤20
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String line = sc.next();
			map[i] = line.toCharArray();
		}
		check = new boolean[26];
		// 수지는 0행0열에서 출발
		max = 0;
		dfs(0, 0, 1);
		System.out.println(max);
	}

	static int max = 0;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void dfs(int r, int c, int cnt) {
		check[map[r][c] - 65] = true;
		max = Math.max(max, cnt);
		if (max == 26) {
			return;
		}
		// 전이될 수 있는 다음상태는. 현재위치로부터 4방
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			// 나가면 아웃
			if (nr < 0 || nc < 0 || nr >= R || nc >= C)
				continue;
			// 이미 방문한 알파벳이면 아웃
			if (check[map[nr][nc] - 65])
				continue;
			// 괜찮으면 다음 호출로 갑시다
			dfs(nr, nc, cnt + 1);
		}
		// 4방에서 어디에도 재귀호출이 일어나지 않으면 끝나는 것
		check[map[r][c] - 65] = false;
	}
}
