package 거리구하기;

import java.util.ArrayList;
import java.util.List;

public class Point_거리 {
	
	static class Point {
		int x,y;
		Point (int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Point start = new Point(50, 25);
		Point dest = new Point(10, 30);
		List<Point> list = new ArrayList<>();
		list.add(new Point(100, 50));
		list.add(new Point(50, 80));
		list.add(new Point(200, 100));
		//start에서 출발해서
		//list에 있는 경유지를 순서대로 찍고
		//dest로 도착할때까지 이동하는 거리는?
		int dist = 0 ;
		int sum = 0;
		Point cur = start;
		Point startc = new Point(0,0);
		for(int i=0; i < list.size() ;i++) {
			Point p = list.get(i);
			dist += Math.abs(cur.x-p.x)+Math.abs(cur.y-p.y);
			cur = p;
		}
		dist += Math.abs(cur.x-dest.x)+Math.abs(cur.y-dest.y);
		System.out.println(dist);


	}

}
