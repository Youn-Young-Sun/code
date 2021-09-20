package 최단경로_백준;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class shortestPath_다익스트라 {
	static class Edge {
		int vertex, weight; // 정점과 거리비용

		public Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt(); //정점 개수
		int E = sc.nextInt(); //간선 개수
		int K = sc.nextInt(); //시작 정점 번호
		
		//정점 세팅
		List<Edge>[] adj = new ArrayList[V+1]; //정점 개수 만큼 배열 생성
		for (int i = 1; i <= V; i++) { //각 정점에 리스트 생성
			adj[i] = new ArrayList<Edge>();
		}
		
		//간선 세팅
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			//출발정점의 인정정보에 도착정보 넣음
			adj[from].add(new Edge(to, weight));
		}
		
		//dijkstra
		boolean[] check = new boolean[V+1]; //확보 정점 체크
		int[] dist = new int[V+1]; //거리 기록
		Arrays.fill(dist, Integer.MAX_VALUE); //처음엔 모두 무한으로 설정
		dist[K] = 0; //시작 정점의 거리 0으로
		
		//확보할 정점 찾기
		for (int i = 1; i <= V; i++) {
			int min = Integer.MAX_VALUE; //최단거리 저장 
			int index = -1; //정점 번호
			for (int j = 1; j <= V; j++) { //모든 정점 돌면서
				if(!check[j] && min > dist[j]) { //방문안했고 최단거리면
					min = dist[j]; //최단거리로 저장
					index = j; //정점도 저장
				}
			}
			
			if(index == -1) //값이 안바꼇으면 정점의 최단경로 없음
				break;
			
			check[index] = true;  //정점 확보
			//모든 경로 탐색
			for(Edge next : adj[index]) {
				if(check[next.vertex]) //확보된 곳으로 가면 패스
					continue;
				//확보 안된 정점의 거리가 확보된 정점으로 가는 거리보다 길면
				if(dist[next.vertex] > dist[index] + next.weight)
					dist[next.vertex] = dist[index] + next.weight;
			}
			
		}
		//모든 최단경로 출력(경로 존재안하면 INF 출력)
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if(dist[i] == Integer.MAX_VALUE)
				sb.append("INF").append("\n");
			else
				sb.append(dist[i]).append("\n");
		}
		System.out.println(sb);

	}

}
