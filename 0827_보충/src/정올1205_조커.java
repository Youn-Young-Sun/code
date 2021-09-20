
import java.util.Arrays;
import java.util.Scanner;

public class 정올1205_조커 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] cnt = new int[1000001]; //백만 숫자가 들어올수도있으니깐 
		int[] a = new int[N];
		
		for (int i = 0; i < N; i++) {
			cnt[sc.nextInt()]++;
		}
		
		int max = 0, joker = cnt[0], start = 1, end = 1;
		
		while(end <= 1000000) {
			if(cnt[end] > 0) { //연속된 숫자가 된다면 end를 이동
				end++;
			} else if(joker > 0) { //숫자가 0인 경우, joker가 있다면
				joker--;
				cnt[end] = -1; //start가 챙겨와야하니깐
				end++;
			} else if(end > start) { //숫자가 0이고, joker가 0인 경우
				max = Math.max(max, end - start);
				if(cnt[start] == -1) joker++;
				start++;
			} else { //숫자가 0이고, joker가 0인 경우, start == end 같은 위치
				end++;
				start++;
			}
			
		}
		System.out.println(Math.max(max, end - start));
	}

}
