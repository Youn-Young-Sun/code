package 농작물수확하기;

import java.util.Scanner;

public class cropTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트 개수
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); //정사각형의 크기
			int[][] map = new int[N][N]; //농장의 크기
			
			
			for(int i = 0; i < N; i++) {
				String str = sc.next(); //농장 데이터 받기
				for(int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0'; //농장데이터 하나씩 배열에 넣기
				}
			}
			
			int sum = 0;
			//가운데 좌표를 구하자.
			int cx = N / 2;
			int cy = N / 2;
			int dist = N / 2; //중심으로부터 이 거리까지(작거나같으면)만 수확됨.
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
//					좌표i,j와 좌표cx,cy의 거리가 dist보다 작거나 같아야함
					if( Math.abs(i - cx) + Math.abs(j - cy) <= dist ) { //절대값으로 거리 구하기
						sum += map[i][j];
					}
				}
			}
			
			System.out.println("#" + tc + " " + sum);
		}

	}

}
