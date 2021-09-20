package 공집합아닌부분수열의합;

public class subsequence4 {
	static int K = 0;
	static int[] ary= {-1,0,1};
	static int answer = 0;
	
	public static void main(String[] args) {
		int idx = 0;
		int sum = 0;
		int cnt = 0;
		powerSum(idx,sum,cnt);
		System.out.println(answer);
	}

	private static void powerSum(int idx, int sum, int cnt) {
		if(idx==ary.length) {
			if(sum==K) {
				if(cnt!=0) {
					answer++;
					
				}
			}
			return;
		}
		powerSum(idx+1,sum+ary[idx],cnt+1);
		powerSum(idx+1,sum,cnt);
		
	}

}
