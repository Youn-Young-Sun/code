package 공집합아닌부분수열의합;

import java.util.Scanner;

public class subsequence3 {

	static int[] ary = {-1,0,1};
    static int K = 0;
    static int answer = 0;
    public static void main(String[] args) {
        
        int idx = 0;
        int sum = 0;
        int cnt = 0;
        powerSum(idx,sum,cnt);
        System.out.println("정답 : "+answer); //더했을 때 0이되는 개수
    }
    private static void powerSum(int idx, int sum, int cnt) {
        if(idx == ary.length) {
            if(sum == K) {
                if(cnt != 0) {
                    answer++;
                    System.out.println("개수 : "+cnt); //3개중에 몇개 더하는지
                }
            }
            return;
        }
        
        powerSum(idx+1, sum+ary[idx], cnt+1);
        powerSum(idx+1, sum, cnt);
        
    }
}


