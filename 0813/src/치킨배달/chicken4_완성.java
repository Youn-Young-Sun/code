package 치킨배달;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//치킨집이 여러개 일때 여러개
public class chicken4_완성 {
	static class Point{
		int r,c;
		Point(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M;
	static int[][] map;
	static List<Point> houses= new ArrayList<>();
	static List<Point> chickens= new ArrayList<>();
	static Point[] sel;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 N=sc.nextInt();
		 M=sc.nextInt();
		 sel = new Point[M];
		 map = new int[N][N];
		 
		 for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==2) {
					chickens.add(new Point(i,j));
				}
				else if(map[i][j]==1)
					houses.add(new Point(i,j)); //집들 기억
			}
		}
		 combination(0,0);
		 System.out.println(ans);

	}
	private static void combination(int cnt, int start) {
		if(cnt == M) {  //M개가 되면
			//각 집별로 M개의 선택된 치킨집 중 가장 가까운 치킨집까지의 거리를 구해서 다 더함
			int sum=0;
			for (int i = 0; i < houses.size(); i++) {
				int tmp=Integer.MAX_VALUE;
				Point house = houses.get(i); //집 좌표 가져옴
				for(int j=0; j < M;j++) {
					Point chicken = sel[j];  //치킨 좌표가 선택된거면
					int dist = (Math.abs(house.r-chicken.r)+Math.abs(house.c-chicken.c)); //계산
					tmp = Math.min(tmp, dist); //최소값
				} 
				sum += tmp; //더함
			}
			//그 다 더한값이 젤 작으면 그게 정답
			ans = Math.min(ans, sum);
			return;
		}

		//start 위치의 수부터 가능한 수 모두 고려
		for(int i=start;i<chickens.size();i++) { //i:인덱스
			sel[cnt] = chickens.get(i); //현재 위치에서 뽑은 수 기억
	
			combination(cnt+1,i+1); //i+1: 다음 인덱스부터 뽑기

		}
	}
}
