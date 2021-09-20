package 최적경로;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class optimalPath_v1 {
	
	static class Point {
		int x,y;
		Point () {};
		Point (int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int N;
	static Point[] arr;
	static Point start,dest; //회사랑 집
	static boolean[] sel;
	static int[] result; //arr배열의 인덱스 체크
	static int min;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();//고객의 수
			min = Integer.MAX_VALUE;
			start = new Point(sc.nextInt(),sc.nextInt());
			dest = new Point(sc.nextInt(),sc.nextInt());
			arr= new Point[N];
			for(int i=0;i<arr.length;i++) {
				arr[i]= new Point(sc.nextInt(),sc.nextInt());
			}
			sel = new boolean[N];
			result = new int[N];
			
			
			permutation(0);
			System.out.println("#"+test_case+" "+min);

		}
	}
	private static void permutation(int idx) {
		if(idx == N) { //R개가 되면 끝
			int dist = 0 ;
			Point cur = start;
			Point startc = new Point(0,0);
			for(int i=0; i < N ;i++) {
				Point p = arr[result[i]];
				dist += Math.abs(cur.x-p.x)+Math.abs(cur.y-p.y);
				cur = p; //그다음걸로 시작
			}
			dist += Math.abs(cur.x-dest.x)+Math.abs(cur.y-dest.y);
			if(dist<min) min = dist;
			return;
		}
		//가능한 모든 수들이 들어있는 배열 모든 원소에 대해 시도
		for(int i=0;i<N;i++) { //i:인덱스
			if(sel[i]) continue;//인덱스에 해당하는 수가 사용중인 수면 다음수로

			//다음자리순열 뽑으러 가기
			result[idx] = i;
			sel[i] = true;
			permutation(idx + 1);
			sel[i] = false;
			
		}
	}
}
