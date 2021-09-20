import java.util.Scanner;

public class 색종이_백준10163 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //색종이 개수
		int[][] map = new int[1001][1001]; //도화지 크기
		
		for (int n = 1; n <= N; n++) { 
			int r = sc.nextInt(); //행
			int c = sc.nextInt(); //열
			int w = sc.nextInt(); //너비
			int h = sc.nextInt(); //높이
			
			//색종이 영역
			for (int i = r; i < r + w; i++) {
				for (int j = c; j < c + h; j++) {
					map[i][j] = n;
				}
			}
		}
		
		int[] ans = new int[N + 1]; //카운팅
		
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				ans[map[i][j]]++;
			}
		}
		
		for (int i = 1; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
		
	}
}
