package 설탕배달_백준;

import java.util.Scanner;

public class sugar2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //3 ≤ N ≤ 5000
        int ans = 987654321;
        for(int a = 0; a <= N/5; a++) {
            for(int b = 0 ; b <= N/3; b++) {
                if( a * 5 + b * 3 == N ) {
                    ans = Math.min(ans, a + b);
                }
            }
        }
        System.out.println(ans == 987654321 ? -1 : ans);
    }
}
