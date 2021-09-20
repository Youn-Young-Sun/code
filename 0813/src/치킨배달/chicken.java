package 치킨배달;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class chicken {

	static int N,M,sum;
	static int[][] map;
	static ArrayList<Point> chicken= new ArrayList<>();
	static ArrayList<Point> home= new ArrayList<>();
    static Point[] sel;
    static int answer= Integer.MAX_VALUE;

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N=sc.nextInt();
		M=sc.nextInt();
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt(); 
				// 집 좌표 저장
                if(map[i][j] == 1) home.add(new Point(i, j));
                // 치킨집 좌표 저장
                else if(map[i][j] == 2) chicken.add(new Point(i, j));
			}
		}
		sel = new Point[chicken.size()];
		comb(0,0);
		System.out.println(answer);

	}
	private static void comb(int idx, int start) {
		if(idx == chicken.size()) {
			if(start == M) {
				sum=0;
			
				for(int i=0;i<home.size();i++) {
					int min = Integer.MAX_VALUE;
					for(int j=0;j<M;j++) {
						int dist = Math.abs(home.get(i).x-sel[j].x)+Math.abs(home.get(i).y-sel[j].y);
						min = Math.min(min, dist);
					}
					sum+=min;
				}
				answer = Math.min(answer, sum);
				return;
			}
			return;
		}
		sel[start] = chicken.get(idx);
		comb(idx+1, start+1);
		comb(idx+1, start);

	}

}
