
import java.util.Scanner;

public class 정올1037_오류교정 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] map = new int[n+1][n+1]; //change bit에서 위치값 편하게 찍으려고
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		//행의 합과 열의 합의 홀수의 개수를 센다
		//행과 열이 1개씩 홀수가 있을때 변경할 위치: x, y
		int cnt1 = 0, cnt2 = 0, x = 0, y = 0;
		for (int i = 1; i <= n; i++) {
			int sum1 = 0, sum2 = 0; //행의 합, 열의 합
			for (int j = 1; j <= n; j++) {
				sum1 += map[i][j]; //행의 합
				sum2 += map[j][i]; //열의 합
			}
			if(sum1 % 2 == 1) {
				cnt1++; //현재 행이 홀수면 행의 홀수합 +1
				x = i;
			}
			if(sum2 % 2 == 1) {
				cnt2++; //열의 합이 홀수면 열의 홀수합 +1
				y = i;
			}
		}
		if(cnt1 == 0 && cnt2 == 0) System.out.println("OK");
		else if(cnt1 == 1 && cnt2 == 1) System.out.println("Change bit ("+x+","+y+")");
		else System.out.println("Corrupt");

	}

}
