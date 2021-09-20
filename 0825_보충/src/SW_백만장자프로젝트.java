import java.util.Scanner;


public class SW_백만장자프로젝트 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int ans = 0;
			int N = sc.nextInt();
			int[] data = new int[N];
			for (int i = 0; i < N; i++) { //입력받기
				data[i] = sc.nextInt();
			}
			int max = 0;
			for (int i = N-1; i >= 0; i--) {
				if(data[i] >= max) { //기존 최대값보다 큰 경우 최대값 갱신 
					max = data[i];
					//continue;
				}
				//현재의 값이 최대값보다 작음
				ans += max - data[i];
				
			}
			System.out.println("#"+test_case+" "+ans);
			
			
		}
	}

}
