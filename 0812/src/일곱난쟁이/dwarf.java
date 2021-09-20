package 일곱난쟁이;

import java.util.Arrays;
import java.util.Scanner;

public class dwarf {
	static int[] num;
	static int N=9,K=100;
	static int realChild[] = new int[7];
	static boolean end=false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

			num = new int[N];

			
			for(int i=0;i<N;i++) {
				num[i]=sc.nextInt();
			}
			powerSet(0,0,0);
			


	}
	/**
     * 일곱 난쟁이를 뽑을 수 있는 모든 경우의 수
     * @param idx 난쟁이의 위치
     * @param cnt 뽑은 난쟁이의 수
     * @param sum 뽑힌 난쟁이들 키의 합
     */
    public static void powerSet(int idx, int cnt, int sum) {
        // 키의 합이 100인 일곱 난쟁이가 다 뽑힌 상태면
        // 더이상 경우의 수를 확인할 필요가 없으므로 return
        if(end) return;
        // 일곱 난쟁이가 뽑히면
        if(cnt == 7) {
            // 뽑힌 난쟁이들의 키의 합이 100이 되는지 확인
            if(sum == K) {
                // 키의 합이 100이라면 난쟁이들의 키를 오름차순으로 정렬 후 출력
                Arrays.sort(realChild);
                for (int i = 0; i < 7; i++) 
                    System.out.println(realChild[i]);
                end = true;
            }
            return;
        }
        if(idx >= N) return;
        // 일곱 난쟁이가 뽑히기도 전에 키의 합이 100을 초과하면 return
        if(sum > K) return;
        
        realChild[cnt] = num[idx];
        powerSet(idx + 1, cnt + 1, sum + num[idx]);
        // 이 난쟁이는 안 뽑고 넘어갈래
        powerSet(idx + 1, cnt, sum);
    }
}