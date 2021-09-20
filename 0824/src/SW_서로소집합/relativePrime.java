package SW_서로소집합;

import java.util.Scanner;

public class relativePrime {
	
	static int T,N,M;
	static int[] parent;
	static int[] rank;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
		
			parent = new int[N+1];
			rank = new int[N+1];
			
			System.out.print("#"+tc+" ");
			
			for(int i=1 ;i<=N; i++) makeSet(i);
			
			for(int i=0;i<M;i++) {
				int op = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				if(op == 0) { //합집합 연산
					unionSet(a,b);
				}else if( op == 1){ //a,b가 같은 집합에 포함되어 있는지 확인
					if(findSet(a) == findSet(b)) System.out.print(1);
					else System.out.print(0);
				}
			}
			System.out.println();
		}
	}
	
	public static void makeSet(int x) {
			parent[x] = x;
	}
	
	public static int findSet(int x) { //부모 노드 찾아주기
		if( x == parent[x] ) return x;

		return parent[x] = findSet(parent[x]);
	}
	
	public static void unionSet(int a, int b) {
		int pa = findSet(a); //a의 팀장
		int pb = findSet(b); //b의 팀장
		
		if(pa != pb) { //팀장이 서로 다르면
			if(rank[pa] > rank[pb]) //a의 팀장의 rank가 더 크면
				parent[pb] = pa; //a의 팀장 밑으로
			else if(rank[pa] < rank[pb]) //b의 팀장이 더 크면
				parent[pa] = pb; //b의 팀장 밑으로
			else //a의 rank와 b의 rank가 같으면
				rank[pa]++; //a와 b 둘중에 하나 rank+1
		}
	}

}
